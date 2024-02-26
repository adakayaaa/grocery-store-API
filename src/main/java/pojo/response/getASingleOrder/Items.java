package pojo.response.getASingleOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
	private int quantity;
	private int productId;
	private int id;
}
