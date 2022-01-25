package DAO;

import DTO.productsDTO;
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
    
    ArrayList<productsDTO> lista = new ArrayList<>();
    
    public void cadastrar(productsDTO objproductsdto){
    String sql = "insert into tb_products (cod_provider, name, type_product, qtd) values (?, ?, ?, ?)";
    conn = new connectionDAO().conectaBD();
    
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objproductsdto.getCod_provider());
            stmt.setString(2, objproductsdto.getName());
            stmt.setString(3, objproductsdto.getType_product());
            stmt.setInt(4, objproductsdto.getQtd());
           
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "productsDAO: " + e.getMessage());
        }
    }
    
    public ArrayList<productsDTO> listar(){
    String sql = "select * from tb_products ";
     conn = new connectionDAO().conectaBD();
     try {
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);
         
         while(rs.next()){
              productsDTO objproductsdto = new productsDTO();
              objproductsdto.setId_product(rs.getInt("id_product"));
              objproductsdto.setName(rs.getString("name"));
              objproductsdto.setType_product(rs.getString("type_product"));
              objproductsdto.setQtd(rs.getInt("qtd"));
              objproductsdto.setCod_provider(rs.getInt("cod_provider"));
              
             lista.add(objproductsdto);
                     }
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null,"porductsDAO" + erro);
     }
        return lista;
    
    }
    
    public void atualizar(productsDTO objproductsdto){
    String sql = "update tb_products set cod_provider = ?, name = ?, type_product = ?, qtd = ? where id_product = ?";
    conn = new connectionDAO().conectaBD();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objproductsdto.getCod_provider());
            stmt.setString(2, objproductsdto.getName());
            stmt.setString(3, objproductsdto.getType_product());
            stmt.setInt(4, objproductsdto.getQtd());
            stmt.setInt(5, objproductsdto.getId_product());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "productsDAO: " + e.getMessage());
    }
    }
    
    public void deletar(productsDTO objproductsdto){
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
    
}
