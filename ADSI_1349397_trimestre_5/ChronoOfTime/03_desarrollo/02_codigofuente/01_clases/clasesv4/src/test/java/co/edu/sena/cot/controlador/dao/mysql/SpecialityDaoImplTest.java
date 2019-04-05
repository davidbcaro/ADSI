/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LevelTrainingDao;
import co.edu.sena.cot.controlador.dao.ProjectDao;
import co.edu.sena.cot.controlador.dao.SpecialityDao;
import co.edu.sena.cot.controlador.factory.mysql.LevelTrainingFactory;
import co.edu.sena.cot.controlador.factory.mysql.ProjectFactory;
import co.edu.sena.cot.controlador.factory.mysql.SpecialityFactory;
import co.edu.sena.cot.modelo.dto.LevelTrainig;
import co.edu.sena.cot.modelo.dto.Project;
import co.edu.sena.cot.modelo.dto.Speciality;
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
 * @author 1349397
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SpecialityDaoImplTest {

    Speciality sp, sp1, sp2;

    public SpecialityDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sp = new Speciality();
        sp.setName("Kyoma");
        sp.setState(true);

        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        if (dao.find(sp.getName()) == null) {
            dao.insert(sp);
        }
        assertEquals(dao.find(sp.getName()), sp);
    }

    /**
     * Test of findBystate method, of class SpecialityDaoImpl.
     */
    @Test
    public void test2Find() {
        System.out.println("prueba del nombre metodo find por llave primaria");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        Speciality nameConsultado = (Speciality) dao.find(sp.getName());
        assertEquals(nameConsultado, sp);

    }

    /**
     * Test of findByLikeName method, of class SpecialityDaoImpl.
     */
    @Test
    public void test3update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        sp.setState(true);
        dao.update(sp);
        assertEquals(dao.find(sp.getName()), sp);
    }

    /**
     * Test of findByLikestate method, of class SpecialityDaoImpl.
     */
    @Test
    public void test9Deleate() {
         System.out.println("prueba de tipo de documento metodo delete para la llave");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        sp.setName("Hououin");
        dao.remove(sp);
        assertEquals(dao.find(sp.getName()), null);
    }

    /**
     * Test of updatePrimaryKey method, of class SpecialityDaoImpl.
     */
//    @Test
//    public void test4UpdatePrimaryKey() {
//        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
//        sp.setName("Kyoma");
//        int resultado = dao.updatePrimaryKey("Hououin", sp.getName());
//        assertEquals(resultado, 1);
//    }
//    
     @Test
    public void test5FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
     @Test
    public void test6FindName() {
         System.out.println("la");
        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
        List<Speciality> lista = dao.findByName("Kyoma");
        for (Speciality sp2 : lista) {
            assertEquals(sp2.getName(), "Kyoma");
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }
//    
//    @Test
//    public void test7FindState() {
//        System.out.println("las");
//        SpecialityDao dao = SpecialityFactory.create(Speciality.class);
//        List<Speciality> lista = dao.findByState(false);
//        for (Speciality sp : lista) {
//            assertEquals(sp.getState(), false);
//        }
//        System.out.println("estados "+lista);
//    }
    
    @Test
    public void test8FindLikeName() {
        System.out.println("lassssss");
        ProjectDao dao = ProjectFactory.create(Project.class);
        List<Project> lista = dao.findByLikeName("%Ad%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

 
    /**
     * Test of findByState method, of class SpecialityDaoImpl.
     */
  

    /**
     * Test of findByLikeName method, of class SpecialityDaoImpl.
     */
 

    /**
     * Test of updatePrimaryKey method, of class SpecialityDaoImpl.
     */
//    @Test
//    public void testUpdatePrimaryKey() {
//        System.out.println("updatePrimaryKey");
//        String llaveNueva = "";
//        String llaveVieja = "";
//        SpecialityDaoImpl instance = null;
//        int expResult = 0;
//        int result = instance.updatePrimaryKey(llaveNueva, llaveVieja);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
     
  
}
