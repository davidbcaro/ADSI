/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;
import co.edu.sena.controller.dao.IdentificationCardDAO;
import co.edu.sena.controller.factory.IdentificationCardFactory;
import co.edu.sena.model.jpa.entities.IdentificationCard;
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
public class IdentificationCardDAOImplTest {
    private IdentificationCard identification;
    
    public IdentificationCardDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        identification = new IdentificationCard();
        identification.setIdIdentificationCardNumber("TTT");
        identification.setName("tarjeta");
        identification.setStatus(Boolean.TRUE);            
    }
   
    @After
    public void tearDown() {
    }
    
    @Test
    public void test1Insert() {
        System.out.println("Prueba insert de IdentificationCard");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        if (dao.find(identification.getIdIdentificationCardNumber()) == null) {
            dao.insert(identification);
        }
        assertEquals(dao.find(identification.getIdIdentificationCardNumber()), identification);
    }
    
    @Test
    public void test2find(){
        System.out.println("Prueba consulta IdentificationCard");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        IdentificationCard identificationCardconsulta =(IdentificationCard) dao.find(identification.getIdIdentificationCardNumber());
        assertEquals(identificationCardconsulta, identification);
    }
   
    @Test
    public void test3update() {
        System.out.println("Prueba del Update");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        identification.setName("la tarjeta roja");
        identification.setStatus(true);
        dao.update(identification);
        assertEquals(dao.find(identification.getIdIdentificationCardNumber()), identification); 
    }
    
    @Test
    public void test4UpdatePrimaryKey() {
        System.out.println("updatePrimaryKey");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        int resultado = dao.updatePrimaryKey("YYY", identification.getIdIdentificationCardNumber());
        assertEquals(resultado, 1); 
    }
    
     @Test 
    public void test5Delete (){
        System.out.println("Prueba del Delete");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        identification.setIdIdentificationCardNumber("YYY");
        dao.remove(identification);
        assertEquals(dao.find(identification.getIdIdentificationCardNumber()), null);
    }
     @Test
    public void test6FindAll() {
        System.out.println("prueba del metodo findall");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class); 
        List<IdentificationCard> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }
     
    @Test
    public void test7findByIdIdentificationCardNumber () {
        System.out.println("prueba de  metodo FindByIdIdentificationCardNumber");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);    
        List<IdentificationCard> lista = dao.findByIdIdentificationCardNumber("CC");
        assertTrue(!lista.isEmpty());
        for (IdentificationCard identification :lista){
            assertEquals(identification.getIdIdentificationCardNumber(),"CC");
        }      
    }
    
    @Test
    public void test8FindByName() {
        System.out.println("prueba de  metodo findByName");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        List<IdentificationCard> lista = dao.findByName("Cedula de Extranjeria"); 
        assertTrue(!lista.isEmpty());
        for (IdentificationCard identificationt : lista) {
            assertEquals(identificationt.getName(), "Cedula de Extranjeria");
        }      
    }
    
    @Test
    public void test9FindByStatus() {
        System.out.println("prueba del metodo findStatus");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        List<IdentificationCard> lista = dao.findByStatus(true);
        assertTrue(!lista.isEmpty());
        for (IdentificationCard identification : lista) {
            assertEquals(identification.getStatus(), true);
        }
    }
    
      @Test
    public void test10FindByLikeIdIdentificationCardNumber() {
        System.out.println("prueba del metodo findLikeIdIdentificationCardNumber");
        IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
        List<IdentificationCard> lista = dao.findByLikeIdIdentificationCardNumber("%C%");
        assertTrue(!lista.isEmpty());
    }
    
   @Test
    public void test11FindLikeName() {
       IdentificationCardDAO dao = IdentificationCardFactory.create(IdentificationCard.class);
       List<IdentificationCard> lista = dao.findByLikeName("Docu%");
       assertTrue(!lista.isEmpty());
    }
    
}
