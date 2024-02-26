package stepdefinition.order;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import pojo.request.updateOrderReq.UpdateAnOrder;
import pojo.response.getASingleOrder.GetASingleOrder;
import stepdefinition.BaseSteps;
import utils.APIUtils;

public class UpdateAnOrderStepDefs extends BaseSteps {

    Logger logger = LogManager.getLogger(UpdateAnOrderStepDefs.class);
    @And("The user sends a PATCH request to update an order endpoint to customer name as {string} with specific orderId")
    public void theUserSendsAPATCHRequestToUpdateAnOrderEndpointToCustomerNameAsWithSpecificOrderId(String customerName) {
        String endpoint= createANewOrderEndpoint+"/"+orderId;

        UpdateAnOrder body=new UpdateAnOrder();
        body.setCustomerName(customerName);

        response= APIUtils.sendPatchRequestWithAccessToken(request,endpoint,body,accessToken);

        logger.info("The user sends a PATCH request to update an order endpoint to customer name as "+ customerName +"with specific orderId");
    }


    @And("The user should see customer name as expected as {string}")
    public void theUserShouldSeeCustomerNameAsExpectedAs(String customerName) {
        GetASingleOrder getASingleOrder = response.as(GetASingleOrder.class);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(getASingleOrder.getCustomerName()).isEqualTo(customerName);

        logger.debug("The user should see customer name as expected as " +customerName);
    }
}
