package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.Schedule;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.ScheduleFacade;

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

@Named("scheduleController")
@SessionScoped
public class ScheduleController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.ScheduleFacade ejbFacade;
    private List<Schedule> items = null;
    private Schedule selected;

    public ScheduleController() {
    }

    public Schedule getSelected() {
        return selected;
    }

    public void setSelected(Schedule selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSchedulePK().setNameTrimester(selected.getNumberGroupHasTrimester().getNumberGroupHasTrimesterPK().getNameTrimester());
        selected.getSchedulePK().setInitialsWorkingDay(selected.getNumberGroupHasTrimester().getNumberGroupHasTrimesterPK().getInitialsWorkingDay());
        selected.getSchedulePK().setNameHeadquarters(selected.getEnvironment().getEnvironmentPK().getNameHeadquarters());
        selected.getSchedulePK().setIdVersion(selected.getVersion().getVersionPK().getIdVersion());
        selected.getSchedulePK().setDocumentNumber(selected.getTeacher().getTeacherPK().getDocumentNumber());
        selected.getSchedulePK().setNameDay(selected.getDay().getNameDay());
        selected.getSchedulePK().setIdCurrentQuarter(selected.getVersion().getVersionPK().getIdCurrentQuarter());
        selected.getSchedulePK().setNumberEnvironment(selected.getEnvironment().getEnvironmentPK().getNumberEnvironment());
        selected.getSchedulePK().setTrainingLevel(selected.getNumberGroupHasTrimester().getNumberGroupHasTrimesterPK().getTrainingLevel());
        selected.getSchedulePK().setNumberGroup(selected.getNumberGroupHasTrimester().getNumberGroupHasTrimesterPK().getNumberGroup());
        selected.getSchedulePK().setIdDocument(selected.getTeacher().getTeacherPK().getIdDocument());
    }

    protected void initializeEmbeddableKey() {
        selected.setSchedulePK(new co.edu.sena.htmlwariosoft.model.entities.SchedulePK());
    }

    private ScheduleFacade getFacade() {
        return ejbFacade;
    }

    public Schedule prepareCreate() {
        selected = new Schedule();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ScheduleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ScheduleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ScheduleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Schedule> getItems() {
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

    public Schedule getSchedule(co.edu.sena.htmlwariosoft.model.entities.SchedulePK id) {
        return getFacade().find(id);
    }

    public List<Schedule> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Schedule> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Schedule.class)
    public static class ScheduleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ScheduleController controller = (ScheduleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "scheduleController");
            return controller.getSchedule(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.SchedulePK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.SchedulePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.SchedulePK();
            key.setNameTrimester(values[0]);
            key.setNumberGroup(values[1]);
            key.setInitialsWorkingDay(values[2]);
            key.setDocumentNumber(values[3]);
            key.setIdDocument(values[4]);
            key.setNameDay(values[5]);
            key.setNumberEnvironment(values[6]);
            key.setNameHeadquarters(values[7]);
            key.setIdVersion(Integer.parseInt(values[8]));
            key.setIdCurrentQuarter(values[9]);
            key.setTrainingLevel(values[10]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.SchedulePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNameTrimester());
            sb.append(SEPARATOR);
            sb.append(value.getNumberGroup());
            sb.append(SEPARATOR);
            sb.append(value.getInitialsWorkingDay());
            sb.append(SEPARATOR);
            sb.append(value.getDocumentNumber());
            sb.append(SEPARATOR);
            sb.append(value.getIdDocument());
            sb.append(SEPARATOR);
            sb.append(value.getNameDay());
            sb.append(SEPARATOR);
            sb.append(value.getNumberEnvironment());
            sb.append(SEPARATOR);
            sb.append(value.getNameHeadquarters());
            sb.append(SEPARATOR);
            sb.append(value.getIdVersion());
            sb.append(SEPARATOR);
            sb.append(value.getIdCurrentQuarter());
            sb.append(SEPARATOR);
            sb.append(value.getTrainingLevel());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Schedule) {
                Schedule o = (Schedule) object;
                return getStringKey(o.getSchedulePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Schedule.class.getName()});
                return null;
            }
        }

    }

}
