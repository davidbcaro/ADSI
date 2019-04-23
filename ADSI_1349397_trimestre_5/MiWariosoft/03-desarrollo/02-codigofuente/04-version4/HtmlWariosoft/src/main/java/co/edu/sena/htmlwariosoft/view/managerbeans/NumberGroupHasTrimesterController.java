package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimester;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.NumberGroupHasTrimesterFacade;

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

@Named("numberGroupHasTrimesterController")
@SessionScoped
public class NumberGroupHasTrimesterController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.NumberGroupHasTrimesterFacade ejbFacade;
    private List<NumberGroupHasTrimester> items = null;
    private NumberGroupHasTrimester selected;

    public NumberGroupHasTrimesterController() {
    }

    public NumberGroupHasTrimester getSelected() {
        return selected;
    }

    public void setSelected(NumberGroupHasTrimester selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getNumberGroupHasTrimesterPK().setNumberGroup(selected.getNumberGroup1().getNumberGroup());
        selected.getNumberGroupHasTrimesterPK().setInitialsWorkingDay(selected.getTrimester().getTrimesterPK().getInitialsWorkingDay());
        selected.getNumberGroupHasTrimesterPK().setTrainingLevel(selected.getTrimester().getTrimesterPK().getTrainingLevel());
        selected.getNumberGroupHasTrimesterPK().setNameTrimester(selected.getTrimester().getTrimesterPK().getNameTrimester());
    }

    protected void initializeEmbeddableKey() {
        selected.setNumberGroupHasTrimesterPK(new co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK());
    }

    private NumberGroupHasTrimesterFacade getFacade() {
        return ejbFacade;
    }

    public NumberGroupHasTrimester prepareCreate() {
        selected = new NumberGroupHasTrimester();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("NumberGroupHasTrimesterCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("NumberGroupHasTrimesterUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("NumberGroupHasTrimesterDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<NumberGroupHasTrimester> getItems() {
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

    public NumberGroupHasTrimester getNumberGroupHasTrimester(co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK id) {
        return getFacade().find(id);
    }

    public List<NumberGroupHasTrimester> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NumberGroupHasTrimester> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NumberGroupHasTrimester.class)
    public static class NumberGroupHasTrimesterControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NumberGroupHasTrimesterController controller = (NumberGroupHasTrimesterController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "numberGroupHasTrimesterController");
            return controller.getNumberGroupHasTrimester(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK();
            key.setNumberGroup(values[0]);
            key.setNameTrimester(values[1]);
            key.setInitialsWorkingDay(values[2]);
            key.setTrainingLevel(values[3]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.NumberGroupHasTrimesterPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumberGroup());
            sb.append(SEPARATOR);
            sb.append(value.getNameTrimester());
            sb.append(SEPARATOR);
            sb.append(value.getInitialsWorkingDay());
            sb.append(SEPARATOR);
            sb.append(value.getTrainingLevel());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NumberGroupHasTrimester) {
                NumberGroupHasTrimester o = (NumberGroupHasTrimester) object;
                return getStringKey(o.getNumberGroupHasTrimesterPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NumberGroupHasTrimester.class.getName()});
                return null;
            }
        }

    }

}
