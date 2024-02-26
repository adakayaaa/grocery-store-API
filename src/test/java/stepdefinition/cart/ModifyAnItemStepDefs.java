package stepdefinition.cart;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.request.ModifyCartItemsRes;
import stepdefinition.BaseSteps;
import utils.APIUtils;

public class ModifyAnItemStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(ModifyAnItemStepDefs.class);
    ModifyCartItemsRes modifyCartItemsRes =new ModifyCartItemsRes();
    @And("The user sends a PATCH request to get a cart endpoint with specific cart id with quantity as {int}")
    public void theUserSendsAPATCHRequestToGetACartEndpointWithSpecificCartIdWithQuantityAs(int quantity) {
        modifyCartItemsRes.setQuantity(quantity);
        String endpoint=createANewCartEndpoint + "/" + cartId + "/items/"+ itemId;
        response= APIUtils.sendPatchRequest(request,endpoint,modifyCartItemsRes);

        logger.info("The user sends a PATCH request to get a cart endpoint with specific cart id with quantity as " +quantity);
    }
}
