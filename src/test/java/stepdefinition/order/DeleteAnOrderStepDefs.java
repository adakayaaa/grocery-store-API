package stepdefinition.order;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinition.BaseSteps;
import utils.APIUtils;

public class DeleteAnOrderStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(DeleteAnOrderStepDefs.class);
    @And("The user sends a DELETE request to delete an order endpoint with specific orderId")
    public void theUserSendsADELETERequestToDeleteAnOrderEndpointWithSpecificOrderId() {
        String endpoint= createANewOrderEndpoint+"/"+orderId;
        response= APIUtils.sendDeleteRequestWithAccessToken(request,endpoint,accessToken);

        logger.info("The user sends a DELETE request to delete an order endpoint with specific orderId");
    }
}
