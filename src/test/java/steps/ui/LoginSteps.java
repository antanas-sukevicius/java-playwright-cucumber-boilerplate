package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PageObject;

public class LoginSteps extends PageObject {

    @Given("Login")
    public void login(){
        LoginPage.loginManually();
    }

}
