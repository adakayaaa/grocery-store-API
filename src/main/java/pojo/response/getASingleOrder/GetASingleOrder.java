package pojo.response.getASingleOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetASingleOrder {
	private boolean processed;
	private String createdBy;
	private String created;
	private String comment;
	private String id;
	private List<Items> items;
	private String customerName;
	private long timestamp;
}