# Selenium Java Basic

## Setup
- Java jdk 23
- Maven
- Install Chrome/Firefox/Edge/Brave

## How to run
```shell
mvn clean test
```

## How to create test plan
[Sample Test Plan](sample-testplan2.xml)


## How to write a new test case with page object model

- Define Test Class [WebTableTest](./src/test/java/internet/DueTableTest.java)
  - Test Class naming with suffix Test
- Define Page class [WebTablePage](./src/test/java/internet/pages/WebTablePage.java)
  - Page Class naming with suffix Page.

## Special test cases
- [Horizontal slider](src/test/java/internet/HorizontalSliderTest.java)
  - It does not work on Git because the function moves the mouse target is disabled (the target only changes to "5" if the mouse is moved after slid)
- [Able Select Multiple Options](src/test/java/internet/DropDownTest.java)
  - Can not double-click to deselect, just press the key "Ctrl" and select at the same moment

## Supports
-  Selenium Owner methods