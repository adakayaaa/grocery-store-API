package stepdefinition.cart;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinition.BaseSteps;
import utils.APIUtils;

public class DeleteAnItemStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(DeleteAnItemStepDefs.class);
    @And("The user sends a DELETE request to get a cart endpoint with specific cart id with specific item id")
    public void theUserSendsADELETERequestToGetACartEndpointWithSpecificCartIdWithSpecificItemId() {
        String endpoint=createANewCartEndpoint + "/" + cartId + "/items/"+ itemId;
        response= APIUtils.sendDeleteRequest(request,endpoint);
        logger.info("The user sends a DELETE request to get a cart endpoint with specific cart id with specific item id");
    }
}
