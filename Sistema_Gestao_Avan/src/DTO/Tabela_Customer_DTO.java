package DTO;
public class Tabela_Customer_DTO {
    String name, CPF;
    Integer id_customer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Integer getId_customer() {
        return id_customer;
    }

    public void setId_customer(Integer id_customer) {
        this.id_customer = id_customer;
    }

    public Tabela_Customer_DTO(Integer id_customer, String name, String CPF) {
        this.id_customer = id_customer;
        this.name = name;
        this.CPF = CPF;
     }
       
}
