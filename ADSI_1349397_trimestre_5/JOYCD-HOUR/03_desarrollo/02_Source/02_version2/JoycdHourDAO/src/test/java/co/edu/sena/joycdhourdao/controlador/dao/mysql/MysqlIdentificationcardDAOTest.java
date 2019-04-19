/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.joycdhourdao.controlador.dao.mysql;

import co.edu.sena.joycdhourdao.controlador.dao.IdentificationcardDAO;
import co.edu.sena.joycdhourdao.controlador.factory.IdentificationcardDAOFactory;
import co.edu.sena.joycdhourdao.controlador.factory.mysql.MysqlIdentificationcardDAOFactory;
import co.edu.sena.joycdhourdao.modelo.dto.IdentificationcardDTO;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
/**
 *
 * @author Usser
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class  MysqlIdentificationcardDAOTest {
    
    private IdentificationcardDTO identificationcard;
    private IdentificationcardDTO identificationcard2;
    private IdentificationcardDTO key;
    
     @Before
    public void setUp() throws Exception {
        identificationcard = new IdentificationcardDTO();
        identificationcard.setIdindentificationcardnumber("12345");
        identificationcard.setName("pedro");
        identificationcard.setStatus(Boolean.TRUE);
        
        
        identificationcard2 = new IdentificationcardDTO();
        identificationcard2.setIdindentificationcardnumber("54321");
        identificationcard2.setName("pepa");
        identificationcard2.setStatus(Boolean.TRUE);
        
    }
    
    @After
    public void tearDown() throws Exception {
    }
     @Test
    public void test1insert() {
        System.out.println("prueba de insert de IdentificationcardDAO");
        IdentificationcardDAOFactory factory = new MysqlIdentificationcardDAOFactory();
        IdentificationcardDAO dao = factory.create();
        assertEquals(dao.insert(identificationcard), 1);
    }
    @Test
    public void test2FindPk() {
        System.out.println("prueba del búsqueda llave primaria de ProjectDAo");
        IdentificationcardDAOFactory factory = new MysqlIdentificationcardDAOFactory();
        IdentificationcardDAO dao = factory.create();
        IdentificationcardDTO consulta = dao.findPk("12345");
        assertEquals(consulta, identificationcard);

    }

    @Test
    public void test3Update() {
        System.out.println("prueba de update de IdentificationcardDAO");
        IdentificationcardDAOFactory factory = new MysqlIdentificationcardDAOFactory();
        IdentificationcardDAO dao = factory.create();
        assertEquals(dao.update(identificationcard2, "12345"), 1);
    }
    
    @Test
    public void test4FindAll() {
        System.out.println("prueba de select * de IdentificationcardDAO");
        IdentificationcardDAOFactory factory = new MysqlIdentificationcardDAOFactory();
        IdentificationcardDAO dao = factory.create();
        List<IdentificationcardDTO> consulta = (List<IdentificationcardDTO>) dao.findAll();
        System.out.println(consulta);
        assertTrue(!consulta.isEmpty());
    }
   
    @Test
    public void test5Delete() {
        System.out.println("prueba de update de projectDao");
        IdentificationcardDAOFactory factory = new MysqlIdentificationcardDAOFactory();
        IdentificationcardDAO dao = factory.create();
        assertEquals(dao.delete("54321"), 1);
    }
    
    
}
