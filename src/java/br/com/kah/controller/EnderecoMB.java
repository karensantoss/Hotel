
package br.com.kah.controller;

import br.com.kah.model.Endereco;
import br.com.kah.model.persistencia.EnderecoDAOJPA;
import br.com.kah.model.persistencia.dao.EnderecoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class EnderecoMB {
    
    private Endereco endereco;
    private List<Endereco> enderecos;
    
    public EnderecoMB() {
        endereco = new Endereco();
    }
    
    public String insere() {
        EntityManager manager = this.getManager();
        EnderecoDAO dao = new EnderecoDAOJPA(manager);
        dao.save(endereco);
        endereco = new Endereco();
        enderecos = null;
        return "/Paginas/listaEnderecos.xhtml";
    }
    
    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        EnderecoDAO dao = new EnderecoDAOJPA(manager);
        dao.getById(Endereco.class, this.endereco.getCodigo());
        return "/Paginas/Endereco.xhtml";
    }
    
    public void remove() {
        EntityManager manager = this.getManager();
        EnderecoDAO dao = new EnderecoDAOJPA(manager);
        dao.remove(Endereco.class, this.endereco.getCodigo());
        this.enderecos = null;
        
    }
    
    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        return (EntityManager)request.getAttribute("EntityManager");
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        if(enderecos == null) {
            EntityManager manager = this.getManager();
            EnderecoDAO dao = new EnderecoDAOJPA(manager);
            enderecos = dao.getAll(Endereco.class);
        }
        return enderecos;
    }
    
    
}
