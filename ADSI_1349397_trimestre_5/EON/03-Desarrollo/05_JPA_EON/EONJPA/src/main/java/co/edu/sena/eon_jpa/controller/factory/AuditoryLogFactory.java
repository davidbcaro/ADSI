/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eon_jpa.controller.factory;

import co.edu.sena.eon_jpa.controller.dao.AuditoryLogDao;
import co.edu.sena.eon_jpa.controller.dao.mysql.AuditoryLogDaoImpl;

/**
 *
 * @author LUISBERNARDO
 */
public class AuditoryLogFactory {
    public static AuditoryLogDao create(Class entityClass){
        return new AuditoryLogDaoImpl(entityClass);
    }
}
