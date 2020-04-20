package com.sparta.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HomePage {
    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.get("http://localhost:9292/");
    }

    public boolean checkFirstNameBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.id("firstName")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(0).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public boolean checkLastNameBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.id("lastName")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(1).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public boolean checkAgeBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.xpath("/html/body/div/form/div[3]/div/input")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(2).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public boolean checkDateOfBirthBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.xpath("/html/body/div/form/div[4]/div/input")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(3).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateInput = LocalDate.parse(webDriver.findElement(By.xpath("/html/body/div/form/div[4]/div/input")).getText(), formatter);
        LocalDate dateNow = LocalDate.now();
        int numberOfDays = Math.toIntExact(Duration.between(dateInput.atStartOfDay(), dateNow.atStartOfDay()).toDays());
        if (numberOfDays > 0) {
            return true;
        }
        return false;
    }

    public boolean checkDegreeBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.xpath("/html/body/div/form/div[7]/div/input")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(7).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public boolean checkAddressBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.id("inputAddress")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(3).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public void selectCounty(WebDriver webDriver, String county) {
        Select dropdownCounty = new Select(webDriver.findElement(By.id("inputCounty")));
        dropdownCounty.selectByVisibleText(county);
    }


    public boolean checkEmailBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.id("inputemailaddress")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(5).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public boolean checkPhoneNumberBox(WebDriver webDriver, String text) {
        webDriver.findElement(By.id("exampleFormControlInput1")).sendKeys(text);
        webDriver.findElement(By.className("btn-primary")).click();
        String data = invalidFeedbackIterator(6).getText();
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    public void selectGender(WebDriver webDriver, boolean isMale) {
        if (isMale) {
            webDriver.findElement(By.id("customRadioInline1")).click();
        } else {
            webDriver.findElement(By.id("customRadioInline2")).click();
        }
    }

    public void selectStream(WebDriver webDriver, boolean isSdet) {
        if (isSdet) {
            webDriver.findElement(By.id("streamRadioInline1")).click();
        } else {
            webDriver.findElement(By.id("streamRadioInline2")).click();
        }
    }

    public void agreeToTermsAndConditions(WebDriver webDriver) {
        webDriver.findElement(By.id("terms")).click();
    }

    private WebElement invalidFeedbackIterator(int elementPosition) {
        List<WebElement> elements = webDriver.findElements(By.className("invalid-feedback"));
        return elements.get(elementPosition);
    }

}
