
package br.com.kah.model.persistencia;

import br.com.kah.model.Cidade;
import br.com.kah.model.persistencia.dao.CidadeDAO;
import javax.persistence.EntityManager;


public class CidadeDAOJPA extends DAOJPA<Cidade, Integer> implements CidadeDAO{

    public CidadeDAOJPA(EntityManager manager) {
        super(manager);
    }
    
    
}
