package DAO;

import DTO.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class customerDAO {
    
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    public void cadastrar(CustomerDTO objcustomer){
       String sql = "insert into tb_customer(name, CPF)values(?,?)";
        conn = new connectionDAO().conectaBD();
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objcustomer.getName());
            stmt.setString(2, objcustomer.getCpf());
            
            stmt.execute();
            stmt.close();
    } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "customerDAO: " + erro.getMessage());
    }
    }
    
}
