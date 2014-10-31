
package br.com.kah.controller;

import br.com.kah.model.Cidade;
import br.com.kah.model.persistencia.CidadeDAOJPA;
import br.com.kah.model.persistencia.dao.CidadeDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class CidadeMB  {
    
    private Cidade cidade;
    private List<Cidade> cidades;
    
    public CidadeMB() {
        cidade = new Cidade();
    }
    
    public String insere() {
        EntityManager manager = this.getManager();
        CidadeDAO dao = new CidadeDAOJPA(manager);
        dao.save(cidade);
        cidade = new Cidade();
        cidades = null;
        return "/Paginas/listaCidades.xhtml";
    }
    
    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        CidadeDAO dao = new CidadeDAOJPA(manager);
        dao.getById(Cidade.class, this.cidade.getCodigo());
        return "/Paginas/Cidade.xhtml";
    }
    
    public void remove() {
        EntityManager manager = this.getManager();
        CidadeDAO dao = new CidadeDAOJPA(manager);
        dao.remove(Cidade.class, this.cidade.getCodigo());
        this.cidades = null;
        
    }
    
    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        return (EntityManager)request.getAttribute("EntityManager");
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        if(cidades == null) {
            EntityManager manager = this.getManager();
            CidadeDAO dao = new CidadeDAOJPA(manager);
            cidades = dao.getAll(Cidade.class);
        }
        return cidades;
    }
    
    
}
