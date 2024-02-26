package stepdefinition.cart;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.request.AddAnItemToCartReq;
import stepdefinition.BaseSteps;
import utils.APIUtils;


public class ReplaceAnItemStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(ReplaceAnItemStepDefs.class);
    AddAnItemToCartReq addAnItemToCartReq=new AddAnItemToCartReq();
    @And("The user sends a PUT request to get a cart endpoint with specific cart id with productId as {int} and quantity as {int}")
    public void theUserSendsAPUTRequestToGetACartEndpointWithSpecificCartIdWithProductIdAsAndQuantityAs(int productId, int quantity) {
        addAnItemToCartReq.setProductId(productId);
        addAnItemToCartReq.setQuantity(quantity);

        String endpoint=createANewCartEndpoint + "/" + cartId + "/items/"+ itemId;
        response= APIUtils.sendPutRequest(request,endpoint,addAnItemToCartReq);

        logger.info("The user sends a PUT request to get a cart endpoint with specific cart id with productId as "+productId +" and quantity as " +quantity);
    }
}
