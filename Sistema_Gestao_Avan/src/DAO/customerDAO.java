package DAO;

import DTO.customerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class customerDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    ArrayList<customerDTO> lista = new ArrayList<>();
    
    public ArrayList<customerDTO> listar(){
    String sql = "select * from tb_customer ";
     conn = new connectionDAO().conectaBD();
     try {
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);
         
         while(rs.next()){
              customerDTO objcustomerdto = new customerDTO();
              objcustomerdto.setId_customer(rs.getInt("id_customer"));
              objcustomerdto.setName(rs.getString("name"));
              objcustomerdto.setCPF(rs.getString("CPF"));
              
             lista.add(objcustomerdto);
                     }
     } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null,"customerDAO" + erro);
     }
        return lista;
    }
    
    public void cadastrar(customerDTO objcustomerdto){
    String sql = "insert into tb_customer(name, CPF) values (?, ?)";
    conn = new connectionDAO().conectaBD();
    
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objcustomerdto.getName());
            stmt.setString(2, objcustomerdto.getCPF());
                       
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "customerDAO: " + e.getMessage());
        }
    }
    
    public void atualizar(customerDTO objcustomerdto){
        String sql = "update tb_customer set name = ?, CPF = ? where id_customer = ?";
        conn = new connectionDAO().conectaBD();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objcustomerdto.getName());
            stmt.setString(2, objcustomerdto.getCPF());
            stmt.setInt(3, objcustomerdto.getId_customer());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "customerDAO: " + e.getMessage());
    }
    }
    
    public void deletar(customerDTO objcustomerdto){
        String sql = "delete from tb_customer where id_customer = ?";
        conn = new connectionDAO().conectaBD();
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objcustomerdto.getId_customer());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "customerDAO: " + e.getMessage());
        }
    
    }
}
