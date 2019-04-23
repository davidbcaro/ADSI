/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.daowariosoft.controller.dao.mysql;

import co.edu.sena.daowariosoft.controller.dao.CurrentQuarterDAO;
import co.edu.sena.daowariosoft.controller.factory.CurrentQuarterDAOFactory;
import co.edu.sena.daowariosoft.controller.factory.mysql.MysqlCurrentQuarterDAOFactory;
import co.edu.sena.daowariosoft.model.dto.CurrentQuarterDTO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
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
public class MysqlCurrentQuarterDAOTest {

    private CurrentQuarterDTO currentQuarter;
    private CurrentQuarterDTO currentQuarter1;
    private CurrentQuarterDTO llave;

    @Before
    public void setUp() throws Exception {
        currentQuarter = new CurrentQuarterDTO();
        currentQuarter.setIdCurrentQuarter("1");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        currentQuarter.setStartDate(new Date(2017 - 02 - 11));
        currentQuarter.setEndDate(new Date(2017 - 03 - 18));

        currentQuarter1 = new CurrentQuarterDTO();
        currentQuarter1.setIdCurrentQuarter("2");
        currentQuarter1.setStartDate(new Date(2006 - 01 - 30));
        currentQuarter1.setEndDate(new Date(2017 - 11 - 28));

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("insert");
        CurrentQuarterDAOFactory factory = new MysqlCurrentQuarterDAOFactory();
        CurrentQuarterDAO dao = factory.create();
        assertEquals(dao.insert(currentQuarter1), 1);
    }

    @Test
    public void test2FindPk() {
         System.out.println("finpk");
        CurrentQuarterDAOFactory factory = new MysqlCurrentQuarterDAOFactory();
        CurrentQuarterDAO dao = factory.create();
        dao.findPk("2");
    }

    @Test
    public void test3Update() {
        System.out.println("update");
        CurrentQuarterDAOFactory factory = new MysqlCurrentQuarterDAOFactory();
        CurrentQuarterDAO dao = factory.create();
        assertEquals(dao.update(currentQuarter1, "2"), 1);
    }

    @Test
    public void test4Delete() {
        System.out.println("delete");
        CurrentQuarterDAOFactory factory = new MysqlCurrentQuarterDAOFactory();
        CurrentQuarterDAO dao = factory.create();
        assertEquals(dao.delete("2"), 1);
    }
    
    @Test
    public void test5FindAll() {
        System.out.println("findAll");
        CurrentQuarterDAOFactory factory = new MysqlCurrentQuarterDAOFactory();
        CurrentQuarterDAO dao = factory.create();
        List<CurrentQuarterDTO> consulta = (List<CurrentQuarterDTO>) dao.findAll();
        assertFalse(!consulta.isEmpty());
    }

}
