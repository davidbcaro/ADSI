/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.cot.controlador.dao.mysql;

import co.edu.sena.cot.controlador.dao.LevelTrainingDao;
import co.edu.sena.cot.controlador.factory.mysql.LevelTrainingFactory;
import co.edu.sena.cot.modelo.dto.LevelTrainig;
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
public class LevelTrainingImplTest {

    LevelTrainig lt, lt2, lt3;

    public LevelTrainingImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lt = new LevelTrainig();
        lt.setCode("98765");
        lt.setState(true);

        lt2 = new LevelTrainig();
        lt2.setCode("Hola");
        lt2.setState(false);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        if (dao.find(lt.getCode()) == null) {
            dao.insert(lt);
        }
        assertEquals(dao.find(lt.getCode()), lt);
    }

    @Test
    public void test2Find() {
        System.out.println("prueba de tipo de documento metodo find por llave primaria");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        LevelTrainig tipoDocumentoConsultado = (LevelTrainig) dao.find(lt.getCode());
        assertEquals(tipoDocumentoConsultado, lt);
    }

    @Test
    public void test3Update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        lt.setState(false);
        dao.update(lt);
        assertEquals(dao.find(lt.getCode()), lt);
    }

    @Test
    public void test3vUpdatePK() {
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);

        int resultado = dao.updatePK("Acuña", lt.getCode());
        assertEquals(resultado, 1);

    }

   

    @Test
    public void test4FindAll() {
        System.out.println("prueba de tipo de  metodo findall");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        List<LevelTrainig> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test5FindPrimaryKey() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        List<LevelTrainig> lista = dao.findByLikeCode("Acuña");
        for (LevelTrainig project : lista) {
            assertEquals(project.getCode(), "Acuña");
        }
    }

    @Test
    public void test6FindByState() {
System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        List<LevelTrainig> lista = dao.findByState(false);
        for (LevelTrainig project : lista) {
            assertEquals(project.getState(), false);
        }
    }
 @Test
    public void test7delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        LevelTrainingDao dao = LevelTrainingFactory.create(LevelTrainig.class);
        lt.setCode("Acuña");
        dao.remove(lt);
        assertEquals(dao.find(lt.getCode()), null);

    }


}
