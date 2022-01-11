package DAO;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class userDAO {
    
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    
    public ResultSet verificar(UserDTO objuserdto){
    String sql = "select * from tb_user where name = ? and type_user = ? and password = ?";
    conn = new connectionDAO().conectaBD();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objuserdto.getName());
            stmt.setString(2, objuserdto.getType_user());
            stmt.setString(3, objuserdto.getPassword());
            
            rs = stmt.executeQuery();
            return rs;
       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "userDAO: " + e);
            return null;
        }
    
        
    }
}
