package Utils;

import com.TestBase.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions extends TestBase {

    static SoftAssert softAssert= new SoftAssert();

    public static void assertEquals(String actual, String expected)
    {
        try {
            Assertions.assertEquals(actual,expected);
          //  test.log(Status.PASS,"Assertions Passed: Actual Value is" +actual+"Expected Value is "+expected);
        }catch (Error error)
        {
//            test.log(Status.FAIL,"Assertions Failed: Actual Value is" +error.getMessage()+"Expected Value is "+expected);
            error.printStackTrace();
            Assertions.assertEquals(actual,expected);
        }


    }
    public static void softAssertEquals(String actual, String expected, String message)
    {
        try {
            Assertions.assertEquals(actual,expected);
            test.log(Status.PASS,"Assertions Passed: Actual Value is" +actual+"Expected Value is "+expected + " :"+ message);
            test.log(Status.PASS,"Assertion passed",Helpers.screenshot());
        }catch (Error error)
        {
            test.log(Status.FAIL,"Assertions Failed: Actual Value is" +error.getMessage()+"Expected Value is "+expected, Helpers.screenshot());
            error.printStackTrace();
          //  Assertions.assertEquals(actual,expected);
        }


    }
    public static void assertTrue(boolean asserting, String message){
        try{
            Assert.assertTrue(asserting);
//            test.log(Status.PASS,"Assertion passed");
         //   test.log(Status.PASS,"Assertion passed",Helpers.screenshot());

        }
        catch (AssertionError error)
        {
            test.log(Status.FAIL,"Assertion Failed" +message+ "," + error.getMessage(),Helpers.screenshot());
            error.printStackTrace();
            Assert.assertTrue(asserting);
        }

    }
    public static void assertFalse(boolean asserting){
        try{
            Assert.assertFalse(asserting);
            test.log(Status.FAIL,"Assertion Failed");
            test.log(Status.FAIL,"Assertion Failed",Helpers.screenshot());

        }
        catch (AssertionError error)
        {
            test.log(Status.FAIL,"Assertion Failed" + "," + error.getMessage(),Helpers.screenshot());
            error.printStackTrace();
            Assert.assertFalse(asserting);
        }

    }

}
