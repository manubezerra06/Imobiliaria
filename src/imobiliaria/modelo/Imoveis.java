package imobiliaria.modelo;
// Generated Jun 17, 2013 9:32:25 PM by Hibernate Tools 3.2.1.GA


import imobiliaria.gui.Imoveis2Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Imoveis generated by hbm2java
 */
@Entity
@Table(name="IMOVEIS"
    ,schema="PUBLIC"
    ,catalog="PUBLIC"
)
public class Imoveis  implements java.io.Serializable {


     private int codigo;
     private String endereco;
     private String numero;
     private String bairro;
     private String cidade;
     private String estado;
     private String pais;
     private String proprietario;
     private String telefone;
     private String valormaximo;
     private String valorminimo;

    public Imoveis() {
    }

    public Imoveis(int codigo, String endereco, String numero, String bairro, String cidade, String estado, String pais, String proprietario, String telefone, String valormaximo, String valorminimo) {
       this.codigo = codigo;
       this.endereco = endereco;
       this.numero = numero;
       this.bairro = bairro;
       this.cidade = cidade;
       this.estado = estado;
       this.pais = pais;
       this.proprietario = proprietario;
       this.telefone = telefone;
       this.valormaximo = valormaximo;
       this.valorminimo = valorminimo;
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
    
    @Column(name="ENDERECO", nullable=false, length=100)
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Column(name="NUMERO", nullable=false, length=6)
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    @Column(name="BAIRRO", nullable=false, length=20)
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    @Column(name="CIDADE", nullable=false, length=20)
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    @Column(name="ESTADO", nullable=false, length=20)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Column(name="PAIS", nullable=false, length=10)
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Column(name="PROPRIETARIO", nullable=false, length=100)
    public String getProprietario() {
        return this.proprietario;
    }
    
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    
    @Column(name="TELEFONE", nullable=false, length=14)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Column(name="VALORMAXIMO", nullable=false, length=10)
    public String getValormaximo() {
        return this.valormaximo;
    }
    
    public void setValormaximo(String valormaximo) {
        this.valormaximo = valormaximo;
    }
    
    @Column(name="VALORMINIMO", nullable=false, length=10)
    public String getValorminimo() {
        return this.valorminimo;
    }
    
    public void setValorminimo(String valorminimo) {
        this.valorminimo = valorminimo;
    }

    @Override
    public String toString(){
        return String.valueOf(this.codigo);
    }
    
     public String[] toArray() {
        String[] imovelArray = new String[6];
        imovelArray[Imoveis2Table.INDICE_CODIGO] = String.valueOf(this.getCodigo());
        imovelArray[Imoveis2Table.INDICE_BAIRRO] = this.getBairro();
        imovelArray[Imoveis2Table.INDICE_CIDADE] = this.getCidade();
        imovelArray[Imoveis2Table.INDICE_PROPRIETARIO] = this.getProprietario();
        return imovelArray;
    }




}


