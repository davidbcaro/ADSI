package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Client;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.ClientFacade;

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

@Named("clientController")
@SessionScoped
public class ClientController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.ClientFacade ejbFacade;
    private List<Client> items = null;
    private Client selected;

    public ClientController() {
    }

    public Client getSelected() {
        return selected;
    }

    public void setSelected(Client selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getClientPK().setIdDocument(selected.getDocument().getIdDocument());
    }

    protected void initializeEmbeddableKey() {
        selected.setClientPK(new co.edu.sena.htmlwariosoft.model.entities.ClientPK());
    }

    private ClientFacade getFacade() {
        return ejbFacade;
    }

    public Client prepareCreate() {
        selected = new Client();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ClientCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ClientUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ClientDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Client> getItems() {
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

    public Client getClient(co.edu.sena.htmlwariosoft.model.entities.ClientPK id) {
        return getFacade().find(id);
    }

    public List<Client> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Client> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Client.class)
    public static class ClientControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClientController controller = (ClientController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clientController");
            return controller.getClient(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.ClientPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.ClientPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.ClientPK();
            key.setDocumentNumber(values[0]);
            key.setIdDocument(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.ClientPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDocumentNumber());
            sb.append(SEPARATOR);
            sb.append(value.getIdDocument());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Client) {
                Client o = (Client) object;
                return getStringKey(o.getClientPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Client.class.getName()});
                return null;
            }
        }

    }

}
