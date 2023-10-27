package lk.ijse.dep11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSuit2 {
    @Test
    void testCase1(){
        System.out.println("Test case 1 " + this);
    }
    @Test
    void testCase2(){
        System.out.println("Test case 2 " + this);
    }
}
