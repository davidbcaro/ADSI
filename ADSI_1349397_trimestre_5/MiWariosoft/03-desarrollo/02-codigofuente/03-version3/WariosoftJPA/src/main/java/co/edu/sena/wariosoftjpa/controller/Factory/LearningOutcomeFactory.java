/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.wariosoftjpa.controller.Factory;


import co.edu.sena.wariosoftjpa.controller.dao.LearningOutcomeDAO;
import co.edu.sena.wariosoftjpa.controller.dao.mysql.LearningOutcomeImpl;


/**
 *
 * @author Sebastian
 */
public class LearningOutcomeFactory {
    public static LearningOutcomeDAO create(Class entityClass) {
        return new LearningOutcomeImpl(entityClass);
    }
}
