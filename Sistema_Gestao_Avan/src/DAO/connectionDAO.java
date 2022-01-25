package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connectionDAO {
    public Connection conectaBD(){// metódo plúblico do tipo connection
        Connection conn = null; //variável do tipo connection de nome conn, inicializada nula
        
        
        try{//o try tenta executar um codígo, caso ocorra erro ele executa o cathc
            String url //recebe o conteúdo da url de conexão
            = "jdbc:mysql://localhost:3306/bd_gestao?user=root&password=";// endereço do banco de dados
            
            conn= DriverManager.getConnection(url);// drivemanager gerencia o driver, o metódo getconnection pega a url 
            
        }
        catch (SQLException erro){// mostra o erro que houve no try
            JOptionPane.showMessageDialog(null,"connectionDAO: " + erro.getMessage());// exibe uma mensagem de erro
            
        }
         return conn;// retorna a conexão             
        }
}
