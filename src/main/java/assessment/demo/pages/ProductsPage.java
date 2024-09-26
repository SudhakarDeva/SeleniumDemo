package assessment.demo.pages;

import assessment.demo.Utils.Reusables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends Reusables {
    WebDriver driver;
    String status = null;
    String temp = null;
    Double rawprice = null;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartCount;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    WebElement sortfilter;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    WebElement price;

    public String sortitems(String sortoptionraw) throws InterruptedException {

        status = "success";
        Thread.sleep(2000);
        Select select = new Select(sortfilter);
        String sortoption = sortoptionraw.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("sortoption : " + sortoption);

        //perform sorting based on user preference in input
        if (!(sortoption.equalsIgnoreCase("nosort"))) {
            if (sortoption.equalsIgnoreCase("pricelowtohigh"))
                select.selectByValue("lohi");
            else if (sortoption.equalsIgnoreCase("pricehightolow"))
                select.selectByValue("hilo");
            Thread.sleep(3000);

            //get all price from the page after sort
            List<WebElement> pricelistelements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
            List<Double> pricelist = new ArrayList<>();
            for (WebElement element : pricelistelements) {
                System.out.println(element.getText());
                temp = element.getText().substring(1);
                rawprice = Double.parseDouble(temp);
                pricelist.add(rawprice);
            }
            getscreenshot(sortoption,"Page on applying sort option",driver);

            //verify the sorting order
            for (int i = 0; i < pricelist.size() - 1; i++) {
                System.out.println("First value: " + pricelist.get(i) + " Next value:" + pricelist.get(i + 1));
                if (sortoption.equalsIgnoreCase("pricelowtohigh")) {
                    if (pricelist.get(i) > pricelist.get(i + 1))
                        status = "fail";
                } else if (sortoption.equalsIgnoreCase("pricehightolow")) {
                    if (pricelist.get(i) < pricelist.get(i + 1))
                        status = "fail";
                }
            }
        }
        return status;
    }

    public String addtoCart(String itemname) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("add-to-cart-sauce-labs-" + itemname)).click();
        System.out.println("Added " + itemname + " to the cart");
        Thread.sleep(2000);

        try {
            System.out.println("Items added to cart : " + cartCount.getText());
            status = "success";
        } catch (Exception e) {
            status = "fail";
        }
        cartIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return status;
    }

}
