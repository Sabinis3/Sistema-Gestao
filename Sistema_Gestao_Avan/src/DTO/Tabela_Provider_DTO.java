package DTO;
public class Tabela_Provider_DTO {
    private String name, contact;
    private Integer id_provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getId_provider() {
        return id_provider;
    }

    public void setId_provider(Integer id_provider) {
        this.id_provider = id_provider;
    }

    public Tabela_Provider_DTO(Integer id_provider, String name, String contact) {
        this.id_provider = id_provider;
        this.name = name;
        this.contact = contact;      
    }

    @Override
    public String toString() {
        return "Providers{" +
                "id_provider='" + id_provider + '\'' +
                ", name=" + name + '\'' +
                ", contact=" + contact +
                '}';
                
                }
    
    
    
}
