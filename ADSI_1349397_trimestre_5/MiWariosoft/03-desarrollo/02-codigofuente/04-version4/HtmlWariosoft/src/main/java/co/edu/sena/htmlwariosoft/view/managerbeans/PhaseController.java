package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Phase;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.PhaseFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("phaseController")
@SessionScoped
public class PhaseController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.PhaseFacade ejbFacade;
    private List<Phase> items = null;
    private Phase selected;

    public PhaseController() {
    }

    public Phase getSelected() {
        return selected;
    }

    public void setSelected(Phase selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPhasePK().setProjectCode(selected.getProject().getProjectCode());
    }

    protected void initializeEmbeddableKey() {
        selected.setPhasePK(new co.edu.sena.htmlwariosoft.model.entities.PhasePK());
    }

    private PhaseFacade getFacade() {
        return ejbFacade;
    }

    public Phase prepareCreate() {
        selected = new Phase();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PhaseCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PhaseUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PhaseDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Phase> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Phase getPhase(co.edu.sena.htmlwariosoft.model.entities.PhasePK id) {
        return getFacade().find(id);
    }

    public List<Phase> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Phase> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Phase.class)
    public static class PhaseControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PhaseController controller = (PhaseController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "phaseController");
            return controller.getPhase(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.PhasePK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.PhasePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.PhasePK();
            key.setNamePhase(values[0]);
            key.setProjectCode(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.PhasePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNamePhase());
            sb.append(SEPARATOR);
            sb.append(value.getProjectCode());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Phase) {
                Phase o = (Phase) object;
                return getStringKey(o.getPhasePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Phase.class.getName()});
                return null;
            }
        }

    }

}
