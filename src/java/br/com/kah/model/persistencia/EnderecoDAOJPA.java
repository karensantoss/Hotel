
package br.com.kah.model.persistencia;

import br.com.kah.model.Endereco;
import br.com.kah.model.persistencia.dao.EnderecoDAO;
import javax.persistence.EntityManager;


public class EnderecoDAOJPA extends DAOJPA<Endereco, Integer> implements EnderecoDAO{

    public EnderecoDAOJPA(EntityManager manager) {
        super(manager);
    }
    
    
}
