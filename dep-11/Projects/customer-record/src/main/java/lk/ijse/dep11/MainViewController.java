package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MainViewController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtAddress;
    public Button btnNew;
    public ImageView imvImage;
    public TextField txtSearch;
    public ComboBox<String> cmbSearch;
    public Button btnAdd;
    public TableView<Table> tblDetails;
    public AnchorPane rootRecord;
    private ArrayList<CustomerDetails> customers;


    public void initialize(){

        imvImage.setVisible(false);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        btnAdd.setDisable(true);
        cmbSearch.getItems().add("ID");
        cmbSearch.getItems().add("Name");
        cmbSearch.getItems().add("Phone number");
        btnNew.requestFocus();
        File file = new File("Customer");
        if(!file.exists()) file.mkdir();

        //create image containing folder
        File file1 = new File("Media");
        if(!file1.exists()) file1.mkdir();

        //table initialize
        tblDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));

        //loading files to table
        loadTable(file);

        txtId.textProperty().addListener(e ->{
            boolean valid = false;
            valid = !txtAddress.isDisabled() && txtId.getText().length() > 3 && !isExist(txtId.getText()) && idIsValid(txtId.getText());
            btnAdd.setDisable(!valid);
        });

        tblDetails.getSelectionModel().selectedItemProperty().addListener(e ->{
            txtName.setDisable(false);
            txtContact.setDisable(false);
            txtAddress.setDisable(false);
            btnAdd.setDisable(true);
            for (CustomerDetails customer : customers) {
                if (tblDetails.getSelectionModel().getSelectedItem().getId().equals(customer.getId())){
                    txtId.setText(tblDetails.getSelectionModel().getSelectedItem().getId());
                    txtName.setText(tblDetails.getSelectionModel().getSelectedItem().getName());
                    txtContact.setText(tblDetails.getSelectionModel().getSelectedItem().getContactNo());
                    txtAddress.setText(tblDetails.getSelectionModel().getSelectedItem().getAddress());
                    imvImage.setVisible(true);
                    imvImage.setImage(new Image(customer.getImgPath()));
                    System.out.println(customer.getImgPath());
                }
            }


        });
    }
    public void btnNewOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtContact.clear();
        txtAddress.clear();
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        txtContact.setDisable(false);
        imvImage.setVisible(true);
        txtId.requestFocus();
        txtId.setPromptText("Enter Id here");
    }



    public void btnAddOnAction(ActionEvent event) {


        tblDetails.getItems().add(new Table(txtId.getText(),txtName.getText(),txtContact.getText(),txtAddress.getText()));
        CustomerDetails customer = new CustomerDetails(txtId.getText(), txtName.getText(), txtContact.getText(), txtAddress.getText(),imvImage.getImage().getUrl().toString());
        String path = String.format("/Customer/Customer-%s.det",txtId.getText());
        File fileRef = new File(path);
        System.out.println(fileRef.exists());
        try {
            fileRef.createNewFile();
            FileOutputStream fos = new FileOutputStream(fileRef);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customer);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imvImage.requestFocus();
        //btnNew.fire();
    }



    public void imvImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files","*.jpg","*.jpeg","*.png"));
        File imgFile = fileChooser.showOpenDialog((rootRecord).getScene().getWindow());


        //File save to in Media directory
        File tempFile = new File("Media/" +imgFile.getName());
        tempFile.createNewFile();
        FileInputStream fis = new FileInputStream(imgFile);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(tempFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //copy
        byte[] buffer = new byte[1024];
        int read = -2;
        while(/*(read = bis.read(buffer)*/read != -1){
            read = bis.read(buffer);
            bos.write(buffer);
        }
        bos.close();
        new Alert(Alert.AlertType.INFORMATION,"Image Saved").show();
        Image image = new Image(tempFile.toURI().toString());
        imvImage.setImage(image);
        btnNew.requestFocus();
    }

    public void txtIdOnAction(ActionEvent event) {
        if(isExist(txtId.getText())){
            new Alert(Alert.AlertType.ERROR,"Alrady exist").show();
            txtId.selectAll();
            txtId.requestFocus();
        }else txtName.requestFocus();
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
    public void txtAddressMouseClicked(MouseEvent mouseEvent) {
        if(existingContact(txtContact.getText())){
            txtContact.selectAll();
            txtContact.requestFocus();
            btnAdd.setDisable(true);
        }
    }

    public void loadTable(File file){
        if(file.listFiles().length != 0){
            customers = new ArrayList<>();
            for (File f : Objects.requireNonNull(file.listFiles())) {
                try {
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Table table;
                    try {
                        CustomerDetails customerDetails = (CustomerDetails) ois.readObject();
                        table = new Table(customerDetails.getId(),customerDetails.getName(),customerDetails.getContactNo(),customerDetails.getAddress());
                        customers.add(customerDetails);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    tblDetails.getItems().add(table);
                    ois.close();
                } catch (Throwable e) {
                    e.printStackTrace();
                }


            }
        }
    }
    public boolean isExist(String id){
        for (Table item : tblDetails.getItems()) {
            if(item.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public boolean isExistFile(String path){
        for (Table item : tblDetails.getItems()) {
            if(item.getContactNo().equals(path)){
                return true;
            }
        }
        return false;
    }

    public boolean idIsValid(String id){
        if(id.isEmpty() || !id.startsWith("cr-")){
            return false;
        }else {
            for (int i = 3; i < id.length(); i++) {
                if(!Character.isDigit(id.charAt(i))) return false;
            }
            return true;
        }
    }
    public boolean existingContact(String contact){
        for (Table item : tblDetails.getItems()) {
            if(item.getContactNo().equals(contact)) {
                new Alert(Alert.AlertType.ERROR,"Contact number already exist").show();
                return true;
            }
        }
        return false;
    }

    public void rootRecordOnMouseClicked(MouseEvent mouseEvent) {
        tblDetails.getSelectionModel().clearSelection();
        txtName.clear();
        txtId.clear();
        txtContact.clear();
        txtAddress.clear();
        txtName.setDisable(true);
        txtContact.setDisable(true);
        txtAddress.setDisable(true);
        imvImage.setImage(null);
    }
}
