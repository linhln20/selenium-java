import org.testng.annotations.*;

public class SampleTest2 {
    @BeforeGroups("smoke")
        void beforeGroup(){
        System.out.println("Before smoke test");
    }

    @BeforeSuite
    void beforeSuite(){
        System.out.println("SampleTest2: Before Suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("SampleTest2: Before Test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("SampleTest2: Before Class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("SampleTest2: Before Method");
    }

    @Test
    void tc01(){
        System.out.println("SampleTest2: tc01");
    }

    @Test
    void tc02(){
        System.out.println("SampleTest2: tc02");
    }

    @Test
    void tc03(){
        System.out.println("SampleTest2: tc03");
    }

    @Test (groups = {"smoke", "login"})
    void tc04(){
        System.out.println("tc04");
    }

    @Test (groups = {"checkout"})
    void tc05(){
        System.out.println("tc05");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("SampleTest2: After Method");
    }

    @AfterClass
    void afterClass(){
        System.out.println("SampleTest2: After Class");
    }

    @AfterTest
    void afterTest(){
        System.out.println("SampleTest2: After Test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("SampleTest2: After Suite");
    }
}
