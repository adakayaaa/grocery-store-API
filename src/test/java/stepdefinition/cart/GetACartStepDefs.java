package stepdefinition.cart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import pojo.request.AddAnItemToCartReq;
import pojo.response.getACart.GetACartRes;
import stepdefinition.BaseSteps;
import utils.APIUtils;

import java.util.Map;

public class GetACartStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(GetACartRes.class);
    Map<String ,Integer> mapRequest;
    AddAnItemToCartReq addAnItemToCartReq;
    @When("The user sends a GET request to get a cart endpoint with specific cart id")
    public void theUserSendsAGETRequestToGetACartEndpointWithSpecificCartId() {
        response= APIUtils.sendGetRequest(request,createANewCartEndpoint,cartId);

        logger.info("The user sends a GET request to get a cart endpoint with specific cart id");
    }

    @And("The response should contains that items that added in cart")
    public void theResponseShouldContainsThatItemsThatAddedInCart() {
        SoftAssertions softAssertions=new SoftAssertions();
        GetACartRes getACartRes=response.as(GetACartRes.class);

        softAssertions.assertThat(getACartRes.getItems().get(0)).isEqualTo(addAnItemToCartReq.getProductId());

        logger.debug("The response should contains that items that added in cart");
        softAssertions.assertAll();

    }



    @And("The response should contains that items that added in cart following:")
    public void theResponseShouldContainsThatItemsThatAddedInCartFollowing(DataTable dataTable) {
        SoftAssertions softAssertions=new SoftAssertions();
        mapRequest=dataTable.asMap(String.class, Integer.class);
        addAnItemToCartReq = new AddAnItemToCartReq(mapRequest.get("productId"), mapRequest.get("quantity"));

        GetACartRes getACartRes=response.as(GetACartRes.class);


        softAssertions.assertThat(getACartRes.getItems().get(getACartRes.getItems().size()-1).getProductId()).isEqualTo(addAnItemToCartReq.getProductId());
        softAssertions.assertThat(getACartRes.getItems().get(getACartRes.getItems().size()-1).getQuantity()).isEqualTo(addAnItemToCartReq.getQuantity());

        logger.debug("The response should contains that items that added in cart following: product id ->"
                + mapRequest.get("productId") + " quantity->" +mapRequest.get("quantity"));
        softAssertions.assertAll();
    }
}
