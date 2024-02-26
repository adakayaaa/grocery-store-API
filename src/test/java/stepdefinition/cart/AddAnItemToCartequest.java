package stepdefinition.cart;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.request.AddAnItemToCartReq;
import stepdefinition.BaseSteps;
import utils.APIUtils;


public class AddAnItemToCartequest extends BaseSteps {
    Logger logger = LogManager.getLogger(AddAnItemToCartequest.class);
    public  AddAnItemToCartReq addAnItemToCart;
    @When("The user sends a POST request to add an item to cartequest endpoint with productId as {int} and quantity as {int} and specific cart id")
    public void theUserSendsAPOSTRequestToAddAnItemToCartequestEndpointWithProductIdAsAndQuantityAsAndSpecificCartId(int productId, int quantity) {
        addAnItemToCart=new AddAnItemToCartReq();
        addAnItemToCart.setProductId(productId);
        addAnItemToCart.setQuantity(quantity);

        response= APIUtils.sendPostRequest(request,addAnItemToCartEndpoint,addAnItemToCart,cartId);
        itemId=response.jsonPath().getString("itemId");

        logger.info("The user sends a POST request to add an item to cartequest endpoint with productId as"+ productId +"and quantity as "+ quantity +"and specific cart id");
    }

}
