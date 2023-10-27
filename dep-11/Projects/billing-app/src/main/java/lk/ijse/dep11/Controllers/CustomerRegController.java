package lk.ijse.dep11.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.dep11.CustomerDetails;
import lk.ijse.dep11.TableCustomer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerRegController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtAddress;
    public Button btnNew;
    public TextField txtSearch;
    public ComboBox<String> cmbSearch;
    public Button btnAdd;
    public TableView<CustomerDetails> tblDetails;
    public AnchorPane rootRecord;
    public ImageView imvProfile;
    public Button btnExit;
    private ArrayList<CustomerDetails> customers  = new ArrayList<>();



    public void initialize(){

        initialState();
        txtId.setEditable(true);
        cmbSearch.getItems().add("ID");
        cmbSearch.getItems().add("Name");
        cmbSearch.getItems().add("Phone number");
        btnNew.requestFocus();
        File file = new File("Customers");
        if(!file.exists()) file.mkdir();

        //create image containing folder
        File file1 = new File("Profiles");
        if(!file1.exists()) {
            file1.mkdir();
        }

        //table initialize
        tblDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));

        //loading files to table
        customers = readData();
        ObservableList<CustomerDetails> customerObservableList = FXCollections.observableList(customers);
        tblDetails.setItems(customerObservableList);
        Platform.runLater(() ->{
            rootRecord.getScene().getWindow().setOnCloseRequest(event ->{
                saveData();
            });
        });

        tblDetails.getSelectionModel().selectedItemProperty().addListener(e ->{
            CustomerDetails select = tblDetails.getSelectionModel().getSelectedItem();
            txtId.setText(select.getId());
            txtName.setText(select.getName());
            txtContact.setText(select.getContactNo());
            txtAddress.setText(select.getAddress());
            imvProfile.setImage(new Image(select.getImgPath()));
        });
    }
    public void btnNewOnAction(ActionEvent event) {
        txtId.setDisable(false);
        txtId.setText(generateCustomerId());
        for (Control control : new Control[] {txtAddress,txtContact,txtName}) {
            control.setDisable(false);
            ((TextField) control).clear();
        }

        imvProfile.setVisible(true);
        imvProfile.setImage(new Image("Media/adduser.jpeg"));
        txtId.setEditable(false);
        btnAdd.setDisable(false);
        txtName.requestFocus();
    }
    public void btnAddOnAction(ActionEvent event) {
        if(!isValid()) return;
        CustomerDetails customer = new CustomerDetails(txtId.getText(), txtName.getText(), txtContact.getText(), txtAddress.getText(),imvProfile.getImage().getUrl().toString());
        tblDetails.getItems().add(customer);
        initialState();

    }
    public void txtNameOnAction(ActionEvent event) {
        txtContact.requestFocus();
    }
    public void txtContactOnAction(ActionEvent event) {
        if(existingContact(txtContact.getText())){
            txtContact.selectAll();
            txtContact.requestFocus();
            btnAdd.setDisable(true);
        }else txtAddress.requestFocus();
    }
    public ArrayList<CustomerDetails> readData(){
        File fileRead = new File("Customers/customerdata.db");

        try {
            if(!fileRead.exists()) {
                return new ArrayList<>();
            } else {
                FileInputStream fis = new FileInputStream(fileRead);
                BufferedInputStream bis = new BufferedInputStream(fis);
                try{
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    return  (ArrayList<CustomerDetails>)ois.readObject();
                }finally {
                    bis.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
    public boolean existingContact(String contact){
        for (CustomerDetails customer : tblDetails.getItems()) {
            if(customer.getContactNo().equals(contact)) {
                new Alert(Alert.AlertType.ERROR,"Contact number already exist").show();
                return true;
            }
        }
        return false;
    }

    public void initialState(){
        for (Control control : new Control[] {txtName,txtAddress,txtSearch,btnAdd,txtContact,cmbSearch}) {
            if(control instanceof ComboBox) ((ComboBox<String>) control).setPromptText("Search option");
            else if(control instanceof Button) control.setDisable(true);
            control.setDisable(true);
        }
        txtId.clear();
        txtName.clear();
        txtContact.clear();
        txtAddress.clear();
        imvProfile.setVisible(false);
        if(txtSearch.getText() != null) txtSearch.clear();
        if(cmbSearch.getValue() != null) cmbSearch.setPromptText("Select Option");
    }

    public void btnExitOnAction(ActionEvent event) {
        ((Stage)rootRecord.getScene().getWindow()).close();
        Platform.runLater(() ->{
            rootRecord.getScene().getWindow().setOnCloseRequest(evt ->{
                saveData();
            });
        });
    }
    public List<CustomerDetails> getCustomers(){
        return tblDetails.getItems();
    }
    public String generateCustomerId(){
        if(getCustomers().isEmpty()) return "C-0001";
        int newCustomerId = Integer.parseInt(tblDetails.getItems().get(getCustomers().size() - 1).getId().substring(2)) + 1;
        return String.format("C-%04d",newCustomerId);
    }

    public void saveData(){
        //on arraylist because arraylist is serializable
        File fileSave = new File("Customers/customerdata.db");

        try {
            fileSave.createNewFile();
            FileOutputStream fos = new FileOutputStream(fileSave);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(customers);
            System.out.println("Saved data");
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void imvProfileOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files","*.jpg","*.jpeg","*.png"));
        File imgFile = fileChooser.showOpenDialog((rootRecord).getScene().getWindow());

        //File save to in Media directory
        File tempFile = new File("Profiles/" +imgFile.getName());
        tempFile.createNewFile();
        FileInputStream fis = new FileInputStream(imgFile);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(tempFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //copy
        byte[] buffer = new byte[1024];
        int read = -2;
        while(read != -1){
            read = bis.read(buffer);
            bos.write(buffer);
        }
        bos.close();
        new Alert(Alert.AlertType.INFORMATION,"Image Saved").show();
        Image image = new Image(tempFile.toURI().toString());
        imvProfile.setImage(image);
        mouseEvent.consume();
    }

    public boolean isValid(){
        if(!txtName.getText().matches("[A-Z-a-z ]+") || !txtContact.getText().matches("0\\d{9}")) {
            new Alert(Alert.AlertType.ERROR,"Name or Contact format error").show();
            return false;
        }

        return true;
    }

    public void txtIdOnAction(ActionEvent event) {
        for (CustomerDetails customer : getCustomers()) {
            if(txtId.getText().equals(customer.getId())){
                txtId.setText(customer.getId());
                txtName.setText(customer.getName());
                txtContact.setText(customer.getContactNo());
                txtAddress.setText(customer.getAddress());
            }
        }
        new Alert(Alert.AlertType.INFORMATION,txtId.getText().concat(" not an existing Customer")).show();
    }
}
