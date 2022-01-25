package DAO;

import DTO.userDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class userDAO {
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    
    public ResultSet verificar(userDTO objuserdto){
        sql = "select * from tb_user where name = ? and password = ? and type_user = ? ";
        conn = new connectionDAO().conectaBD();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, objuserdto.getName());
            stmt.setString(2, objuserdto.getPassword());
            stmt.setString(3, objuserdto.getType_user());
            
            rs = stmt.executeQuery();
            return rs;
       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "userDAO: " + e);
            return null;
        }
    
    }
}
