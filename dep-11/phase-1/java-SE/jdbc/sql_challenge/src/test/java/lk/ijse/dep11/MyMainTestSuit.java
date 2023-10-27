package lk.ijse.dep11;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyMainTestSuit {

    /*@BeforeAll
    static void isWorking(){
        System.out.println("isWorking all test cases");
    }*/
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all test cases");
    }



   /* @BeforeAll
    static void beforWorking(){
        System.out.println("BeforeWorking all test cases");
    }*/

    @AfterAll
    static void afterAll(){
        System.out.println("After All Test cases");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After each test");

    }

    @Test
    @Order(1)
    @DisplayName("Add new custom")
    void testCase1(){
        System.out.println("Test case 1");
    }

    @Test
    @Order(2)
    void testCase2(){
        System.out.println("Test case 2");
    }

    @Nested
    class NestedTestSuit{
        /*@BeforeAll
        void beforeAll(){
            System.out.println("Before all test cases");
        }*/

        @BeforeEach
        void setUp(){
            System.out.println("Before each Nested test");
        }

        @AfterEach
        void tearDown(){
            System.out.println("After each Nested test");

        }

        @Test
        void testCase3(){
            System.out.println("Test case 3");
        }

        @Test
        void testCase4(){
            System.out.println("Test case 4");
        }
    }
}
