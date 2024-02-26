package stepdefinition.product;

import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinition.BaseSteps;
import utils.APIUtils;


public class GetAProductStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(GetAProductStepDefs.class);
    @When("The user sends a GET request to get a product endpoint with productId as {int}")
    public void theUserSendsAGETRequestToGetAProductEndpointWithValidAs(int selectedProductId) {
        response= APIUtils.sendGetRequest(request,getAProductEndpoint,selectedProductId);

        logger.info("The user sends a GET request to get a product endpoint with productId as " +selectedProductId);
    }



}
