package imobiliaria.modelo;
// Generated 26/06/2013 21:06:11 by Hibernate Tools 3.2.1.GA

import imobiliaria.gui.Funcionarios2Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Funcionarios generated by hbm2java
 */
@Entity
@Table(name="FUNCIONARIOS"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Funcionarios  implements java.io.Serializable {


     private int codigo;
     private String nome;
     private String cpf;
     private String ctps;
     private Boolean masculino;
     private String endereco;
     private String bairro;
     private String cidade;
     private String estado;
     private String cep;
     private String telefone;
     private String email;
     private String cargo;
     private String salario;

    public Funcionarios() {
    }

	
    public Funcionarios(int codigo, String nome, String cpf, String ctps) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.ctps = ctps;
    }
    public Funcionarios(int codigo, String nome, String cpf, String ctps, Boolean masculino, String endereco, String bairro, String cidade, String estado, String cep, String telefone, String email, String cargo, String salario) {
       this.codigo = codigo;
       this.nome = nome;
       this.cpf = cpf;
       this.ctps = ctps;
       this.masculino = masculino;
       this.endereco = endereco;
       this.bairro = bairro;
       this.cidade = cidade;
       this.estado = estado;
       this.cep = cep;
       this.telefone = telefone;
       this.email = email;
       this.cargo = cargo;
       this.salario = salario;
    }
   
     @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CODIGO", unique=true, nullable=false)
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Column(name="NOME", nullable=false, length=100)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name="CPF", nullable=false, length=100)
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Column(name="CTPS", nullable=false, length=100)
    public String getCtps() {
        return this.ctps;
    }
    
    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
    
    @Column(name="MASCULINO")
    public Boolean getMasculino() {
        return this.masculino;
    }
    
    public void setMasculino(Boolean masculino) {
        this.masculino = masculino;
    }
    
    @Column(name="ENDERECO", length=100)
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Column(name="BAIRRO", length=100)
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    @Column(name="CIDADE", length=100)
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Column(name="ESTADO", length=100)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Column(name="CEP", length=10)
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    @Column(name="TELEFONE", length=100)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Column(name="EMAIL", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="CARGO", length=100)
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Column(name="SALARIO", length=100)
    public String getSalario() {
        return this.salario;
    }
    
    public void setSalario(String salario) {
        this.salario = salario;
    }

public String[] toArray() {
        String[] arrayFuncionarios = new String[6];
        arrayFuncionarios[Funcionarios2Table.INDICE_CODIGO] = String.valueOf(this.getCodigo());
        arrayFuncionarios[Funcionarios2Table.INDICE_NOME] = this.getNome();
        arrayFuncionarios[Funcionarios2Table.INDICE_CARGO] = this.getCargo();
        arrayFuncionarios[Funcionarios2Table.INDICE_SALARIO] = this.getSalario();
        
        return arrayFuncionarios;
    }


}

