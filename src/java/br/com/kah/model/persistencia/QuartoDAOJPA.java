
package br.com.kah.model.persistencia;

import br.com.kah.model.Quarto;
import br.com.kah.model.persistencia.dao.QuartoDAO;
import javax.persistence.EntityManager;


public class QuartoDAOJPA extends DAOJPA<Quarto, Integer> implements QuartoDAO{

    public QuartoDAOJPA(EntityManager manager) {
        super(manager);
    }
    
    
}
