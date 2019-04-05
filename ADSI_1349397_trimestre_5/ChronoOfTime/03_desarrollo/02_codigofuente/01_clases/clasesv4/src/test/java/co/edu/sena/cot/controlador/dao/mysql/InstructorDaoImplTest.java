/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.InstructorDao;
import co.edu.sena.cot.controlador.dao.LinkUpDao;
import co.edu.sena.cot.controlador.dao.ProgramDao;
import co.edu.sena.cot.controlador.factory.mysql.InstructorFactory;
import co.edu.sena.cot.controlador.factory.mysql.LinkUpFactory;
import co.edu.sena.cot.controlador.factory.mysql.ProgramFactory;
import co.edu.sena.cot.modelo.dto.Instructor;
import co.edu.sena.cot.modelo.dto.InstructorPK;
import co.edu.sena.cot.modelo.dto.LinkUp;
import co.edu.sena.cot.modelo.dto.Program;
import co.edu.sena.cot.modelo.dto.ProgramPK;
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
public class InstructorDaoImplTest {

    private Instructor in;
    private InstructorPK inPK;

    public InstructorDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        in = new Instructor();
        in.setInstructorPK(new InstructorPK(10304731, "CC"));
        in.setSpecialityName(new Speciality("Telecomunicaciones"));
        in.setLinkuTol(new LinkUp("Medio Tiempo"));
        
        inPK = new InstructorPK(1013686807, "CC");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findBySpecialityName method, of class InstructorDaoImpl.
     */
    @Test
    public void test01Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        if (dao.find(in.getInstructorPK()) == null) {
            dao.insert(in);
        }
        assertEquals(dao.find(in.getInstructorPK()), in);
    }

    @Test
    public void test02Find() {
        System.out.println("prueba del nombre metodo find por llave primaria");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        Instructor nameConsultado = (Instructor) dao.find(in.getInstructorPK());
        assertEquals(nameConsultado, in);

    }

    @Test
    public void test03update() {
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        dao.updatePrimaryKey(inPK, in.getInstructorPK());
        in.setInstructorPK(inPK);
        assertEquals(dao.find(inPK), in);
                           
        }
    
    
    @Test
    public void test13Deleate() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        in.setInstructorPK(new InstructorPK(1013686807, "CC"));
        dao.remove(in);
        assertEquals(dao.find(in.getInstructorPK()), null);
    }

    @Test
    public void test04FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test05FindBySpecialityName() {

        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findBySpecialityName("Teleinformatica");
        assertTrue(!lista.isEmpty());
        for (Instructor in : lista) {
            assertEquals(in.getSpecialityName().getName(), "Teleinformatica");
        }
        System.out.println("en la lista estan estos objetos " + lista);

    }

    @Test
    public void test06FindByTypeLink() {
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByTypeLink("Medio Tiempo");
        assertTrue(!lista.isEmpty());
        for (Instructor in : lista){
            assertEquals(in.getLinkuTol().getTypeLink(), "Medio Tiempo");

        }
    }

    /**
     * Test of findByNumberDocument method, of class InstructorDaoImpl.
     */
    @Test
    public void test07FindByNumberDocument() {
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByNumberDocument(123456789);
        assertTrue(!lista.isEmpty());
        for (Instructor in : lista){
            assertEquals(in.getInstructorPK().getNumberDocument(), 123456789);

        }
    }

    /**
     * Test of findByDocument method, of class InstructorDaoImpl.
     */
    @Test
    public void test08FindByDocument() {
       InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByDocument("CC");
        assertTrue(!lista.isEmpty());
        for (Instructor in : lista){
            assertEquals(in.getInstructorPK().getDocument(), "CC");

        }
    }

    /**
     * Test of findByLikeSpecialityName method, of class InstructorDaoImpl.
     */
    @Test
    public void test09FindByLikeSpecialityName() {
       InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByLikeSpecialityName("%T%");
        assertTrue(!lista.isEmpty()); 
            System.out.println("Estas son los nombres "+lista);
    }

    /**
     * Test of findByLikeTypeLink method, of class InstructorDaoImpl.
     */
    @Test
    public void test10FindByLikeTypeLink() {
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByLikeTypeLink("%M%");
        assertTrue(!lista.isEmpty()); 
            System.out.println("Estas son los nombres "+lista);
    }

    /**
     * Test of findByLikeNumberDocument method, of class InstructorDaoImpl.
     */
    @Test
    public void test11FindByLikeNumberDocument() {
         InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByLikeNumberDocument("%10%");
        assertTrue(!lista.isEmpty()); 
            System.out.println("Estas son los nombres "+lista);
    }

    /**
     * Test of findByLikeDocument method, of class InstructorDaoImpl.
     */
    @Test
    public void test12FindByLikeDocument() {
        InstructorDao dao = InstructorFactory.create(Instructor.class);
        List<Instructor> lista = dao.findByLikeDocument("%C%");
        assertTrue(!lista.isEmpty()); 
            System.out.println("Estas son los nombres "+lista);
    }

    /**
     * Test of updatePrimaryKey method, of class InstructorDaoImpl.
     */
   

}
