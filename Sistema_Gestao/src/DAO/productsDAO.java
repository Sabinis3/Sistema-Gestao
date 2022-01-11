package DAO;

import DTO.ProductsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class productsDAO {
    
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    public void cadastrar(ProductsDTO objproductsdto){
    String sql = "insert into tb_products (name, type_product, qtd) values (?, ?, ?)";
    conn = new connectionDAO().conectaBD();
    
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objproductsdto.getName());
            stmt.setString(2, objproductsdto.getType_product());
            stmt.setInt(3, objproductsdto.getQtd());
           
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "productsDAO: " + erro.getMessage());
        }
    }
    
}
