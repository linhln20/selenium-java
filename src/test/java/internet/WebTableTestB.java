package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class WebTableTestB {
    //Đây là phiên bản rút gọn của WebTableTest

        List<Person> person;
        @BeforeClass
        void readData(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/tables");

            person = new ArrayList<>();
            //read data from web
            driver
                    .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                    .forEach(
                            row -> {
                                String[] rowContent = row.getText().split(" ");
                                person.add(new Person(rowContent[0],rowContent[1],rowContent[3]));
                            }
                    );
        }

        @Test
        void tc05(){
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
