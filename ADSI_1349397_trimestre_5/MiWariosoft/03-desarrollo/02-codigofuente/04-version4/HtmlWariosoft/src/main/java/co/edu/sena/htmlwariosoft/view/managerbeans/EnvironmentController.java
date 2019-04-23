package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Environment;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.EnvironmentFacade;

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

@Named("environmentController")
@SessionScoped
public class EnvironmentController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.EnvironmentFacade ejbFacade;
    private List<Environment> items = null;
    private Environment selected;

    public EnvironmentController() {
    }

    public Environment getSelected() {
        return selected;
    }

    public void setSelected(Environment selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEnvironmentPK().setNameHeadquarters(selected.getHeadquarters().getNameHeadquarters());
    }

    protected void initializeEmbeddableKey() {
        selected.setEnvironmentPK(new co.edu.sena.htmlwariosoft.model.entities.EnvironmentPK());
    }

    private EnvironmentFacade getFacade() {
        return ejbFacade;
    }

    public Environment prepareCreate() {
        selected = new Environment();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EnvironmentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EnvironmentUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EnvironmentDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Environment> getItems() {
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

    public Environment getEnvironment(co.edu.sena.htmlwariosoft.model.entities.EnvironmentPK id) {
        return getFacade().find(id);
    }

    public List<Environment> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Environment> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Environment.class)
    public static class EnvironmentControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EnvironmentController controller = (EnvironmentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "environmentController");
            return controller.getEnvironment(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.EnvironmentPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.EnvironmentPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.EnvironmentPK();
            key.setNumberEnvironment(values[0]);
            key.setNameHeadquarters(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.EnvironmentPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumberEnvironment());
            sb.append(SEPARATOR);
            sb.append(value.getNameHeadquarters());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Environment) {
                Environment o = (Environment) object;
                return getStringKey(o.getEnvironmentPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Environment.class.getName()});
                return null;
            }
        }

    }

}
