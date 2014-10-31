
package br.com.kah.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@MappedSuperclass

public abstract class Pessoa implements Serializable{
    @Id @GeneratedValue
    private int codigo;
    private String nome;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    private String celular;
    private String Comercial;
    private String fax;
    private String Residencial;
    private String email;
    private String skype;
    @OneToOne (cascade = CascadeType.ALL)
    private Endereco endereco;

    public Pessoa() {
         endereco = new Endereco();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getComercial() {
        return Comercial;
    }

    public void setComercial(String Comercial) {
        this.Comercial = Comercial;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getResidencial() {
        return Residencial;
    }

    public void setResidencial(String Residencial) {
        this.Residencial = Residencial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

   public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    
    }
    
}
