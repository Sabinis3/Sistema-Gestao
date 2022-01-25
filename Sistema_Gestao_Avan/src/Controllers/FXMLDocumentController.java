/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controllers;

import DAO.userDAO;
import DTO.Type_CombDTO;
import DTO.userDTO;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btn_logar;

    @FXML
    private ComboBox<Type_CombDTO> comb_type;
    private List<Type_CombDTO> lista = new ArrayList<>();
    private ObservableList<Type_CombDTO> obscomb;

    @FXML
    private TextField txtlogin;
    

    @FXML
    private TextField txtpassword;
    
    @FXML
    private void Logar(ActionEvent event) {
        if(txtlogin.getText().isEmpty() || txtpassword.getText().isEmpty() || 
                comb_type.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Prencha todos os campos!");
        }else{
        try {

            userDTO objuserdto = new userDTO();
            String name, password, type_user;

            name = txtlogin.getText();
            password = txtpassword.getText();
            type_user = comb_type.getSelectionModel().getSelectedItem().toString();
            
            objuserdto.setName(name);
            objuserdto.setPassword(password);
            objuserdto.setType_user(type_user);
            
            userDAO objuserdao = new userDAO();
            ResultSet result =  objuserdao.verificar(objuserdto);
            
            if(result.next()){
                
            if(type_user == "Comum"){
                JOptionPane.showMessageDialog(null, "Acesso Negado");
            } else{
                try {
                    Stage stage_atual = (Stage) btn_logar.getScene().getWindow();
                    stage_atual.close();
                    
                    Parent root;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/XML/FXMLmenuAdmin.fxml"));
                    root = loader.load();
                    
                    FXMLmenuAdminController controller = loader.getController();
                    controller.pegar_nome(name);
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                    } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "FXMLmenuAdmin" + e);
                    }
            }
            }else{
                JOptionPane.showMessageDialog(null, "Dados Incorretos");
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "FRMLDocumentController" + e);
        }
        }
    }
        
    public void carregarcomb(){
        Type_CombDTO comb_item1 =  new Type_CombDTO(1, "Admin");
        Type_CombDTO comb_item2 =  new Type_CombDTO(2, "Comum");
        
        lista.add(comb_item1);
        lista.add(comb_item2);
        
        obscomb = FXCollections.observableArrayList(lista);
        comb_type.setItems(obscomb);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarcomb();
    }    
    
}
