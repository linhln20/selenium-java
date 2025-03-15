package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;


public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static void openBrowser(String browser) {
        String uniqueDir = "browser-user-data-" + Instant.now().toEpochMilli();
        Path userDataPath = Paths.get(System.getProperty("java.io.tmpdir"), uniqueDir);

        try {
            Files.createDirectories(userDataPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (browser.toLowerCase()) {
            case "chrome-headless": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--user-data-dir=" + userDataPath.toAbsolutePath());
                options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage", "--remote-debugging-port=0");
                driver = new ChromeDriver(options);
                break;
            }
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--user-data-dir=" + userDataPath.toAbsolutePath());
                driver = new ChromeDriver(options);
                break;
            }
            case "firefox-headless": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
                break;
            }
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-profile", userDataPath.toAbsolutePath().toString());
                driver = new FirefoxDriver(options);
                break;
            }
            case "edge-headless": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--user-data-dir=" + userDataPath.toAbsolutePath());
                options.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage", "--remote-debugging-port=0");
                driver = new EdgeDriver(options);
                break;
            }
            case "edge": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--user-data-dir=" + userDataPath.toAbsolutePath());
                driver = new EdgeDriver(options);
                break;
            }
            default:
                throw new IllegalArgumentException("Trình duyệt không được hỗ trợ: " + browser);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static List<WebElement> all(By locator) {
        return driver.findElements(locator);
    }

    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static void back(){
        driver.navigate().back();}

    public static void clearBrowserCache() {
        WebDriver driver = Browser.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }

        try {
            driver.get("chrome://settings/clearBrowserData");
            Thread.sleep(1000);

            Actions actions = new Actions(driver);
            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();
            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();
            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();
            actions.sendKeys(org.openqa.selenium.Keys.ENTER).perform();

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error while clearing cache", e);
        }
    }

    public static void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//        driver.findElement(locator).click();
    }

    public static void clickCheckBox(By locator){
        driver.findElement(locator).click();
    }

    public static void clickBtn(By locator){
        driver.findElement(locator).click();
    }

    public static void clickText(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    public static void captureScreen(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public static void doubleClick(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).perform();
    }

    public static void executeScript(WebElement element, String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public static void fill(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static void fillInt(By locator, int text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(String.valueOf(text));
    }

    public static void fillDouble(By locator, double text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(String.valueOf(text));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static int[] getImageProperty(By locator){
        int[] dimensions = new int[2];
        driver.findElements(locator).forEach(img -> {
            dimensions[0] = Integer.parseInt(img.getDomProperty("naturalHeight"));
            dimensions[1] = Integer.parseInt(img.getDomProperty("naturalWidth"));
        });
        return dimensions;
    }
    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static List<WebElement> getList(By locator){
        return driver.findElements(locator);
    }

    public static int getSize(By locator){
       return driver.findElements(locator).size();
    }

    public static void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public static void initializeWait(int timeout){
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }


    public static void maximize(){
        driver.manage().window().maximize();
    }

    public static void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public static void quit(){
        driver.quit();
    }

    public static void swithToFrame(String name){
        driver.switchTo().frame(name);
    }

    public static void swithParentFrame(){
        driver.switchTo().parentFrame();
    }
    public static void swithDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public static void select(By locator){
        driver.findElement(locator).click();
    }

    public static void sentKey(String key){
        driver.switchTo().alert().sendKeys(key);
    }
    public static void sentText(By locator, String text){
    driver.findElement(locator).sendKeys(text);
    }

    public static void reloadPage(){
        driver.navigate().refresh();
    }

    public static void visit(String url){
        driver.get(url);
    }

}
