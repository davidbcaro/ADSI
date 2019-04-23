package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Trimester;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.TrimesterFacade;

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

@Named("trimesterController")
@SessionScoped
public class TrimesterController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.TrimesterFacade ejbFacade;
    private List<Trimester> items = null;
    private Trimester selected;

    public TrimesterController() {
    }

    public Trimester getSelected() {
        return selected;
    }

    public void setSelected(Trimester selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTrimesterPK().setTrainingLevel(selected.getTrainingLevel1().getTrainingLevel());
        selected.getTrimesterPK().setInitialsWorkingDay(selected.getWorkingDay().getInitialsWorkingDay());
    }

    protected void initializeEmbeddableKey() {
        selected.setTrimesterPK(new co.edu.sena.htmlwariosoft.model.entities.TrimesterPK());
    }

    private TrimesterFacade getFacade() {
        return ejbFacade;
    }

    public Trimester prepareCreate() {
        selected = new Trimester();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TrimesterCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TrimesterUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TrimesterDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Trimester> getItems() {
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

    public Trimester getTrimester(co.edu.sena.htmlwariosoft.model.entities.TrimesterPK id) {
        return getFacade().find(id);
    }

    public List<Trimester> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Trimester> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Trimester.class)
    public static class TrimesterControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TrimesterController controller = (TrimesterController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "trimesterController");
            return controller.getTrimester(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.TrimesterPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.TrimesterPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.TrimesterPK();
            key.setNameTrimester(values[0]);
            key.setTrainingLevel(values[1]);
            key.setInitialsWorkingDay(values[2]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.TrimesterPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNameTrimester());
            sb.append(SEPARATOR);
            sb.append(value.getTrainingLevel());
            sb.append(SEPARATOR);
            sb.append(value.getInitialsWorkingDay());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Trimester) {
                Trimester o = (Trimester) object;
                return getStringKey(o.getTrimesterPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Trimester.class.getName()});
                return null;
            }
        }

    }

}
