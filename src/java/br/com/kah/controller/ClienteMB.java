
package br.com.kah.controller;

import br.com.kah.model.Cidade;
import br.com.kah.model.Cliente;
import br.com.kah.model.persistencia.CidadeDAOJPA;
import br.com.kah.model.persistencia.ClienteDAOJPA;
import br.com.kah.model.persistencia.dao.CidadeDAO;
import br.com.kah.model.persistencia.dao.ClienteDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class ClienteMB {
    
    private Cliente cliente;
    private List<Cliente> clientes;
    private int cidadeId;
    
    public ClienteMB() {
        cliente = new Cliente();
    }
    
    public String insere() {
        EntityManager manager = this.getManager();
        ClienteDAO dao = new ClienteDAOJPA(manager);
        if(this.cidadeId !=0) {
            CidadeDAO cdao = new CidadeDAOJPA(manager);
            Cidade cidade = cdao.getById(Cidade.class, cidadeId);
            this.cliente.getEndereco().setCidade(cidade);
                  
        }
        dao.save(cliente);
        cliente = new Cliente();
        clientes = null;
        return "/Paginas/listaClientes.xhtml";
    }
    
    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        ClienteDAO dao = new ClienteDAOJPA(manager);
        dao.getById(Cliente.class, this.cliente.getCodigo());
        return "/Paginas/Cliente.xhtml";
    }
    
    public void remove() {
        EntityManager manager = this.getManager();
        ClienteDAO dao = new ClienteDAOJPA(manager);
        dao.remove(Cliente.class, this.cliente.getCodigo());
        this.clientes = null;
        
    }
    
    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        return (EntityManager)request.getAttribute("EntityManager");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        if(clientes == null) {
            EntityManager manager = this.getManager();
            ClienteDAO dao = new ClienteDAOJPA(manager);
            clientes = dao.getAll(Cliente.class);
        }
        return clientes;
    }

    public int getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(int cidadeId) {
        this.cidadeId = cidadeId;
    }
    
    
    
}
