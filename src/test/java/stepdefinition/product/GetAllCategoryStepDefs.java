package stepdefinition.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepdefinition.BaseSteps;
import stepdefinition.order.UpdateAnOrderStepDefs;
import utils.APIUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllCategoryStepDefs extends BaseSteps {
    Logger logger = LogManager.getLogger(GetAllCategoryStepDefs.class);
    Map<String,String> queryParameters=new HashMap<>();
    List<String> categories;
    @When("The user sends a GET request to get all products endpoint with {string} as {string}")
    public void theUserSendsAGETRequestToGetAllProductsEndpointWithAs(String category, String selectCategoryName) {
        queryParameters.put(category,selectCategoryName);
        response= APIUtils.sendGetRequest(request,getAllProductsEndpoint,queryParameters);

        logger.info("The user sends a GET request to get all products endpoint with "+ category+" as " + selectCategoryName);
    }

    @And("The product's category should match with specified {string}")
    public void theProductSCategoryShouldMatchWithSpecified(String selectCategoryName) {
        categories=response.jsonPath().getList("category");
        categories.forEach(category->{
            Assertions.assertThat(selectCategoryName).isEqualTo(category);
        });
        logger.debug("The product's category should match with specified " +selectCategoryName);

    }
}
