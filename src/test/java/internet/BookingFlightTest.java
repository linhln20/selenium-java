package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingFlightTest {
    /**
     * Open Chrome
     * Navigate https://www.vietnamairlines.com/vn/en/home
     * Select Depart date is 10/1/2025
     * Verify Depart Date value is 10/1/2025
     */

    @Test (groups = {"wip"})
    void verifyAbleSelectDepartDate1(){
    WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    driver.get("https://www.vietnamairlines.com/vn/en/home");
    driver.findElement(By.xpath("//*[@id=\"city-to-roundtrip\"]")).click();
    driver.findElement(By.linkText("Tp. Hồ Chí Minh (SGN), Việt Nam")).click();
    driver.findElement(By.xpath("//*[@id=\"byt-datespicker\"]/div/div[1]"));
    String Day = driver.findElement(By.cssSelector("#byt-datespicker > div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(2) > td:nth-child(5)")).getCssValue("10");

    Assert.assertTrue(Boolean.parseBoolean(String.valueOf(driver.findElement(By.xpath("//*[@id=\"roundtrip-date-depart\"]")).getText().contains("10/01/2025"))));
    }
    @Test (groups = {"wip"})
    void verifyAbleSelectDepartDate2(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        driver.findElement(By.id("cookie-agree")).click();

        driver.findElement(By.xpath("//*[@id=\"city-to-roundtrip\"]")).click();

        driver.findElement(By.id("roundtrip-date-depart")).click();
        driver.findElement(By.xpath("//*[@id=\"to-bookYourTripTo-vietnam\"]/ul/li[1]/a/div")).click();
        driver.findElements(By.cssSelector(".ui-datepicker-calendar"))
                .get(0)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("10"))
                .findFirst()
                .get()
                .click();

        driver.findElements(By.cssSelector(".ui-datepicker-calendar"))
                .get(1)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("4"))
                .findFirst()
                .get()
                .click();

        driver.findElement(By.className("confirm-dates")).click();

        Assert.assertEquals(driver.findElement(By.id("roundtrip-date-depart")).getDomProperty("value"),"10/01/2025");
    driver.quit();
    }

}
