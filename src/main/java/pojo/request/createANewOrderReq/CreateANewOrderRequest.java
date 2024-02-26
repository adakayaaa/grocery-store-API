package pojo.request.createANewOrderReq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateANewOrderRequest {
	private String cartId;
	private String comment;
	private String customerName;
}
