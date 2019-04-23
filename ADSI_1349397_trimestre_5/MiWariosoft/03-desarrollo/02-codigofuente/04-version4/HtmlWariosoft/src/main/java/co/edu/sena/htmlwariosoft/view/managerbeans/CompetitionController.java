package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Competition;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.CompetitionFacade;

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

@Named("competitionController")
@SessionScoped
public class CompetitionController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.CompetitionFacade ejbFacade;
    private List<Competition> items = null;
    private Competition selected;

    public CompetitionController() {
    }

    public Competition getSelected() {
        return selected;
    }

    public void setSelected(Competition selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCompetitionPK().setVersion(selected.getProgram().getProgramPK().getVersion());
        selected.getCompetitionPK().setProgramCode(selected.getProgram().getProgramPK().getProgramCode());
    }

    protected void initializeEmbeddableKey() {
        selected.setCompetitionPK(new co.edu.sena.htmlwariosoft.model.entities.CompetitionPK());
    }

    private CompetitionFacade getFacade() {
        return ejbFacade;
    }

    public Competition prepareCreate() {
        selected = new Competition();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CompetitionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CompetitionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CompetitionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Competition> getItems() {
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

    public Competition getCompetition(co.edu.sena.htmlwariosoft.model.entities.CompetitionPK id) {
        return getFacade().find(id);
    }

    public List<Competition> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Competition> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Competition.class)
    public static class CompetitionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompetitionController controller = (CompetitionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "competitionController");
            return controller.getCompetition(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.CompetitionPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.CompetitionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.CompetitionPK();
            key.setCompetitionCode(values[0]);
            key.setProgramCode(values[1]);
            key.setVersion(values[2]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.CompetitionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCompetitionCode());
            sb.append(SEPARATOR);
            sb.append(value.getProgramCode());
            sb.append(SEPARATOR);
            sb.append(value.getVersion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Competition) {
                Competition o = (Competition) object;
                return getStringKey(o.getCompetitionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Competition.class.getName()});
                return null;
            }
        }

    }

}
