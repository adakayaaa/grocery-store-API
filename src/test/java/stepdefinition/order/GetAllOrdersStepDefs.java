package stepdefinition.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepdefinition.BaseSteps;
import utils.APIUtils;

import java.util.List;

public class GetAllOrdersStepDefs extends BaseSteps {

    Logger logger = LogManager.getLogger(GetAllOrdersStepDefs.class);
    @When("The user sends a GET request to get all orders endpoint")
    public void theUserSendsAGETRequestToGetAllOrdersEndpoint() {
        response = APIUtils.sendGetRequestWithAccessToken(request, createANewOrderEndpoint, accessToken);

        logger.info("The user sends a GET request to get all orders endpoint");
    }


    @And("The customer name of response body should match customer name of request as {string}")
    public void theCustomerNameOfResponseBodyShouldMatchCustomerNameOfRequestAs(String customerName) {
        List<String> actualCustomerNames = response.jsonPath().getList("customerName");
        actualCustomerNames.forEach(name ->
                Assertions.assertThat(customerName).isEqualTo(name));

        logger.debug("The customer name of response body should match customer name of request as "+ customerName);
    }
}
