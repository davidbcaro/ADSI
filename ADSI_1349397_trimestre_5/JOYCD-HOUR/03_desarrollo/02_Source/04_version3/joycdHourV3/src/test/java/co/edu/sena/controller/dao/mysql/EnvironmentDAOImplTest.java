/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.EnvironmentDAO;
import co.edu.sena.controller.factory.EnvironmentFactory;
import co.edu.sena.model.jpa.entities.Environment;
import co.edu.sena.model.jpa.entities.EnvironmentPK;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Chritian
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnvironmentDAOImplTest {

    private Environment environment;
    private EnvironmentPK environmentPk;

    public EnvironmentDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        environment = new Environment();

        environment.setDescription("ambiente blabla ");
        environment.setStatus(Boolean.TRUE);
        environment.setEnvironmentPK(new EnvironmentPK("1011","sede barrio colombia"));
        
        environmentPk = new EnvironmentPK("1000","sede barrio colombia");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByDescription method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test01Insert() {
        System.out.println("Prueba insert de Environment");
        EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        if (dao.find(environment.getEnvironmentPK()) == null) {
            dao.insert(environment);
        }
        assertEquals(dao.find(environment.getEnvironmentPK()), environment);
    }

    @Test
    public void test02Find() {
        System.out.println("Prueba de find fase");
        EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        Environment Environmentconsulta = (Environment) dao.find(environment.getEnvironmentPK());
        assertEquals(Environmentconsulta, environment);
        System.out.println(Environmentconsulta);
    }

    @Test
    public void test03FindByDescription() {
        System.out.println("prueba de  metodo findByDescription");
        EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByDescription("ambiente blabla ");
        for (Environment wor : lista) {
            assertEquals(wor.getDescription(), "ambiente blabla ");
        }
    }

    /**
     * Test of findByStatus method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test04FindByStatus() {
     System.out.println("prueba de  metodo findbystatus");
        EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByStatus(true);
        for (Environment wor : lista) {
            assertEquals(wor.getStatus(), true);
        }
    }

    /**
     * Test of findByHeadquartersNamePK method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test05FindByHeadquartersNamePK() {
       System.out.println("prueba de  metodo findbyHeadquartersNamepk");
        EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByHeadQuartersName("sede barrio colombia");
        for (Environment wor : lista) {
            assertEquals(wor.getEnvironmentPK().getHeadquartersName(), "sede barrio colombia");
        }
    }

    /**
     * Test of findByLikeNumberEnvironment method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test06FindByLikeNumberEnvironment() {
       EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByLikeNumberEnvironment("%1%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeDescription method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test07FindByLikeDescription() {
       EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByLikeDescription("%a%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByLikeHeadquartersNamePK method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test08FindByLikeHeadquartersNamePK() {
         EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByLikeHeadQuartersName("%s%");
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of updatePrimaryKey method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test09UpdatePrimaryKey() {
  EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        dao.updatePrimaryKey(environmentPk, environment.getEnvironmentPK());
        environment.setEnvironmentPK(environmentPk);
        assertEquals(dao.find(environmentPk), environment);
    
    }
      
    /**
     * Test of findByNumberEnvironment method, of class EnvironmentDAOImpl.
     */
    @Test
    public void test10FindByNumberEnvironment() {
         EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        List<Environment> lista = dao.findByNumberEnvironment("100");
        for (Environment wor : lista) {
            assertEquals(wor.getEnvironmentPK().getNumberEnvironment(), "100");
        }
    }
    
    @Test
    public void test11delete() {
        System.out.println("Prueba del Delete");
            EnvironmentDAO dao = EnvironmentFactory.create(Environment.class);
        
            environment.setEnvironmentPK(new EnvironmentPK("1000","sede barrio colombia"));
        dao.remove(environment);
        assertEquals(dao.find(environment.getEnvironmentPK()), null);
    }

}
