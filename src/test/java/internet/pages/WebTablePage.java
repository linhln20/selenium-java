package internet.pages;

import internet.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static supports.Browser.visit;

public class WebTablePage {
    public void open() {
        visit("https://the-internet.herokuapp.com/tables");
    }

    // XPath for locating the table rows
    private By rows = By.xpath("//table[@id='table1']/tbody/tr");
    private By dueColumn = By.xpath("//table[@id='table1']/tbody/tr/td[4]");


    // Method to get all due values
    public List<Double> getDueValues() {
        return Browser.getDriver().findElements(dueColumn)
                .stream()
                .map(cell -> Double.parseDouble(cell.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    // Method to get the first name from a row
    public String getFirstName(int rowIndex) {
        return Browser.getText(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", rowIndex)));
    }

    // Method to get the last name from a row
    public String getLastName(int rowIndex) {
        return Browser.getText(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", rowIndex)));
    }

    // Method to get the row with the max due value
    public int getMaxDueRowIndex() {
        List<Double> dueValues = getDueValues();
        Double maxDueValue = dueValues.stream().max(Double::compare).orElseThrow();
        return dueValues.indexOf(maxDueValue);
    }

    private By tableRows = By.xpath("//table[@id='table1']/tbody/tr");


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

    public String getMaxDuePerson() {
        return getTableData().stream()
                .max(Comparator.comparing(Person::getDue))
                .map(Person::getFullName)
                .orElseThrow();
    }
    public List<String> getMinDuePerson(){
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
