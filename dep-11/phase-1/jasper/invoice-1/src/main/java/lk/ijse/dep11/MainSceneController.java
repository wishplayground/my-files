package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import lk.ijse.dep11.dto.Item;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;

public class MainSceneController {
    public Spinner<Integer> txtQty;
    public Button btnView;
    public Button btnExport;
    public AnchorPane root;

    public void initialize(){
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,1,1));
    }

    public void btnExportOnAction(ActionEvent event) throws JRException {
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/reports/invoice-1.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(),new JREmptyDataSource(txtQty.getValue()));

        //save
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF","*.pdf"));
        File file = fileChooser.showSaveDialog(root.getScene().getWindow());
        JasperExportManager.exportReportToPdfFile(jasperPrint,file.getAbsolutePath());
    }

    public void btnViewOnAction(ActionEvent event) throws JRException {
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/reports/invoice-1.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(),new JREmptyDataSource(txtQty.getValue()));
        JasperViewer.viewReport(jasperPrint,false);

    }

    private JasperPrint getJasperPrint() throws Exception{
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/reports/invoice-1.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        HashMap<Object, Object> para = new HashMap<>();
        para.put("invoiceId","2#");
        para.put("name","Amal Awinash");
        para.put("date", LocalDate.now());

        return JasperFillManager.fillReport(jasperReport,para,new JRBeanCollectionDataSource())
    }
}
