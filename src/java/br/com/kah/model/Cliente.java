package br.com.kah.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Cliente extends PessoaFisica implements Serializable{
    
    private String profissao;
    private String passaporte;
   

    public Cliente() {
        Endereco end = new Endereco();
    }
    
    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
    
    
    
}
