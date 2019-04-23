/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.dao.UserDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.AbstractDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.User;
import co.edu.sena.wariosoftjpa.model.jpa.entities.UserPK;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author WINDOWS 8
 */
public class UserImpl  extends AbstractDAO<User> implements UserDAO<User>{

    public UserImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> findByEmail(String email) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByEmail");
            query.setParameter("email", email);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<User> findByPassword(String password) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByPassword");
            query.setParameter("password", password);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;       
    }

    @Override
    public List<User> findByDateTerminate(String dateTerminate) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByDateTerminate");
            query.setParameter("dateTerminate", dateTerminate);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<User> findByIdDocument(String idDocument) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<User> findByDocumentNumber(String documentNumber) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;   
    }

    @Override
    public List<User> findByLikeIdDocument(String idDocument) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByIdDocument");
            query.setParameter("idDocument", idDocument);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public List<User> findByLikeDocumentNumber(String documentNumber) {
try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("User.findByLikeDocumentNumber");
            query.setParameter("documentNumber", documentNumber);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null; 
    }

    @Override
    public int updatePk(UserPK llaveNueva, UserPK llaveVieja) {
try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("User.updatePk");
            query.setParameter("idNuevo", llaveNueva.getIdDocument());
            query.setParameter("documentoNuevo", llaveNueva.getDocumentNumber());
            query.setParameter("idViejo", llaveVieja.getIdDocument());
            query.setParameter("documentoViejo", llaveVieja.getDocumentNumber());
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
        return 0;       }
    }

    

