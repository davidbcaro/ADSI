/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.controller.dao.mysql;

import co.edu.sena.controller.dao.LearningResultDAO;
import co.edu.sena.controller.dao.PhaseProjectDAO;
import co.edu.sena.controller.factory.LearningResultFactory;
import co.edu.sena.controller.factory.PhaseProjectFactory;
import co.edu.sena.model.jpa.entities.LearningResult;
import co.edu.sena.model.jpa.entities.LearningResultPK;
import co.edu.sena.model.jpa.entities.PhaseProject;
import co.edu.sena.model.jpa.entities.PhaseProjectPK;
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
public class LearningResultDAOImplTest {
    private LearningResult learning;
    private LearningResultPK leaningpk;
    
    public LearningResultDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       learning = new LearningResult();
       learning.setDescription("24020150005  Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construccion colectiva del conocimiento y la resolucion de problemas de caracter productico y social.");
       learning.setLearningResultPK(new LearningResultPK("RAB 1 (Comunicacion)","228120","240201500","Version 102"));
       
       
       leaningpk =  new LearningResultPK("RAB 2 (Induccion)","228120","240201500","Version 102");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByLearningResultCode method, of class LearningResultDAOImpl.
     */
    @Test
    public void test1insert() {
        System.out.println("Prueba insert de FASE");
        LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
        if (dao.find(learning.getLearningResultPK()) == null) {
            dao.insert(learning);
        }
        assertEquals(dao.find(learning.getLearningResultPK()), learning);
    }
    
    @Test
    public void test2find (){
        System.out.println("prueba del find");
         LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
         LearningResult resultconsulta = (LearningResult) dao.find(learning.getLearningResultPK());
        assertEquals(resultconsulta, learning);
    }
    @Test
    public void test3update(){
        System.out.println("orueba de update jaja");
        LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
       learning.setDescription("Description");
       learning.setLearningResultPK(new LearningResultPK("RAB 1 (Induccion)","228120","240201500","Version 102"));
        dao.update(learning);
        assertEquals(dao.find(learning.getLearningResultPK()),learning);
    }
    @Test
    public void test4vupdatePrimaryKey (){
         LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
        dao.updatePrimaryKey(leaningpk, learning.getLearningResultPK());
        learning.setLearningResultPK(leaningpk);
        assertEquals(dao.find(leaningpk), learning);
    }
    @Test
    public void test5FindAll() {
     System.out.println("prueba del metodo findall");
   LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
        
}
    @Test
    public void test5vFindByLearningResultCode (){
    LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
    List<LearningResult> lista = dao.findByLearningResultCode("RAB-3 (ETICA)");
    assertTrue(!lista.isEmpty());
        for (LearningResult learningresult : lista) {
            assertEquals(learningresult.getLearningResultPK().getLearningResultCode(),"RAB-3 (ETICA)" );
        }

       
    }
    @Test
    public void test6FindByDescription (){
          LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
          List <LearningResult> lista = dao.findByDescription("Generar procesos autonomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.");
          assertTrue(!lista.isEmpty());
          for (LearningResult learningresult : lista) {
            assertEquals(learningresult.getDescription(),"Generar procesos autonomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral." );
        }   
    }
    @Test
    public void test7FindByProgramCode (){
      LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
      List <LearningResult> lista= dao.findByProgramCode("228106");
      assertTrue(!lista.isEmpty());
      for (LearningResult learningResult :lista){
          
          assertEquals(learningResult.getLearningResultPK().getProgramcode(),"228106");
      }
      
    }
    @Test
    public void test8FindByCompetenceCode (){
          LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
          List <LearningResult> lista = dao.findByCompetenceCode("240201500");
          assertTrue(!lista.isEmpty());
          for  (LearningResult learningResult :lista){
              assertEquals(learningResult.getLearningResultPK().getCompetenceCode(),"240201500");
          }
        
    }
    @Test
    public void test9FindByVersion (){
        LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
        List <LearningResult> lista = dao.findByVersion("Version 102");
        assertTrue(!lista.isEmpty());
        for (LearningResult learningResult :lista){
            assertEquals(learningResult.getLearningResultPK().getVersion(),"Version 102");
        }
    }
    @Test
    public void test10FindLikeLearningResultCode(){
            LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
            List <LearningResult> lista = dao.findByLikeLearningCode("RAB%");
            assertTrue(!lista.isEmpty());
    }
    @Test
    public void test11FindLikeDescription(){
                 LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
        List<LearningResult> lista = dao.findByLikeDescription("Re%");
        assertTrue(!lista.isEmpty());
    }
    @Test
    public void test12FindLikeProgramCode (){
         LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
         List <LearningResult> lista = dao.findByLikeProgramCode("22%");
                assertTrue(!lista.isEmpty());
    }
    @Test
    public void test13findLikeCompetenceCode (){
          LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
          List <LearningResult> lista = dao.findByLikeCompetenceCode("24%");
               assertTrue(!lista.isEmpty());
    }
    @Test
    public void test14findLikeVersion (){
       LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
       List <LearningResult> lista = dao.findByLikeVersion("Ver%");
        assertTrue(!lista.isEmpty());
    }
    @Test
    public void test15delete() {
        System.out.println("Prueba del Delete");
          LearningResultDAO dao = LearningResultFactory.create(LearningResult.class);
       learning.setLearningResultPK(new LearningResultPK("RAB 1 (Induccion)","228120","240201500","Version 102"));
        dao.remove(learning);
        assertEquals(dao.find(learning.getLearningResultPK()),null);
    }
    
}

