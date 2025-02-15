package internet;

import internet.pages.MaxDuePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DueTableTest {
    @Test
    void verifyMaxDue(){
        Browser.openBrowser("Chrome");
        MaxDuePage maxDuePage = new MaxDuePage();

        // Get the row index with the maximum due value
        int maxDueRowIndex = maxDuePage.getMaxDueRowIndex();
        System.out.println("Max due index is " + maxDueRowIndex);

        String firstName = maxDuePage.getFirstName(maxDueRowIndex + 1);
        String lastName = maxDuePage.getLastName(maxDueRowIndex + 1);

        Assert.assertEquals(String.format("%s %s", lastName, firstName), "Doe Jason");

        Browser.quit();
    }

    @Test
    void verifyMaxDueb(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Person> person = new ArrayList<>();
        //read data from web
        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).forEach(
                row -> {
                    String[] rowContent = row.getText().split(" ");
                    person.add(new Person(rowContent[0],rowContent[1],rowContent[3]));
                }
        );
        String maxDuePerson = person.stream().max(Comparator.comparing(Person::getDue)).get().getFullName();
        Assert.assertEquals(maxDuePerson,"Doe Jason");
    }

    @Test
    void tc05c(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> person = new ArrayList<>();
        //read data from web
        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(
                        row -> {
                            String[] rowContent = row.getText().split(" ");
                            String[] rowContentDue = row.getText().split(" ");
                            person.add(new Person(rowContent[0],rowContent[1],rowContentDue[1]));
                        }
                );

        Double maxDueValue = person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get()
                .getDue();

        List<String> maxDuePersonList = person.stream()
                .filter(p -> Objects.equals(p.getDue(), maxDueValue))
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(maxDuePersonList,List.of("Doe Jason"));
    }

    @Test
    void verifyMinimumDueValuePerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> person = new ArrayList<>();
        //read data from web
        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(
                        row -> {
                            String[] rowContent = row.getText().split(" ");
                            String[] rowContentDue = row.getText().split(" ");
                            person.add(new Person(rowContent[0],rowContent[1],rowContentDue[3]));
                        }
                );

        Double minDueValue = person
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get()
                .getDue();

        List<String> maxDuePersonList = person.stream()
                .filter(p -> Objects.equals(p.getDue(), minDueValue))
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(maxDuePersonList,List.of("Smith John","Conway Tim"));
    }
    }
