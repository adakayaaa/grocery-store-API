package stepdefinition.order;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import pojo.request.AddAnItemToCartReq;
import pojo.response.getASingleOrder.GetASingleOrder;
import stepdefinition.BaseSteps;
import utils.APIUtils;

import java.util.Map;

public class GetASingleOrderStepDefs extends BaseSteps {

    Logger logger = LogManager.getLogger(GetASingleOrderStepDefs.class);

    @And("The user sends a GET request to get a single order endpoint with specific orderId")
    public void theUserSendsAGETRequestToGetASingleOrderEndpointWithSpecificOrderId() {
        String endpoint = createANewOrderEndpoint + "/" + orderId;
        response = APIUtils.sendGetRequestWithAccessToken(request, endpoint, accessToken);

        logger.info("The user sends a GET request to get a single order endpoint with specific orderId");
    }


    @And("The response should contains that correct orderId and items following:")
    public void theResponseShouldContainsThatCorrectOrderIdAndItemsFollowing(DataTable dataTable) {

        Map<String, Integer> mapRequest = dataTable.asMap(String.class, Integer.class);
        AddAnItemToCartReq addAnItemToCartReq = new AddAnItemToCartReq(mapRequest.get("productId"), mapRequest.get("quantity"));

        GetASingleOrder getASingleOrder = response.as(GetASingleOrder.class);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(getASingleOrder.getId()).isEqualTo(orderId);
        softAssertions.assertThat(getASingleOrder.getItems().get(getASingleOrder.getItems().size() - 1).getProductId()).isEqualTo(addAnItemToCartReq.getProductId());
        softAssertions.assertThat(getASingleOrder.getItems().get(getASingleOrder.getItems().size() - 1).getQuantity()).isEqualTo(addAnItemToCartReq.getQuantity());

        softAssertions.assertAll();

        logger.debug("The response should contains that correct orderId and items following: orderid -> " + orderId +
                "product id -> " + mapRequest.get("productId") +
                "quantity -> " + mapRequest.get("quantity"));
    }
}
