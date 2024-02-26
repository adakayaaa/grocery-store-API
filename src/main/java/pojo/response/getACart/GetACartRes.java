package pojo.response.getACart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetACartRes {
	private String created;
	private List<InItemGetACartRes> items;


}