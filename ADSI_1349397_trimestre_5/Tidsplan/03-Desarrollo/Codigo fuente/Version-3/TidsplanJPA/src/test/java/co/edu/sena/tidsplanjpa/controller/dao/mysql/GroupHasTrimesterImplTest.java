/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplanjpa.controller.dao.mysql;

import co.edu.sena.tidsplanjpa.controller.dao.GroupHasTrimesterDao;
import co.edu.sena.tidsplanjpa.controller.factory.GroupHasTrimesterFactory;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimester;
import co.edu.sena.tidsplanjpa.model.jpa.entities.GroupHasTrimesterPK;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 *
 * @author 1349397
 */
public class GroupHasTrimesterImplTest {
    GroupHasTrimester ght;
    GroupHasTrimesterPK ghtpk;
    public GroupHasTrimesterImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ght = new GroupHasTrimester();
        ght.setGroupHasTrimesterPK(new GroupHasTrimesterPK("1349397", "trimestre-1", "D", "tecnico"));
        
        ghtpk = new GroupHasTrimesterPK("1234456", "trimestre-6", "D", "tecnologo");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test01Insert() {
        System.out.println("Prueba de Group has trimester metodo insert");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        if (dao.find(ght.getGroupHasTrimesterPK()) == null) {
            dao.insert(ght);

        }
        assertEquals(dao.find(ght.getGroupHasTrimesterPK()), ght);
    }

    @Test 
    public void test02Find() {
        System.out.println("Prueba de Group has trimester metodo Find");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        GroupHasTrimester GroupHasTrimesterConsulted = (GroupHasTrimester) dao.find(ght.getGroupHasTrimesterPK());
        assertEquals(GroupHasTrimesterConsulted, ght);

    }

    

    @Test
    public void test03UpdatePrimaryKey() {
        System.out.println("Prueba de Group has trimester metodo UpdatePrimaryKey");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        int result = dao.updatePrimaryKey(ghtpk, ght.getGroupHasTrimesterPK());
        assertEquals(result, 1);
    }
    
    @Test 
    public void test04Delete(){
        System.out.println("Prueba de Group has trimester metodo Delete");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        ght.setGroupHasTrimesterPK(ghtpk);
        dao.remove(ght);
        assertEquals(dao.find(ght.getGroupHasTrimesterPK()), null);
    }

    @Test
    public void test05FindAll() {
        System.out.println("Prueba de Nivel de formacion metodo FindaAll");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findAll();
        assertTrue(!list.isEmpty());
        for (GroupHasTrimester groupHasTrimester : list) {
            System.out.println(groupHasTrimester);
        }
    }
    
  
    @Test
    public void test06FindByLikeNumberGroup() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByLikeNumberGroup");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByLikeNumberGroup("%3%");
        assertFalse(list.isEmpty());
    }


    @Test
    public void test07FindByLikeNameTrimester() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByLikeNameTrimester");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByLikeNameTrimester("%-1%");
        assertFalse(list.isEmpty());
    }

   
    @Test
    public void test08FindByLikeWorkingDayInitials() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByLikeWorkingDayInitials");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByLikeWorkingDayInitials("%D%");
        assertFalse(list.isEmpty());
    }

  
    @Test
    public void test09FindByLikeLevelFormation() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByLikeLevelFormation");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByLikeLevelFormation("%olo%");
        assertFalse(list.isEmpty());
    }

    
    @Test
    public void test10FindByNumberGroup() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByNumberGroup");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByNumberGroup("1349397");
        assertFalse(list.isEmpty());
        for (GroupHasTrimester groupHasTrimester : list) {
            assertEquals(groupHasTrimester.getGroupHasTrimesterPK().getNumberGroup(), "1349397");
        }
    }

    @Test
    public void test11FindByNameTrimester() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByNameTrimester");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByNameTrimester("trimestre-1");
        assertFalse(list.isEmpty());
        for (GroupHasTrimester groupHasTrimester : list) {
            assertEquals(groupHasTrimester.getGroupHasTrimesterPK().getNameTrimester(), "trimestre-1");
        }
    }

    @Test
    public void test12FindByWorkingDayInitials() {
        System.out.println("Prueba de  GroupHasTrimester metodo FindByWorkingDayInitials");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByWorkingDayInitials("D");
        assertFalse(list.isEmpty());
        for (GroupHasTrimester groupHasTrimester : list) {
            assertEquals(groupHasTrimester.getGroupHasTrimesterPK().getWorkingdayInitials(), "D");
        }
    }

    @Test
    public void test13FindByLevelFormation() {
         System.out.println("Prueba de  GroupHasTrimester metodo FindByLevelFormation");
        GroupHasTrimesterDao dao = GroupHasTrimesterFactory.create(GroupHasTrimester.class);
        List<GroupHasTrimester> list = dao.findByLevelFormation("tecnico");
        assertFalse(list.isEmpty());
        for (GroupHasTrimester groupHasTrimester : list) {
            assertEquals(groupHasTrimester.getGroupHasTrimesterPK().getLevelFormation(), "tecnico");
        }
    }
}
