package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Program;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.ProgramFacade;

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

@Named("programController")
@SessionScoped
public class ProgramController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.ProgramFacade ejbFacade;
    private List<Program> items = null;
    private Program selected;

    public ProgramController() {
    }

    public Program getSelected() {
        return selected;
    }

    public void setSelected(Program selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setProgramPK(new co.edu.sena.htmlwariosoft.model.entities.ProgramPK());
    }

    private ProgramFacade getFacade() {
        return ejbFacade;
    }

    public Program prepareCreate() {
        selected = new Program();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProgramCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProgramUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProgramDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Program> getItems() {
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

    public Program getProgram(co.edu.sena.htmlwariosoft.model.entities.ProgramPK id) {
        return getFacade().find(id);
    }

    public List<Program> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Program> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Program.class)
    public static class ProgramControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramController controller = (ProgramController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programController");
            return controller.getProgram(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.ProgramPK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.ProgramPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.ProgramPK();
            key.setProgramCode(values[0]);
            key.setVersion(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.ProgramPK value) {
            StringBuilder sb = new StringBuilder();
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
            if (object instanceof Program) {
                Program o = (Program) object;
                return getStringKey(o.getProgramPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Program.class.getName()});
                return null;
            }
        }

    }

}
