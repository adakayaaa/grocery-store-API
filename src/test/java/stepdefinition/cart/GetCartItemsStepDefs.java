package stepdefinition.cart;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.common.mapper.TypeRef;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import pojo.response.getACart.InItemGetACartRes;
import stepdefinition.BaseSteps;
import utils.APIUtils;

import java.util.List;
import java.util.Map;


public class GetCartItemsStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(GetCartItemsStepDefs.class);

    @And("The user sends a GET request to get cart items endpoint with specific cart id")
    public void theUserSendsAGETRequestToGetCartItemsEndpointWithSpecificCartId() {
        response = APIUtils.sendGetRequestForGetCartItems(request, createANewCartEndpoint, cartId);
        logger.info("The user sends a GET request to get cart items endpoint with specific cart id");
    }

    @And("The response information should match with added information of items to cartequest to following:")
    public void theResponseInformationShouldMatchWithAddedInformationOfItemsToCartequestToFollowing(DataTable dataTable) {
        List<InItemGetACartRes> cartItem = response.as(new TypeRef<>() {
        });
        List<Map<String, Integer>> listOfRequest = dataTable.asMaps(String.class, Integer.class);
        for (Map<String, Integer> request : listOfRequest) {
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(cartItem.get(listOfRequest.indexOf(request)).getProductId()).isEqualTo(request.get("productId"));
            softAssertions.assertThat(cartItem.get(listOfRequest.indexOf(request)).getQuantity()).isEqualTo(request.get("quantity"));
            softAssertions.assertAll();
        }
        logger.debug("The response information should match with added information of items to cartequest to following: product id->"
                + request.get("productId")
                + "quantity->" + request.get("quantity"));
    }
}


