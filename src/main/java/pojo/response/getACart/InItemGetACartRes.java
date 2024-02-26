package pojo.response.getACart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InItemGetACartRes {
	private int id;
	private int productId;
	private int quantity;


}
