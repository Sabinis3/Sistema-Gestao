package DAO;

import DTO.ProductsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class productsDAO {
    
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    ArrayList<ProductsDTO> lista = new ArrayList<>();
    
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "productsDAO: " + e.getMessage());
        }
    }
    
    public void atualizar(ProductsDTO objproductsdto){
    String sql = "update tb_products set name = ?, type_product = ?, qtd = ? where id_product = ?";
    conn = new connectionDAO().conectaBD();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objproductsdto.getName());
            stmt.setString(2, objproductsdto.getType_product());
            stmt.setInt(3, objproductsdto.getQtd());
            stmt.setInt(4, objproductsdto.getId_product());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "productsDAO: " + e.getMessage());
    }
    }
    
    public void deletar(ProductsDTO objproductsdto){
        String sql = "delete from tb_products where id_product = ?";
        conn = new connectionDAO().conectaBD();
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objproductsdto.getId_product());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "productsDAO: " + e.getMessage());
        }
    
    }
    
    public ArrayList<ProductsDTO> listar(){
    String sql = "select * from tb_products ";
     conn = new connectionDAO().conectaBD();
     try {
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);
         
         while(rs.next()){
              ProductsDTO objproductsdto = new ProductsDTO();
              objproductsdto.setId_product(rs.getInt("id_product"));
              objproductsdto.setName(rs.getString("name"));
              objproductsdto.setType_product(rs.getString("type_product"));
              objproductsdto.setQtd(rs.getInt("qtd"));
              
             lista.add(objproductsdto);
                     }
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null,"porductsDAO" + erro);
     }
        return lista;
    
    }
    
}
