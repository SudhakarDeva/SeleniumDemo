package assessment.demo.Utils;

import org.testng.annotations.DataProvider;

public class TestdataUtil {

    @DataProvider(name = "testdata")
    public Object[][] gettestdata() {
        return new Object[][] {
                {"standard_user", "secret_sauce","price-low to high","backpack","TestName1", "LastName1", "20395","finish"},
                {"standard_user", "secret_sauce","Price high to low","bike-light","TestName2", "LastName2", "20397","cancel"},
                {"problem_user", "secret_sauce","nosort", "fleece-jacket","TestName3", "LastName3", "20394","finish"}
        };
    }
}
