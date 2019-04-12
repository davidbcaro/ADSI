/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.ModalityDao;
import co.edu.sena.eon_jpa.controller.factory.ModalityFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Modality;
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
 * @author SOPORTE
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ModalityImplTest {

    private Modality m;

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
        m = new Modality();
        m.setModalityName("55");
        m.setState(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Inser() {
        ModalityDao dao = ModalityFactory.create(Modality.class);
        if (dao.find(m.getModalityName()) == null) {
            dao.insert(m);
        }
        assertEquals(dao.find(m.getModalityName()), m);

    }

    @Test
    public void test2Find() {
        ModalityDao dao = ModalityFactory.create(Modality.class);
        Modality modalityConsultado = (Modality) dao.find(m.getModalityName());
        assertEquals(modalityConsultado, m);

    }

    @Test
    public void test3Update() {
        ModalityDao dao = ModalityFactory.create(Modality.class);
        m.setState(Boolean.FALSE);
        dao.update(m);
        assertEquals(dao.find(m.getModalityName()), m);
    }
    @Test
    public void test3vUpdate() {
        ModalityDao dao = ModalityFactory.create(Modality.class);
        int resultado = dao.updatePrimaryKey("iiii", m.getModalityName());
        assertEquals(resultado, 1);
    }
    
    @Test
    public void test4Delete(){
       
        ModalityDao dao = ModalityFactory.create(Modality.class);
        m.setModalityName("iiii");
        dao.remove(m);
        assertEquals(dao.find(m.getModalityName()),null);
    }
    

    @Test
    public void test5FindByNameModality() {
         ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByNameModality("M");
        for (Modality modality: lista) {
            assertEquals(m.getModalityName(), true);
    
    
    }
    }

    @Test
    public void test6FindByLikeNameModality() {
    ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByLikeNameModality("M%");
        assertTrue(!lista.isEmpty());
    
    
    }

    @Test
    public void test7FindByState() {
         ModalityDao dao = ModalityFactory.create(Modality.class);
        List<Modality> lista = dao.findByState(true);
        for (Modality modality: lista) {
            assertEquals(m.getState(), true);
    
    }
    

}
}
