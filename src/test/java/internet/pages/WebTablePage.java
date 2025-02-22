package internet.pages;

import internet.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static supports.Browser.visit;

public class WebTablePage {
    private By tableRows = By.xpath("//table[@id='table1']/tbody/tr");

    public void open(){
        visit(" https://the-internet.herokuapp.com/tables");
    }

    public List<Person> getTableData() {
        List<Person> people = new ArrayList<>();
        List<WebElement> rows = Browser.getDriver().findElements(tableRows);
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String due = cells.get(3).getText().replace("$", "");
            people.add(new Person(firstName, lastName, due));
        }
        return people;
    }

    public List<String> getMaxDuePerson() {
        Double maxDueValue = getTableData().stream()
                .max(Comparator.comparing(Person::getDue))
                .get()
                .getDue();
        return getTableData().stream()
                .filter(p -> p.getDue().equals(maxDueValue))
                .map(Person::getFullName)
                .toList();
    }

    public List<String> getMinDuePerson() {
        Double minDueValue = getTableData()
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get()
                .getDue();

        return getTableData().stream()
                .filter(p -> Objects.equals(p.getDue(), minDueValue))
                .map(Person::getFullName)
                .toList();
    }
}
