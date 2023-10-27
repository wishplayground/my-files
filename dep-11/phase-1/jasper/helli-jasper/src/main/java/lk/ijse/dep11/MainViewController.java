package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.util.HashMap;

public class MainViewController {
    public Button btnShow;

    public void btnShowOnAction(ActionEvent event) throws JRException {
        //Jasper soft Studio : This is where we design the report
        //Jasper report library : This is what help to intigrate the jasper report with or app
        JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/Report/Hello-jasper.jrxml"));

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);


        JasperPrint jasperPrint = JasperFillManager
                //FillReport(reportRef, parametersRef, fataSourceRef)
                .fillReport(jasperReport, new HashMap<>(), new JREmptyDataSource(8));

//        JasperViewer.viewReport(jasperPrint, false);
//        JasperPrintManager.printReport(jasperPrint, true);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/wishva/Desktop/jasperabc.pdf");
    }
}
