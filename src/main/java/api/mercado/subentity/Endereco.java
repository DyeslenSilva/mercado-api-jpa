package api.mercado.subentity;

import lombok.Data;

@Data
public class Endereco {

	private String logradouro;
	private int n;
	private String cidade;
	private String estado;
}
