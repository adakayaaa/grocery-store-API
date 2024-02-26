package stepdefinition.cart;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinition.BaseSteps;
import utils.APIUtils;

public class CreateANewCartStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(CreateANewCartStepDefs.class);
    @When("The user sends a POST request to create a new cart endpoint")
    public void theUserSendsAPOSTRequestToCreateANewCartEndpoint() {
        response= APIUtils.sendPostRequest(request, createANewCartEndpoint);
        cartId=response.jsonPath().getString("cartId");
        logger.info("The user sends a POST request to create a new cart endpoint");
    }


}
