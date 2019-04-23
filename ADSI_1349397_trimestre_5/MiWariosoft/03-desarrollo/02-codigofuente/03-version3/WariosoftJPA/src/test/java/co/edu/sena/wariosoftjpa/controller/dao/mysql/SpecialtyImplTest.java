/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.SpecialtyFactory;
import co.edu.sena.wariosoftjpa.controller.dao.SpecialtyDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Specialty;
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
public class SpecialtyImplTest {
    
     private Specialty st;
    
    public SpecialtyImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        st = new Specialty();
        st.setNameSpecialty("una");
        st.setState(true);
    }
    
    @After
    public void tearDown() {
        
        
    }
    
    @Test
    public void test1Insert() {
       System.out.println("prueba de tipo de StateNumberGroup metodo insert");
       SpecialtyDAO dao = SpecialtyFactory.create(Specialty.class);
        if (dao.find(st.getNameSpecialty()) == null) {
            dao.insert(st);
        } 
        assertEquals(dao.find(st.getNameSpecialty()), st);
    }
    
    
    @Test
    public void test2find() {
        System.out.println("prueba de StateNumberGroup metodo find por llave primaria");
        SpecialtyDAO dao = SpecialtyFactory.create(Specialty.class);
        Specialty stateNumberGroupConsultado = (Specialty) dao.find(st.getNameSpecialty());
        assertEquals(stateNumberGroupConsultado, st);
    }
    
    
     @Test
    public void test3update() {
        System.out.println("prueba de StateNumberGroup metodo update po llave primaria");
        SpecialtyDAO dao =   SpecialtyFactory.create(Specialty.class);
        st.setState(Boolean.FALSE);
        dao.update(st);
        assertEquals(dao.find(st.getNameSpecialty()), st);
    }
    
    @Test
    public void test3updatePk(){
         SpecialtyDAO dao = SpecialtyFactory.create(Specialty.class);
        int resultado= dao.updatePk("JJJJ", st.getNameSpecialty());
        assertEquals(resultado, 1);
    }
    
    
    @Test
    public void test4delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        SpecialtyDAO dao =  SpecialtyFactory.create( Specialty.class);
        st.setNameSpecialty("JJJJ");
        dao.remove(st);
        assertEquals(dao.find(st.getNameSpecialty()), null);

    }

      @Test
    public void test5FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
       SpecialtyDAO dao =  SpecialtyFactory.create( Specialty.class);
        List< Specialty> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    /**
     * Test of findByNameSpecialty method, of class SpecialtyImpl.
     */
    @Test
    public void test6FindByNameSpecialty() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
         SpecialtyDAO dao = SpecialtyFactory.create(Specialty.class);
        List<Specialty> lista = dao.findByNameSpecialty("uno");
        for (Specialty stateNumberGroup : lista) {
            assertEquals(stateNumberGroup.getNameSpecialty(), "uno");
        }
        
        
    }

    /**
     * Test of findByState method, of class SpecialtyImpl.
     */
    @Test
    public void test7FindByState() {
         System.out.println("findByState");
        SpecialtyDAO dao = SpecialtyFactory.create(Specialty.class);
        List<Specialty> lista = dao.findByState(true);
        for (Specialty specialty : lista) {
            assertEquals(specialty.getState() , true);
        }
        
        
    }

    /**
     * Test of findByLikeNameSpecialty method, of class SpecialtyImpl.
     */
    @Test
    public void test8FindByLikeNameSpecialty() {
        
        SpecialtyDAO dao = SpecialtyFactory.create(Specialty.class);
        List<Specialty> lista = dao.findByLikeNameSpecialty("Tel%");
        assertTrue(!lista.isEmpty());
    }
    }

    /**
     * Test of updatePk method, of class SpecialtyImpl.
     */
 
    

