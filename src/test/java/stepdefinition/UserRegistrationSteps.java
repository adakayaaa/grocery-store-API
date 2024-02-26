package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.Register;
import utils.APIUtils;


public class UserRegistrationSteps extends BaseSteps {


	private static final Logger logger = LogManager.getLogger(UserRegistrationSteps.class);

	@And("I receive a token in the response")
	public void iReceiveATokenInTheResponse() {
		Assertions.assertThat(accessToken).isNotEmpty();

		logger.info("The user receives a token in the response");
	}


	@When("I send a POST request client name as {string} and client email as {int} to the registration endpoint")
	public void iSendAPOSTRequestClientNameAsAndClientEmailAsToTheRegistrationEndpoint(String clientName, int clientEmail) {
		Register register=new Register();
		register.setClientName(clientName);
		register.setClientEmailInt(clientEmail);

		response= APIUtils.sendPostRequest(request,registerUserEndpoint,register);
		logger.info("The user sends a POST request client name as " + clientName +" and client email as " + clientEmail +" to the registration endpoint");
	}
}
