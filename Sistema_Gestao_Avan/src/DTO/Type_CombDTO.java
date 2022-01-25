package DTO;
public class Type_CombDTO {
    
   int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   String type_user;


    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public Type_CombDTO(int id, String type_user) {
        this.id = id;
        this.type_user = type_user;
    }

    @Override
    public String toString() {
        return getType_user();
    }
   
   
    
}
