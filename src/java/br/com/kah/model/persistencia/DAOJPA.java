

package br.com.kah.model.persistencia;


import br.com.kah.model.persistencia.dao.DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;


public class DAOJPA <T, I> implements DAO <T, I> {
    
    private EntityManager manager;

    public DAOJPA(EntityManager manager) {
        this.manager = manager;
    }
    
    
    
    @Override
    public void save(T entity) {
        this.manager.merge(entity);
    }

    @Override
    public void remove(Class<T> classe, I pk) {
        this.manager.remove(this.manager.getReference(classe, pk));
    }

    @Override
    public T getById(Class<T> classe, I pk) {
        try {
            return this.manager.find(classe, pk);
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> getAll(Class<T> classe) {
     //"select * from categoria"
       Query q = this.manager.createQuery("select x from " +classe.getSimpleName() + " x ");//funciona para todas as classes
       return q.getResultList();
    }
}
