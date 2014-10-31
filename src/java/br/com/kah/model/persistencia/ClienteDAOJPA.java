
package br.com.kah.model.persistencia;

import br.com.kah.model.Cliente;
import br.com.kah.model.persistencia.dao.ClienteDAO;
import javax.persistence.EntityManager;


public class ClienteDAOJPA extends DAOJPA<Cliente, Integer> implements ClienteDAO{

    public ClienteDAOJPA(EntityManager manager) {
        super(manager);
    }
    
    
}
