package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Teacher;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.TeacherFacade;

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

@Named("teacherController")
@SessionScoped
public class TeacherController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.TeacherFacade ejbFacade;
    private List<Teacher> items = null;
    private Teacher selected;

    public TeacherController() {
    }

    public Teacher getSelected() {
        return selected;
    }

    public void setSelected(Teacher selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTeacherPK().setDocumentNumber(selected.getClient().getClientPK().getDocumentNumber());
        selected.getTeacherPK().setIdDocument(selected.getClient().getClientPK().getIdDocument());
    }

    protected void initializeEmbeddableKey() {
        selected.setTeacherPK(new co.edu.sena.htmlwariosoft.model.entities.TeacherPK());
    }

    private TeacherFacade getFacade() {
        return ejbFacade;
    }

    public Teacher prepareCreate() {
        selected = new Teacher();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TeacherCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TeacherUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TeacherDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Teacher> getItems() {
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

    public Teacher getTeacher(co.edu.sena.htmlwariosoft.model.entities.TeacherPK id) {
        return getFacade().find(id);
    }

    public List<Teacher> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Teacher> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Teacher.class)
    public static class TeacherControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TeacherController controller = (TeacherController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "teacherController");
            return controller.getTeacher(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.TeacherPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.TeacherPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.TeacherPK();
            key.setIdDocument(values[0]);
            key.setDocumentNumber(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.TeacherPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdDocument());
            sb.append(SEPARATOR);
            sb.append(value.getDocumentNumber());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Teacher) {
                Teacher o = (Teacher) object;
                return getStringKey(o.getTeacherPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Teacher.class.getName()});
                return null;
            }
        }

    }

}
