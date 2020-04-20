import com.sparta.sf.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepdefs {

    WebDriver webDriver = new ChromeDriver();
    HomePage homePage = new HomePage(webDriver);
    boolean check;

    @Given("I am on the form page")
    public void iAmOnTheFormPage() {
    }

    @When("I type into the first name box")
    public void iTypeIntoTheFirstNameBox() {
        check = homePage.checkFirstNameBox(webDriver, "Sebastian");
    }

    @Then("First name box will be filled")
    public void firstNameBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }

    @When("I type into the last name box")
    public void iTypeIntoTheLastNameBox() {
        check = homePage.checkLastNameBox(webDriver, "F");
    }

    @Then("Last name box will be filled")
    public void lastNameBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }

    @When("I type into the age box")
    public void iTypeIntoTheAgeBox() {
        check = homePage.checkAgeBox(webDriver, "23");
    }

    @Then("Age box will be filled")
    public void ageBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }

    @When("I type into the degree box")
    public void iTypeIntoTheDegreeBox() {
        check = homePage.checkDegreeBox(webDriver, "BSc Computer Science");
    }

    @Then("Degree box will be filled")
    public void degreeBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }

    @When("I type into the address box")
    public void iTypeIntoTheAddressBox() {
        check = homePage.checkAddressBox(webDriver, "123 Road");
    }

    @Then("Address box will be filled")
    public void addressBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }

    @When("I type into the email address box")
    public void iTypeIntoTheEmailAddressBox() {
        check = homePage.checkEmailBox(webDriver, "haha@yes.co.uk");
    }

    @Then("Email address box will be filled")
    public void emailAddressBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }

    @When("I type into the phone number box")
    public void iTypeIntoThePhoneNumberBox() {
        check = homePage.checkPhoneNumberBox(webDriver, "01231321232");
    }

    @Then("Phone number box will be filled")
    public void phoneNumberBoxWillBeFilled() {
        Assertions.assertEquals(true, check);
        webDriver.close();
    }
}
