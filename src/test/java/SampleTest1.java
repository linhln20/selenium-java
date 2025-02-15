import org.testng.annotations.*;

public class SampleTest1 {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test
    void tc01(){
        System.out.println("tc01");
    }

    @Test
    void tc02(){
        System.out.println("tc02");
    }

    @Test
    void tc03(){
        System.out.println("tc03");
    }

    @Test
    void tc04(){
        System.out.println("tc04");
    }

    @Test
    void tc05(){
        System.out.println("tc05");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("After Suite");
    }
}
