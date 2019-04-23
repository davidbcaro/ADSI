package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Availability;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.AvailabilityFacade;

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

@Named("availabilityController")
@SessionScoped
public class AvailabilityController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.AvailabilityFacade ejbFacade;
    private List<Availability> items = null;
    private Availability selected;

    public AvailabilityController() {
    }

    public Availability getSelected() {
        return selected;
    }

    public void setSelected(Availability selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getAvailabilityPK().setIdDocument(selected.getTeacher().getTeacherPK().getIdDocument());
        selected.getAvailabilityPK().setDocumentNumber(selected.getTeacher().getTeacherPK().getDocumentNumber());
        selected.getAvailabilityPK().setNameDay(selected.getDay().getNameDay());
        selected.getAvailabilityPK().setInitialsWorkingDay(selected.getWorkingDay().getInitialsWorkingDay());
    }

    protected void initializeEmbeddableKey() {
        selected.setAvailabilityPK(new co.edu.sena.htmlwariosoft.model.entities.AvailabilityPK());
    }

    private AvailabilityFacade getFacade() {
        return ejbFacade;
    }

    public Availability prepareCreate() {
        selected = new Availability();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AvailabilityCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AvailabilityUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AvailabilityDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Availability> getItems() {
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

    public Availability getAvailability(co.edu.sena.htmlwariosoft.model.entities.AvailabilityPK id) {
        return getFacade().find(id);
    }

    public List<Availability> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Availability> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Availability.class)
    public static class AvailabilityControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AvailabilityController controller = (AvailabilityController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "availabilityController");
            return controller.getAvailability(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.AvailabilityPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.AvailabilityPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.AvailabilityPK();
            key.setStartTime(java.sql.Date.valueOf(values[0]));
            key.setInitialsWorkingDay(values[1]);
            key.setIdDocument(values[2]);
            key.setDocumentNumber(values[3]);
            key.setNameDay(values[4]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.AvailabilityPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getStartTime());
            sb.append(SEPARATOR);
            sb.append(value.getInitialsWorkingDay());
            sb.append(SEPARATOR);
            sb.append(value.getIdDocument());
            sb.append(SEPARATOR);
            sb.append(value.getDocumentNumber());
            sb.append(SEPARATOR);
            sb.append(value.getNameDay());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Availability) {
                Availability o = (Availability) object;
                return getStringKey(o.getAvailabilityPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Availability.class.getName()});
                return null;
            }
        }

    }

}
