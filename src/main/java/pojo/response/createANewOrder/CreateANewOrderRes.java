package pojo.response.createANewOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateANewOrderRes {
	private String orderId;
	private boolean created;
}
