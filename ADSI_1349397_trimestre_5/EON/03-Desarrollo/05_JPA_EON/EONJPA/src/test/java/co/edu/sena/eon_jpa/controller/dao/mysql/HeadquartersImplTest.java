/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.dao.mysql;

import co.edu.sena.eon_jpa.controller.dao.HeadquartersDao;
import co.edu.sena.eon_jpa.controller.factory.HeadquartersFactory;
import co.edu.sena.eon_jpa.model.jpa.entities.Headquarters;
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
public class HeadquartersImplTest {
    private Headquarters h;
    
    public HeadquartersImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        h =  new Headquarters(); 
        h.setNameHeadquarters("ricaute");
        h.setAddress("cr 1000 ");
        h.setState(Boolean.TRUE);
       
    }
    
    @After
    public void tearDown() {
    }
    
@Test
public void test1Insert(){
    HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);

    if (dao.find(h.getNameHeadquarters()) == null) {
            dao.insert(h);
        }
        assertEquals(dao.find(h.getNameHeadquarters()), h);
}

@Test
 public void test2Find() {
        System.out.println("prueba find por llave primaria de WorkingDay");
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        Headquarters headquarterConsultado = (Headquarters) dao.find(h.getNameHeadquarters());
        assertEquals(headquarterConsultado,h);
    }
 
      @Test
    public void test3Update() {
        System.out.println("prueba update de campo de status ficha ");
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        h.setAddress("Cr 69 sur");
        h.setState(Boolean.FALSE);
        dao.update(h);
        assertEquals(dao.find(h.getNameHeadquarters()), h);
    }
    @Test
    public void test3vUpdatePrimaryKey() {
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        int resultado = dao.updatePrimaryKey("Sanandresito", h.getNameHeadquarters());
        assertEquals(resultado, 1);
    }
    
        @Test
    public void  test4Delete(){
        System.out.println("prueba de delete de la llave primaria de status ficha");
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        h.setNameHeadquarters("Sanandresito");
        dao.remove(h);
        assertEquals(dao.find(h.getNameHeadquarters()),null);
    
    }
    @Test
    public void test5FindByNameHeadquarters() {
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByNameHeadquarters("S");
        for (Headquarters headquarters : lista) {
            assertEquals(headquarters.getNameHeadquarters(), true);
        }
    }

    @Test
    public void test5FindByLikeNameHeadquarters() {
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByLikeNameHeadquarters("%a%");
        assertTrue(!lista.isEmpty());
    }


    @Test
    public void test5FindByAddres() {
          System.out.println("prueba del metodo findByState del dao de status ficha ");
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByAddres("S");
        for (Headquarters headquarters : lista) {
            assertEquals(headquarters.getAddress(),true);
        }
    }
    
    


    @Test
    public void test5FindByLikeAddres() {
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByLikeAddres("C%");
        assertTrue(!lista.isEmpty());
        
        
    }

 
    @Test
    public void test5FindByState() {
          System.out.println("prueba del metodo findByState del dao de status ficha ");
        HeadquartersDao dao = HeadquartersFactory.create(Headquarters.class);
        List<Headquarters> lista = dao.findByState(true);
        for (Headquarters headquarters : lista) {
            assertEquals(headquarters.getState(), true);
        }
    }


 
}
