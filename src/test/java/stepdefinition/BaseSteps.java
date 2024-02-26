package stepdefinition;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;



public class BaseSteps {

	static protected Response response;
	static protected RequestSpecification request;
	protected String baseURI;

	protected String registerUserEndpoint;

	protected String getAllProductsEndpoint;
	protected String getAProductEndpoint;
	protected String createANewCartEndpoint;
	protected String addAnItemToCartEndpoint;

	protected String createANewOrderEndpoint;

	protected static String accessToken;
	protected static String cartId;
	protected static String itemId;
	protected static String orderId;


	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
		registerUserEndpoint = ConfigManager.getProperty("api.register.endpoint");
		getAllProductsEndpoint=ConfigManager.getProperty("get.all.products.endpoint");
		getAProductEndpoint=ConfigManager.getProperty("get.a.product.endpoint");
		createANewCartEndpoint =ConfigManager.getProperty("create.a.new.cart.endpoint");
		addAnItemToCartEndpoint=ConfigManager.getProperty("add.an.item.to.cart.endpoint");
		createANewOrderEndpoint=ConfigManager.getProperty("create.a.new.order.endpoint");
	}

}
