package co.edu.sena.tisdplandao.controller.dao.interfaceDAO;

import co.edu.sena.tisdplandao.model.dto.CustomerDTO;
import co.edu.sena.tisdplandao.model.dto.dtopk.CustomerPkDTO;

import java.util.Collection;

public interface CustomerDAO {
    public int insert(CustomerDTO customer);
    public int update(CustomerDTO customer, CustomerPkDTO primaryKey);
    public int delete(CustomerPkDTO primarykey);
    public Collection<CustomerDTO> findAll();
    public CustomerDTO findPk(CustomerPkDTO primarykey);

}
