/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.ScheduleDAO;
import co.edu.sena.model.jpa.entities.Schedule;
import co.edu.sena.model.jpa.entities.SchedulePK;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author liosalfar
 */
public class ScheduleDAOImpl extends AbstractDao<Schedule> implements ScheduleDAO<Schedule> {

    public ScheduleDAOImpl(Class<Schedule> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Schedule> findByHourStart(String hourStart) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByHourStart");
            query.setParameter("hourStart", hourStart);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByHourEnd(String hourEnd) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByHourEnd");
            query.setParameter("hourEnd", hourEnd);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByScheduleFinish(Date scheduleFinish) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByScheduleFinish");
            query.setParameter("scheduleFinish", scheduleFinish);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByNameModality(String nameModality) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByNameModality");
            query.setParameter("nameModality", nameModality);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByVersion(int version) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByVersion");
            query.setParameter("version", version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByVersionActualityTrimester(String versionactuAlityTrimester) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByVersionActualityTrimester");
            query.setParameter("versionActualityTrimester", versionactuAlityTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByNumberEnvironment(String numberEnvironment) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByNumberEnvironment");
            query.setParameter("numberEnvironment", numberEnvironment);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByHeadquartersName(String headquartersName) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByHeadquartersName");
            query.setParameter("headquartersName", headquartersName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByDocumentType(String documentType) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByDocumentType");
            query.setParameter("documentType", documentType);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByIdentificationCardNumber(String identificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByIdentificationCardNumber");
            query.setParameter("identificationCardNumber", identificationCardNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByGroupsNumber(String groupsNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByGroupsNumber");
            query.setParameter("groupsNumber", groupsNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByTrimesterName(String trimesterName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByTrimesterName");
            query.setParameter("trimesterName", trimesterName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByWorkingDayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByLevelFormation(String levelFormation) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    // metodos LIKE 
    @Override
    public List<Schedule> findByLikeHourStart(String hourStart) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeHourStart");
            query.setParameter("hourStart", hourStart);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByLikeHourEnd(String hourEnd) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeHourEnd");
            query.setParameter("hourEnd", hourEnd);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByLikeScheduleFinish(Date scheduleFinish) {

        // ENTERO :V 
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Schedule s WHERE s.scheduleFinish LIKE ? ",Schedule.class);
            query.setParameter("scheduleFinish", scheduleFinish);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByLikeNameModality(String nameModality) {

        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeNameModality");
            query.setParameter("nameModality", nameModality);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeVersion(String version) {
        // ENTERO :V
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM joycd.schedule s WHERE version LIKE ? ", Schedule.class);
            query.setParameter("version", version);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Schedule> findByLikeVersionActualityTrimester(String actualityTrimester) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByVersionActualityTrimester");
            query.setParameter("actualityTrimester", actualityTrimester);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeNumberEnvironment(String numberEnvironment) {
        // ENTERO :v 

        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Schedule s WHERE s.numberEnvironment LIKE ? ",Schedule.class);
            query.setParameter("numberEnvironment", numberEnvironment);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeHeadquartersName(String headquartersName) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeHeadquartersName");
            query.setParameter("headquartersName", headquartersName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeNameDay(String nameDay) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeNameDay");
            query.setParameter("nameDay", nameDay);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeDocumentType(String documentType) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeDocumentType");
            query.setParameter("documentType", documentType);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeIdentificationCardNumber(String identificationCardNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeIdentificationCardNumber");
            query.setParameter("identificationCardNumber", identificationCardNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeGroupsNumber(String groupsNumber) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeGroupsNumber");
            query.setParameter("groupsNumber", groupsNumber);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeTrimesterName(String trimesterName) {
        // ENTERO :v   
        try {
            this.getEntityManager();
            Query query = this.em.createNativeQuery("SELECT * FROM Schedule s WHERE s.trimesterName LIKE ? ",Schedule.class);
            query.setParameter("trimesterName", trimesterName);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeWorkingDayInitials(String workingDayInitials) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeWorkingDayInitials");
            query.setParameter("workingDayInitials", workingDayInitials);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Schedule> findByLikeLevelFormation(String levelFormation) {
                try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("Schedule.findByLikeLevelFormation");
            query.setParameter("levelFormation", levelFormation);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }

    // metodo update
    @Override
    public int updatePrimaryKey(SchedulePK llaveNueva, SchedulePK llaveVieja) {
        
               try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Schedule.updatePrimaryKey");
            // llaves nuevas query
            query.setParameter("documentTypeNew", llaveNueva.getDocumentType());
            query.setParameter("groupsNumberNew", llaveNueva.getGroupsNumber());
            query.setParameter("headquartersNameNew", llaveNueva.getHeadquartersName());
            query.setParameter("identificationCardNumberNew", llaveNueva.getIdentificationCardNumber());
            query.setParameter("levelFormationNew", llaveNueva.getLevelFormation());
            query.setParameter("nameDayNew", llaveNueva.getNameDay());
            query.setParameter("numberEnvironmentNew", llaveNueva.getNumberEnvironment());
            query.setParameter("trimesterNameNew", llaveNueva.getTrimesterName());
            query.setParameter("versionNew", llaveNueva.getVersion());
            query.setParameter("versionActualityTrimesterNew", llaveNueva.getVersionActualityTrimester());
            query.setParameter("workingDayInitialsNew", llaveNueva.getWorkingDayInitials());

            // llaves antiguas 
            query.setParameter("documentTypeOld", llaveNueva.getDocumentType());
            query.setParameter("groupsNumberOld", llaveNueva.getGroupsNumber());
            query.setParameter("headquartersNameOld", llaveNueva.getHeadquartersName());
            query.setParameter("identificationCardNumberOld", llaveNueva.getIdentificationCardNumber());
            query.setParameter("levelFormationOld", llaveNueva.getLevelFormation());
            query.setParameter("nameDayOld", llaveNueva.getNameDay());
            query.setParameter("numberEnvironmentOld", llaveNueva.getNumberEnvironment());
            query.setParameter("trimesterNameOld", llaveNueva.getTrimesterName());
            query.setParameter("versionOld", llaveNueva.getVersion());
            query.setParameter("versionActualityTrimesterOld", llaveNueva.getVersionActualityTrimester());
            query.setParameter("workingDayInitialsOld", llaveNueva.getWorkingDayInitials());
            
            this.em.getTransaction().begin();
            int res =query.executeUpdate();
            this.em.getTransaction().commit();
            
            return res;
            }else{
                return 0;
            }
            
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return 0;
 
    }

}
