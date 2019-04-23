package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.RoleHasClient;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.RoleHasClientFacade;

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

@Named("roleHasClientController")
@SessionScoped
public class RoleHasClientController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.RoleHasClientFacade ejbFacade;
    private List<RoleHasClient> items = null;
    private RoleHasClient selected;

    public RoleHasClientController() {
    }

    public RoleHasClient getSelected() {
        return selected;
    }

    public void setSelected(RoleHasClient selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRoleHasClientPK().setDocumentNumber(selected.getClient().getClientPK().getDocumentNumber());
        selected.getRoleHasClientPK().setIdDocument(selected.getClient().getClientPK().getIdDocument());
        selected.getRoleHasClientPK().setIdRole(selected.getRole().getIdRole());
    }

    protected void initializeEmbeddableKey() {
        selected.setRoleHasClientPK(new co.edu.sena.htmlwariosoft.model.entities.RoleHasClientPK());
    }

    private RoleHasClientFacade getFacade() {
        return ejbFacade;
    }

    public RoleHasClient prepareCreate() {
        selected = new RoleHasClient();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RoleHasClientCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RoleHasClientUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RoleHasClientDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RoleHasClient> getItems() {
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

    public RoleHasClient getRoleHasClient(co.edu.sena.htmlwariosoft.model.entities.RoleHasClientPK id) {
        return getFacade().find(id);
    }

    public List<RoleHasClient> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RoleHasClient> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RoleHasClient.class)
    public static class RoleHasClientControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RoleHasClientController controller = (RoleHasClientController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "roleHasClientController");
            return controller.getRoleHasClient(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.RoleHasClientPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.RoleHasClientPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.RoleHasClientPK();
            key.setIdDocument(values[0]);
            key.setDocumentNumber(values[1]);
            key.setIdRole(values[2]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.RoleHasClientPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdDocument());
            sb.append(SEPARATOR);
            sb.append(value.getDocumentNumber());
            sb.append(SEPARATOR);
            sb.append(value.getIdRole());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof RoleHasClient) {
                RoleHasClient o = (RoleHasClient) object;
                return getStringKey(o.getRoleHasClientPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RoleHasClient.class.getName()});
                return null;
            }
        }

    }

}
