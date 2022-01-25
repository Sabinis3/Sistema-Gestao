package DTO;

public class productsDTO {
   Integer id_product, cod_provider, qtd;
   String name, type_product;

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
   
   
}
