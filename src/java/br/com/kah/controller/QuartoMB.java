
package br.com.kah.controller;


import br.com.kah.model.Quarto;
import br.com.kah.model.persistencia.QuartoDAOJPA;
import br.com.kah.model.persistencia.dao.QuartoDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class QuartoMB implements Serializable {
    
    private Quarto quarto;
    private List<Quarto> quartos;
    
    public QuartoMB() {
        quarto = new Quarto();
    }
    
    public String insere() {
        EntityManager manager = this.getManager();
        QuartoDAO dao = new QuartoDAOJPA(manager);
        dao.save(quarto);
        quarto = new Quarto();
        quartos = null;
        return "/Paginas/listaQuartos.xhtml";
    }
    
    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        QuartoDAO dao = new QuartoDAOJPA(manager);
        dao.getById(Quarto.class, this.quarto.getCodigo());
        return "/Paginas/Quarto.xhtml";
    }
    
    public void remove() {
        EntityManager manager = this.getManager();
        QuartoDAO dao = new QuartoDAOJPA(manager);
        dao.remove(Quarto.class, this.quarto.getCodigo());
        this.quartos = null;
        
    }
    
    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        return (EntityManager)request.getAttribute("EntityManager");
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<Quarto> getQuartos() {
        if(quartos == null) {
            EntityManager manager = this.getManager();
            QuartoDAO dao = new QuartoDAOJPA(manager);
            quartos = dao.getAll(Quarto.class);
        }
        return quartos;
    }
    
    
}
