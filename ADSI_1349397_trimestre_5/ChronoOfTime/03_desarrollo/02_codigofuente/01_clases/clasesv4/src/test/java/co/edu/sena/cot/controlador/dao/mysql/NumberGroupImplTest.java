/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.NumberGroupDao;
import co.edu.sena.cot.controlador.factory.mysql.NumberGroupFactory;
import co.edu.sena.cot.modelo.dto.NumberGroup;
import static co.edu.sena.cot.modelo.dto.NumberGroup_.dateStart;
import co.edu.sena.cot.modelo.dto.Program;
import co.edu.sena.cot.modelo.dto.ProgramPK;
import co.edu.sena.cot.modelo.dto.StateNumberGroup;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class NumberGroupImplTest {
    
    private NumberGroup numberGroup;
    
    public NumberGroupImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "23-01-2017";
        Date dateStart = sdf.parse(dateInString);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy");
        String dateInString2 = "16-12-2018";
        Date dateEnd = sdf2.parse(dateInString2);
        numberGroup = new NumberGroup();
        numberGroup.setNumberGroup(4562);
        numberGroup.setDateStart(dateStart);
        numberGroup.setDateEnd(dateEnd);
        numberGroup.setRoute("ruta 1g ficha 4562");
        numberGroup.setState(new StateNumberGroup(true));
        numberGroup.setProgram(new Program(228106, "v 102"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByNumberGroup method, of class NumberGroupImpl.
     */
    
    @Test
    public void test1Insert() {
        
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        if (dao.find(numberGroup.getNumberGroup()) == null) {
            dao.insert(numberGroup);
        } 
        assertEquals(dao.find(numberGroup.getNumberGroup()), numberGroup);
    }
    
    @Test
    public void test2find() {
        
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        NumberGroup numberGroup2 = (NumberGroup) dao.find(numberGroup.getNumberGroup());
        assertEquals(numberGroup2, numberGroup);
    }
    
     @Test
    public void test3update() {
        
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        numberGroup.setRoute("ruta diferente");
        dao.update(numberGroup);
        assertEquals(dao.find(numberGroup.getNumberGroup()), numberGroup);
    }
    
        @Test
    public void test4UpdatePrimaryKey(){
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        numberGroup.setNumberGroup(4562);
        int resultado = dao.updatePrimaryKey(54321, numberGroup.getNumberGroup());
        assertEquals(resultado, 1);
    
    }
    
     @Test
    public void test5delete() {
        
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        numberGroup.setNumberGroup(54321);
        dao.remove(numberGroup);
        assertEquals(dao.find(numberGroup.getNumberGroup()), null);

    }
    
    @Test
    public void test6FindAll() {
        
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void testFindByNumberGroup() {
        System.out.println("la");
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByNumberGroup(1349397);
        for (NumberGroup numberGroup2 : lista) {
            //assertEquals(numberGroup2.getNumberGroup(), 1349397);
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByDateStart method, of class NumberGroupImpl.
     */
    @Test
    public void testFindByDateStart() throws ParseException {
        System.out.println("la");
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        SimpleDateFormat by = new SimpleDateFormat("dd-MM-yyyy");
        Date by2 = by.parse("23-01-2017");
        List<NumberGroup> lista = dao.findByDateStart(by2);
        for (NumberGroup numberGroup2 : lista) {
            assertEquals(numberGroup2.getDateStart(), by2);
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByDateEnd method, of class NumberGroupImpl.
     */
    @Test
    public void testFindByDateEnd() throws ParseException {
        System.out.println("la");
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        SimpleDateFormat by = new SimpleDateFormat("dd-MM-yyyy");
        Date by2 = by.parse("16-12-2018");
        List<NumberGroup> lista = dao.findByDateStart(by2);
        for (NumberGroup numberGroup2 : lista) {
            assertEquals(numberGroup2.getDateStart(), by2);
        }
         System.out.println("en la lista estan estos objetos "+ lista);
    }

    /**
     * Test of findByRoute method, of class NumberGroupImpl.
     */
    @Test
    public void testFindByRoute() {
        System.out.println("las");
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByRoute("ruta 1g ficha 4562");
        for (NumberGroup numberGroup2 : lista) {
            assertEquals(numberGroup2.getRoute(), "ruta 1g ficha 4562");
        }
        System.out.println("estados "+lista);
    }

    /**
     * Test of findByState method, of class NumberGroupImpl.
     */
//    @Test
//    public void testFindByState() {
//        NumberGroupDao dao = NumberGroupFactory.create(StateNumberGroup.class);
//        List<StateNumberGroup> lista = dao.findByState(true);
//        assertTrue(!lista.isEmpty());
//        for (StateNumberGroup numberGroup2 : lista) {
//            assertEquals(numberGroup2.getState(), true);
//        }
//         System.out.println("en la lista estan estos objetos "+ lista);
//    }

    /**
     * Test of findByProgramCode method, of class NumberGroupImpl.
     */
//    @Test
//    public void testFindByProgramCode() {
//        NumberGroupDao dao = NumberGroupFactory.create(Program.class);
//        List<Program> lista = dao.findByProgramCode(228106);
//        assertTrue(!lista.isEmpty());
//        for (Program program : lista) {
//            assertEquals(program.getProgramPK().getCodeProgram(), 228106);
//        }
//         System.out.println("en la lista estan estos objetos "+ lista);
//    }

    /**
     * Test of findByProgramEdition method, of class NumberGroupImpl.
     */
//    @Test
//    public void testFindByProgramEdition() {
//       NumberGroupDao dao = NumberGroupFactory.create(Program.class);
//        List<Program> lista = dao.findByProgramEdition("v 102");
//        assertTrue(!lista.isEmpty());
//        for (Program program : lista) {
//            assertEquals(program.getProgramPK().getEdition(), "v 102");
//        }
//         System.out.println("en la lista estan estos objetos "+ lista);
//    }

    /**
     * Test of findByLikeNumberGroup method, of class NumberGroupImpl.
     */
    @Test
    public void testFindByLikeNumberGroup() {
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeNumberGroup("%1%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of finfByLikeRoute method, of class NumberGroupImpl.
     */
    @Test
    public void testFinfByLikeRoute() {
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeRoute("%R%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeProgramCode method, of class NumberGroupImpl.
     */
    @Test
    public void testFindByLikeProgramCode() {
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeProgramCode("%2%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of findByLikeProgramEdition method, of class NumberGroupImpl.
     */
    @Test
    public void testFindByLikeProgramEdition() {
        NumberGroupDao dao = NumberGroupFactory.create(NumberGroup.class);
        List<NumberGroup> lista = dao.findByLikeProgramEdition("%v%");
        assertTrue(!lista.isEmpty());
        System.out.println("nananan "+ lista);
    }

    /**
     * Test of updatePrimaryKey method, of class NumberGroupImpl.
     */
//    @Test
//    public void testUpdatePrimaryKey() {
//        System.out.println("updatePrimaryKey");
//        int llaveNueva = 0;
//        int llaveVieja = 0;
//        NumberGroupImpl instance = null;
//        int expResult = 0;
//        int result = instance.updatePrimaryKey(llaveNueva, llaveVieja);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
