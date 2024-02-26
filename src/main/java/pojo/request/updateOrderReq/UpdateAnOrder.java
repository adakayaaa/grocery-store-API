package pojo.request.updateOrderReq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAnOrder {
	private String comment;
	private String customerName;
}
