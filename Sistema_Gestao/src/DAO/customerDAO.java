package DAO;

import DTO.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class customerDAO {
    
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    public void cadastrar(Customer objcustomer){
       String sql = "insert into tb_customer(NAME, CPF)values(?,?,?)";
        conn = new connectionDAO().conectaBD();
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objcustomer.getName());
            stmt.setString(3, objcustomer.getCpf());
            
            stmt.execute();
            stmt.close();
    } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "customerDAO: " + erro);
    }
    }
    
}
