package com.cedaniel200.eribank.screenplay.cloud;

import com.cedaniel200.eribank.screenplay.questions.TheHomePage;
import com.cedaniel200.eribank.screenplay.tasks.Authenticate;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.cedaniel200.eribank.screenplay.model.builder.UserBuilder.user;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(SerenityRunner.class)
public class AuthenticationCloud {

    @Managed
    private WebDriver driver;
    private Actor cesar = Actor.named("Cesar");

    @Before
    public void prepareStage() {
        //driver = AppiumDriverProviderCloud.getDriver();
        cesar.can(BrowseTheWeb.with(driver));
    }

    @Test
    public void iLogin() throws Throwable {
        cesar.attemptsTo(Authenticate.the(user("company").withPassword("company")));

        cesar.should(seeThat(TheHomePage.isVisible()));
    }
}