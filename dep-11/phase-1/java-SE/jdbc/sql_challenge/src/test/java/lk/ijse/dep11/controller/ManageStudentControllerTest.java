package lk.ijse.dep11.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ManageStudentControllerTest {

    private static final ManageStudentController controller = new ManageStudentController();
    @CsvSource({"2303111001,kasun sampath,sika,true","Dep,Amal wishvanath,amala,false"})
    @ParameterizedTest
    void addNewStudent(String id, String name, String card,boolean expectedResult) {
        assertDoesNotThrow(() ->{
            boolean result = controller.addNewStudent(id, name, card);
            assertEquals(expectedResult,result);
        });

    }
}