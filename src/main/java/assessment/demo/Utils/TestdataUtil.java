package assessment.demo.Utils;

import org.testng.annotations.DataProvider;

public class TestdataUtil {

    @DataProvider(name = "testdata")
    public Object[][] gettestdata() {
        return new Object[][] {
                {"standard_user", "secret_sauce","backpack","Test1", "Last1", "20395","finish"},
                {"standard_user", "secret_sauce","bike-light","Test2", "Last2", "20397","cancel"},
                {"problem_user", "secret_sauce", "fleece-jacket","Test3", "Last3", "20394","finish"}
        };
    }
}
