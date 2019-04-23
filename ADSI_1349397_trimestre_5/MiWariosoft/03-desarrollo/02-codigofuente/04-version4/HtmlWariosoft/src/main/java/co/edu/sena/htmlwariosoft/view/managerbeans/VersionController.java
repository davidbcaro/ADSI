package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Version;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.VersionFacade;

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

@Named("versionController")
@SessionScoped
public class VersionController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.VersionFacade ejbFacade;
    private List<Version> items = null;
    private Version selected;

    public VersionController() {
    }

    public Version getSelected() {
        return selected;
    }

    public void setSelected(Version selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getVersionPK().setIdCurrentQuarter(selected.getCurrentQuarter().getIdCurrentQuarter());
    }

    protected void initializeEmbeddableKey() {
        selected.setVersionPK(new co.edu.sena.htmlwariosoft.model.entities.VersionPK());
    }

    private VersionFacade getFacade() {
        return ejbFacade;
    }

    public Version prepareCreate() {
        selected = new Version();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VersionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VersionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VersionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Version> getItems() {
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

    public Version getVersion(co.edu.sena.htmlwariosoft.model.entities.VersionPK id) {
        return getFacade().find(id);
    }

    public List<Version> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Version> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Version.class)
    public static class VersionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VersionController controller = (VersionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "versionController");
            return controller.getVersion(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.VersionPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.VersionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.VersionPK();
            key.setIdVersion(Integer.parseInt(values[0]));
            key.setIdCurrentQuarter(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.VersionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdVersion());
            sb.append(SEPARATOR);
            sb.append(value.getIdCurrentQuarter());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Version) {
                Version o = (Version) object;
                return getStringKey(o.getVersionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Version.class.getName()});
                return null;
            }
        }

    }

}
