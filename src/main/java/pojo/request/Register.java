package pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {

	private String clientName;

	private String clientEmail;

	private Integer clientEmailInt;

}
