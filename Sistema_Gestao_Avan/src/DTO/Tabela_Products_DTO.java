package DTO;
public class Tabela_Products_DTO {
    private Integer id_product, cod_provider, qtd;
    private String name, type_product;

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getCod_provider() {
        return cod_provider;
    }

    public void setCod_provider(Integer cod_provider) {
        this.cod_provider = cod_provider;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_product() {
        return type_product;
    }

    public void setType_product(String type_product) {
        this.type_product = type_product;
    }

    public Tabela_Products_DTO(Integer id_product, String name,String type_product, Integer qtd,Integer cod_provider ) {
        this.id_product = id_product;
        this.name = name;
        this.type_product = type_product;
        this.qtd = qtd;
        this.cod_provider = cod_provider;
    }

@Override
    public String toString() {
        return "Products{" +
                "id_product='" + id_product + '\'' +
                ", cod_provider='" + cod_provider+ '\'' +
                ", qtd=" + qtd + '\'' +
                ", type_product=" + type_product +
                ", name=" + name +
                '}';
    }    
    
}
