package Controllers;

import DAO.customerDAO;
import DAO.productsDAO;
import DAO.providerDAO;
import DTO.Tabela_Customer_DTO;
import DTO.Tabela_Products_DTO;
import DTO.Tabela_Provider_DTO;
import DTO.customerDTO;
import DTO.productsDTO;
import DTO.providerDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class FXMLmenuAdminController implements Initializable {

    @FXML
    private Button btn_clientes;

    @FXML
    private Button btn_fornecedores;
    
    @FXML
    private Label label_user;
    
    @FXML
    private TextField txt_id_provider;
    
    @FXML
    private TextField txt_id_customer;
    
    @FXML
    private TextField txt_name_provider;
    
    @FXML
    private TextField txt_cpf_customer;
    
    @FXML
    private TextField txt_contact_provider;
    
    @FXML
    private TextField txt_name_customer;

    @FXML
    private Button btn_produtos;

    @FXML
    private Pane pn_customer;

    @FXML
    private Pane pn_fornecedores;

    @FXML
    private Pane pn_produtos;
    
    @FXML
    private TableView<Tabela_Products_DTO> tb_products;
    
    @FXML
    private TableView<Tabela_Provider_DTO> tb_providers;
    
    @FXML
    private TableView<Tabela_Customer_DTO> tb_customer;
    
    @FXML
    private TextField txt_cod_products;

    @FXML
    private TextField txt_id_products;

    @FXML
    private TextField txt_nome_products;

    @FXML
    private TextField txt_qtd_products;

    @FXML
    private TextField txt_type_products;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        construirtabela_products();
        construirtabela_provider();
        construirtabela_customer();
        listar_products();
        listar_provider();
        listar_customer();
        
    }
   
    public void trocarpane(ActionEvent event){
        if(event.getSource() == btn_fornecedores){
            pn_fornecedores.toFront();
        }
        if(event.getSource() == btn_produtos){
            pn_produtos.toFront();
        }
        if(event.getSource() == btn_clientes){
            pn_customer.toFront();
        }
      
    }
    
    public void pegar_nome(String name){
        label_user.setText("Usuário: "+name);
    }
    
    public void listar_products(){
        tb_products.getItems().clear();
        try {
            productsDAO objproductsdao = new productsDAO();

            ArrayList<productsDTO> lista = objproductsdao.listar();
            Object[] Linha = new Object[5];
            for (int i = 0; i < lista.size(); i++) {
                Linha[0] = lista.get(i).getId_product();
                Linha[1] = lista.get(i).getName();
                Linha[2] = lista.get(i).getType_product();
                Linha[3] = lista.get(i).getQtd();
                Linha[4] = lista.get(i).getCod_provider();
                tb_products.getItems().add(new Tabela_Products_DTO((Integer) Linha[0], 
                        (String) Linha[1], (String) Linha[2], (Integer) Linha[3], (Integer) Linha[4]));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FXMLmenuAdminController" + erro);
        }
    }
    
    public void listar_provider(){
        tb_providers.getItems().clear();
        try {
            providerDAO objproviderdao = new providerDAO();

            ArrayList<providerDTO> lista = objproviderdao.listar();
            Object[] Linha = new Object[3];
            for (int i = 0; i < lista.size(); i++) {
                Linha[0] = lista.get(i).getId_provider();
                Linha[1] = lista.get(i).getName();
                Linha[2] = lista.get(i).getContact();
                tb_providers.getItems().add(new Tabela_Provider_DTO((Integer) Linha[0], 
                        (String) Linha[1], (String) Linha[2]));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FXMLmenuAdminController" + erro);
        }
    }
    
    public void listar_customer(){
        tb_customer.getItems().clear();
        try {
            customerDAO objcustomerdao = new customerDAO();

            ArrayList<customerDTO> lista = objcustomerdao.listar();
            Object[] Linha = new Object[3];
            for (int i = 0; i < lista.size(); i++) {
                Linha[0] = lista.get(i).getId_customer();
                Linha[1] = lista.get(i).getName();
                Linha[2] = lista.get(i).getCPF();
                tb_customer.getItems().add(new Tabela_Customer_DTO((Integer) Linha[0], 
                        (String) Linha[1], (String) Linha[2]));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FXMLmenuAdminController" + erro);
        }
    
    }
    
    public void carregarcampos_products(){
        if (tb_products.getSelectionModel().getSelectedItems() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um produto da tabela!");
        } else {
            txt_id_products.setText((tb_products.getSelectionModel().getSelectedItem().getId_product().toString()));
            txt_nome_products.setText((tb_products.getSelectionModel().getSelectedItem().getName()));
            txt_type_products.setText((tb_products.getSelectionModel().getSelectedItem().getType_product()));
            txt_qtd_products.setText((tb_products.getSelectionModel().getSelectedItem().getQtd()).toString());
            txt_cod_products.setText((tb_products.getSelectionModel().getSelectedItem().getCod_provider()).toString());
        }
        
    }
    
    public void carregarcampos_provider(){
        if (tb_providers.getSelectionModel().getSelectedItems() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor da tabela!");
        } else {
            txt_id_provider.setText((tb_providers.getSelectionModel().getSelectedItem().getId_provider().toString()));
            txt_name_provider.setText((tb_providers.getSelectionModel().getSelectedItem().getName()));
            txt_contact_provider.setText((tb_providers.getSelectionModel().getSelectedItem().getContact()));
        }
    }
    
    public void carregarcampos_customer(){
        if (tb_customer.getSelectionModel().getSelectedItems() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela!");
        } else {
            txt_id_customer.setText((tb_customer.getSelectionModel().getSelectedItem().getId_customer().toString()));
            txt_name_customer.setText((tb_customer.getSelectionModel().getSelectedItem().getName()));
            txt_cpf_customer.setText((tb_customer.getSelectionModel().getSelectedItem().getCPF()));
        }
    }
    
    public void limpar_campos_produdcts(){
    txt_cod_products.setText("");
    txt_id_products.setText("");
    txt_nome_products.setText("");
    txt_qtd_products.setText("");
    txt_type_products.setText("");
    }
    
    public void limpar_campos_provider(){
    txt_id_provider.setText("");
    txt_name_provider.setText("");
    txt_contact_provider.setText("");
    }
     
    public void limpar_campos_customer(){
        txt_name_customer.setText("");
        txt_id_customer.setText("");
        txt_cpf_customer.setText("");
    }
    
    public void cadastrar_products(){
        if (txt_nome_products.getText().isEmpty() || txt_qtd_products.getText().isEmpty() 
                || txt_type_products.getText().isEmpty() || txt_cod_products.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos!");
        } else {
            productsDTO objproductdto = new productsDTO();

            String name, type;
            int qtd, cod_provider;

            name = txt_nome_products.getText();
            type = txt_type_products.getText();
            qtd = Integer.parseInt(txt_qtd_products.getText());
            cod_provider = Integer.parseInt(txt_cod_products.getText());

            objproductdto.setName(name);
            objproductdto.setType_product(type);
            objproductdto.setQtd(qtd);
            objproductdto.setCod_provider(cod_provider);

            productsDAO objproductsdao = new productsDAO();
            objproductsdao.cadastrar(objproductdto);
            
            listar_products();
        }
    }
    
    public void cadastrar_provider(){
     if (txt_name_provider.getText().isEmpty() || txt_contact_provider.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos!");
        } else {
            providerDTO objproviderdto = new providerDTO();

            String name, contact;

            name = txt_name_provider.getText();
            contact = txt_contact_provider.getText();

            objproviderdto.setName(name);
            objproviderdto.setContact(contact);

            providerDAO objproviderdao = new providerDAO();
            objproviderdao.cadastrar(objproviderdto);
            
            listar_provider();
        }
    }
    
    public void cadastrar_customer(){
     if (txt_name_customer.getText().isEmpty() || txt_cpf_customer.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos!");
        } else {
            customerDTO objcustomerdto = new customerDTO();

            String name, cpf;

            name = txt_name_customer.getText();
            cpf = txt_cpf_customer.getText();

            objcustomerdto.setName(name);
            objcustomerdto.setCPF(cpf);

            customerDAO objcustomerdao = new customerDAO();
            objcustomerdao.cadastrar(objcustomerdto);
            
            listar_customer();
        }
    }
    
    public void atualizar_produdcts(){
        if (txt_id_products.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor selecione um produto!");

        } else if (txt_nome_products.getText().isEmpty() || txt_qtd_products.getText().isEmpty() 
                || txt_type_products.getText().isEmpty() || txt_cod_products.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos!");
        } else {
            productsDTO objproductdto = new productsDTO();

            String name, type;
            int qtd, cod_provider, id;

            name = txt_nome_products.getText();
            type = txt_type_products.getText();
            qtd = Integer.parseInt(txt_qtd_products.getText());
            cod_provider = Integer.parseInt(txt_cod_products.getText());
            id = Integer.parseInt(txt_id_products.getText());

            objproductdto.setName(name);
            objproductdto.setType_product(type);
            objproductdto.setQtd(qtd);
            objproductdto.setCod_provider(cod_provider);
            objproductdto.setId_product(id);

            productsDAO objproductsdao = new productsDAO();
            objproductsdao.atualizar(objproductdto);
            listar_products();
        }
    }
    
    public void atualizar_provider(){
        if (txt_id_provider.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor selecione um fornecedor!");

        } else if (txt_name_provider.getText().isEmpty() || txt_contact_provider.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos!");
        } else {
            providerDTO objproviderdto = new providerDTO();

            String name, contact;
            int id;

            name = txt_name_provider.getText();
            contact = txt_contact_provider.getText();
            id = Integer.parseInt(txt_id_provider.getText());
      

            objproviderdto.setName(name);
            objproviderdto.setContact(contact);
            objproviderdto.setId_provider(id);
            
            providerDAO objproviderdao = new providerDAO();
            objproviderdao.atualizar(objproviderdto);
            listar_provider();
        }
    
    }
    
    public void atualizar_customer(){
        if (txt_id_customer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor selecione um cliente!");

        } else if (txt_name_customer.getText().isEmpty() || txt_cpf_customer.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Por Favor preencha todos os campos!");
        } else {
            customerDTO objcustomerdto = new customerDTO();

            String name, cpf;
            int id;

            name = txt_name_customer.getText();
            cpf= txt_cpf_customer.getText();
            id = Integer.parseInt(txt_id_customer.getText());
      
            objcustomerdto.setName(name);
            objcustomerdto.setCPF(cpf);
            objcustomerdto.setId_customer(id);
            
            customerDAO objcustomerdao = new customerDAO();
            objcustomerdao.atualizar(objcustomerdto);
            listar_customer();
        }
    
    }
    
    public void deletar_products(){
        if (txt_id_products.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor selecione um produto!");
        } else {
            productsDTO objproductdto = new productsDTO();

            int id;

            id = Integer.parseInt(txt_id_products.getText());

            objproductdto.setId_product(id);

            productsDAO objproductsdao = new productsDAO();
            objproductsdao.deletar(objproductdto);
            listar_products();
            limpar_campos_produdcts();
        }
    }
    
    public void deletar_provider(){
        if (txt_id_provider.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor selecione um fornecedor!");
        } else {
            providerDTO objproviderdto = new providerDTO();

            int id;

            id = Integer.parseInt(txt_id_provider.getText());

            objproviderdto.setId_provider(id);

            providerDAO objproviderdao = new providerDAO();
            objproviderdao.deletar(objproviderdto);
            listar_provider();
            limpar_campos_provider();
        }
    
    }
    
    public void deletar_customer(){
        if (txt_id_customer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por Favor selecione um cliente!");
        } else {
            customerDTO objcustomerdto = new customerDTO();

            int id;

            id = Integer.parseInt(txt_id_customer.getText());

            objcustomerdto.setId_customer(id);

            customerDAO objcustomerdao = new customerDAO();
            objcustomerdao.deletar(objcustomerdto);
            listar_customer();
            limpar_campos_customer();
        }
    
    }
    
    public void construirtabela_provider(){
        TableColumn<Tabela_Customer_DTO,Integer> colId = new TableColumn("ID");
        colId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId_customer()).asObject() );

        TableColumn<Tabela_Customer_DTO,String> colName = new TableColumn("Nome");
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Tabela_Customer_DTO,String> colCPF = new TableColumn("CPF");
        colCPF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCPF()));


        tb_customer.getColumns().addAll(colId, colName, colCPF);
    }
    
    public void construirtabela_products(){
        TableColumn<Tabela_Products_DTO,Integer> colId = new TableColumn("ID");
        colId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId_product()).asObject() );

        TableColumn<Tabela_Products_DTO,String> colName = new TableColumn("Nome");
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Tabela_Products_DTO,String> colType = new TableColumn("Tipo");
        colType.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType_product()));

        TableColumn<Tabela_Products_DTO,Integer> colQTD = new TableColumn("Quantidade");
        colQTD.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQtd()).asObject() );
        
        TableColumn<Tabela_Products_DTO,Integer> colCod = new TableColumn("Cod do Provedor");
        colCod.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCod_provider()).asObject() );

        tb_products.getColumns().addAll(colId, colName, colType, colQTD, colCod);
    }
    
    public void construirtabela_customer(){
        TableColumn<Tabela_Provider_DTO,Integer> colId = new TableColumn("ID");
        colId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId_provider()).asObject() );

        TableColumn<Tabela_Provider_DTO,String> colName = new TableColumn("Nome");
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Tabela_Provider_DTO,String> colcontact = new TableColumn("Contato");
        colcontact.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getContact()));


        tb_providers.getColumns().addAll(colId, colName, colcontact);
    }
}
