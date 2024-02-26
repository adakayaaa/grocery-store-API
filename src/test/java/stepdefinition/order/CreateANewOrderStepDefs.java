package stepdefinition.order;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.createANewOrderReq.CreateANewOrderRequest;
import pojo.response.createANewOrder.CreateANewOrderRes;
import stepdefinition.BaseSteps;
import utils.APIUtils;

public class CreateANewOrderStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(CreateANewOrderStepDefs.class);
    @And("The user sends a POST request to create a new order endpoint with specific cart id and customer name as {string}")
    public void theUserSendsAPOSTRequestToCreateANewOrderEndpointWithSpecificCartIdAndCustomerNameAs(String customerName) {
        CreateANewOrderRequest body= new CreateANewOrderRequest(cartId,"",customerName);

        response= APIUtils.sendPostRequestWithAccessToken(request,createANewOrderEndpoint,body,accessToken);
        orderId=response.jsonPath().getString("orderId");

        logger.info("The user sends a POST request to create a new order endpoint with specific cart id and customer name as " +customerName);
    }

    @And("The response should has a order id")
    public void theResponseShouldHasAOrderId() {
        CreateANewOrderRes createANewOrderRes=response.as(CreateANewOrderRes.class);
        Assertions.assertThat(createANewOrderRes.getOrderId()).isNotEmpty();

        logger.debug("The response should has a order id");
    }
}
