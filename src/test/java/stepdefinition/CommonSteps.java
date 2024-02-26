package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.Register;
import utils.APIUtils;

public class CommonSteps extends BaseSteps {
    Logger logger = LogManager.getLogger(CommonSteps.class);
    @Given("The user is on the correct Base URI")
    public void theUserIsOnTheCorrectBaseURI() {
        request=new RequestSpecBuilder().setBaseUri(baseURI).build();
        logger.info("The user is on the correct Base URI");
    }
    @Then("The response status code should be status code as {int}")
    public void theResponseStatusCodeShouldBeStatusCodeAs(int statusCode) {
        int actualStatusCode=response.getStatusCode();
        Assertions.assertThat(actualStatusCode).isEqualTo(statusCode);

        logger.debug("The response status code should be status code as " +statusCode);
    }

    @When("I send a POST request client name as {string} and client email as {string} to the registration endpoint")
    public void iSendAPOSTRequestClientNameAsAndClientEmailAsToTheRegistrationEndpoint(String clientName, String clientEmail) {
        Register register=new Register();
        register.setClientName(clientName);
        register.setClientEmail(clientEmail);

        response= APIUtils.sendPostRequest(request,registerUserEndpoint,register);
        accessToken= response.jsonPath().getString("accessToken");

        logger.info("I send a POST request client name as" +clientName+ " and client email as "+ clientEmail+ " to the registration endpoint");
    }

}
