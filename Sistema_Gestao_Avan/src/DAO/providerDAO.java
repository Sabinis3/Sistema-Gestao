package DAO;

import DTO.providerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class providerDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    ArrayList<providerDTO> lista = new ArrayList<>();
    
    public ArrayList<providerDTO> listar(){
    String sql = "select * from tb_provider ";
     conn = new connectionDAO().conectaBD();
     try {
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);
         
         while(rs.next()){
              providerDTO objproviderdto = new providerDTO();
              objproviderdto.setId_provider(rs.getInt("id_provider"));
              objproviderdto.setName(rs.getString("name"));
              objproviderdto.setContact(rs.getString("contact"));
              
             lista.add(objproviderdto);
                     }
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null,"providerDAO" + erro);
     }
        return lista;
    
    }
    
    public void cadastrar(providerDTO objproviderdto){
    String sql = "insert into tb_provider(name, contact) values (?, ?)";
    conn = new connectionDAO().conectaBD();
    
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objproviderdto.getName());
            stmt.setString(2, objproviderdto.getContact());
                       
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "providerDAO: " + e.getMessage());
        }
    }
    
    public void atualizar(providerDTO objproviderdto){
        String sql = "update tb_provider set name = ?, contact = ? where id_provider = ?";
    conn = new connectionDAO().conectaBD();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objproviderdto.getName());
            stmt.setString(2, objproviderdto.getContact());
            stmt.setInt(3, objproviderdto.getId_provider());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "providerDAO: " + e.getMessage());
    }
    }
    
    public void deletar(providerDTO objproviderdto){
        String sql = "delete from tb_provider where id_provider = ?";
        conn = new connectionDAO().conectaBD();
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objproviderdto.getId_provider());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "providerDAO: " + e.getMessage());
        }
    
    }
}
