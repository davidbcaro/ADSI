/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.dao.mysql;

import co.edu.sena.wariosoftjpa.controller.Factory.ModalityFactory;
import co.edu.sena.wariosoftjpa.controller.dao.ModalityDAO;
import co.edu.sena.wariosoftjpa.model.jpa.entities.Modality;
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
 * @author Brayan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModalityImplTest {
    
    
    private Modality mt;
    
    public ModalityImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mt = new Modality();
        mt.setNameModality("mixta");
        mt.setState(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByNameModality method, of class ModalityImpl.
     */
    
    @Test
    public void test1Insert() {
        System.out.println("prueba de Modality metodo insert");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        if (dao.find(mt.getNameModality()) == null) {
            dao.insert(mt);
        } 
        assertEquals(dao.find(mt.getNameModality()), mt);
    }
    
    
    @Test
    public void test2find() {
        System.out.println("prueba de Modality metodo find por llave primaria");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        Modality stateNumberGroupConsultado = (Modality) dao.find(mt.getNameModality());
        assertEquals(stateNumberGroupConsultado, mt);
    }
    
    
     @Test
    public void test3update() {
        System.out.println("prueba de Modality metodo update po llave primaria");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        mt.setState(Boolean.FALSE);
        dao.update(mt);
        assertEquals(dao.find(mt.getNameModality()), mt);
    }
    
    @Test
    public void test3updatePk(){
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        int resultado= dao.updatePk("arratos", mt.getNameModality());
        assertEquals(resultado, 1);
    }
    
    
    @Test
    public void test4delete() {
        System.out.println("prueba de Modality metodo delete para la llave");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        mt.setNameModality("arratos");
        dao.remove(mt);
        assertEquals(dao.find(mt.getNameModality()), null);

    }

      @Test
    public void test5FindAll() {
        System.out.println("prueba de Modality metodo findall");
       ModalityDAO dao = ModalityFactory.create(Modality.class);
        List< Modality> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    
    @Test
    public void test6FindByNameModality() {
       
       System.out.println("prueba de Modality metodo findDescripcion del dao TipoDocumento");
         ModalityDAO dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByNameModality("mixta");
        for (Modality modality : lista) {
            assertEquals(modality.getNameModality(), "mixta");
        }
    }
     /**
     * Test of findByState method, of class ModalityImpl.
     */
    @Test
    public void test7FindByState() {
        System.out.println("findByState");
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByState(true);
        for (Modality modality : lista) {
            assertEquals(modality.getState(), true);
        }
    }

    /**
     * Test of findByLikeNameModality method, of class ModalityImpl.
     */
    @Test
    public void test8FindByLikeNameModality() {
        ModalityDAO dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByLikeNameModality("v%");
        assertTrue(!lista.isEmpty());
    }   
}
