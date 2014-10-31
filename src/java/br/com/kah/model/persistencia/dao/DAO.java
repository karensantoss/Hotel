
package br.com.kah.model.persistencia.dao;

import java.util.List;


public interface DAO <T, I> {
    
    void save (T entity);
    void remove(Class<T> classe, I pk);
    T getById (Class<T> classe, I pk);
    List<T> getAll (Class<T> classe);
    
}
