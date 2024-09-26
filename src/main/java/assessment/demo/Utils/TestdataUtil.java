package assessment.demo.Utils;

import org.testng.annotations.DataProvider;

public class TestdataUtil {

    @DataProvider(name = "testdata")
    public Object[][] gettestdata() {
        return new Object[][] {
                {"TestCase1","To check login with standard user,verify Price low to high sorting,add backpack to cart,enter user details, finish checkout","standard_user", "secret_sauce","price-low to high","backpack","TestName1", "LastName1", "20395","finish"},
                {"TestCase2","To check login with standard user,verify Price high to low sorting,add bike light to cart,enter user details, cancel checkout","standard_user", "secret_sauce","Price high to low","bike-light","TestName2", "LastName2", "20397","cancel"},
                {"TestCase3","To check login with problem user,verify no sorting,capture failure if no items added to cart","problem_user", "secret_sauce","nosort", "fleece-jacket","TestName3", "LastName3", "20394","finish"}
        };
    }
}
