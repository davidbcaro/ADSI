package co.edu.sena.htmlwariosoft.view.managerbeans;

import co.edu.sena.htmlwariosoft.model.entities.LearningOutcome;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil;
import co.edu.sena.htmlwariosoft.view.managerbeans.util.JsfUtil.PersistAction;
import co.edu.sena.htmlwariosoft.controller.ejbs.LearningOutcomeFacade;

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

@Named("learningOutcomeController")
@SessionScoped
public class LearningOutcomeController implements Serializable {

    @EJB
    private co.edu.sena.htmlwariosoft.controller.ejbs.LearningOutcomeFacade ejbFacade;
    private List<LearningOutcome> items = null;
    private LearningOutcome selected;

    public LearningOutcomeController() {
    }

    public LearningOutcome getSelected() {
        return selected;
    }

    public void setSelected(LearningOutcome selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getLearningOutcomePK().setCompetitionCode(selected.getCompetition().getCompetitionPK().getCompetitionCode());
        selected.getLearningOutcomePK().setVersion(selected.getCompetition().getCompetitionPK().getVersion());
        selected.getLearningOutcomePK().setProgramCode(selected.getCompetition().getCompetitionPK().getProgramCode());
    }

    protected void initializeEmbeddableKey() {
        selected.setLearningOutcomePK(new co.edu.sena.htmlwariosoft.model.entities.LearningOutcomePK());
    }

    private LearningOutcomeFacade getFacade() {
        return ejbFacade;
    }

    public LearningOutcome prepareCreate() {
        selected = new LearningOutcome();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LearningOutcomeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LearningOutcomeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LearningOutcomeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LearningOutcome> getItems() {
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

    public LearningOutcome getLearningOutcome(co.edu.sena.htmlwariosoft.model.entities.LearningOutcomePK id) {
        return getFacade().find(id);
    }

    public List<LearningOutcome> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LearningOutcome> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LearningOutcome.class)
    public static class LearningOutcomeControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LearningOutcomeController controller = (LearningOutcomeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "learningOutcomeController");
            return controller.getLearningOutcome(getKey(value));
        }

        co.edu.sena.htmlwariosoft.model.entities.LearningOutcomePK getKey(String value) {
            co.edu.sena.htmlwariosoft.model.entities.LearningOutcomePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.htmlwariosoft.model.entities.LearningOutcomePK();
            key.setLearningOutcomeCode(values[0]);
            key.setCompetitionCode(values[1]);
            key.setProgramCode(values[2]);
            key.setVersion(values[3]);
            return key;
        }

        String getStringKey(co.edu.sena.htmlwariosoft.model.entities.LearningOutcomePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getLearningOutcomeCode());
            sb.append(SEPARATOR);
            sb.append(value.getCompetitionCode());
            sb.append(SEPARATOR);
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
            if (object instanceof LearningOutcome) {
                LearningOutcome o = (LearningOutcome) object;
                return getStringKey(o.getLearningOutcomePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LearningOutcome.class.getName()});
                return null;
            }
        }

    }

}
