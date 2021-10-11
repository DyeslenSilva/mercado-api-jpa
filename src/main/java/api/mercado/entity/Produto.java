package api.mercado.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@Column
	private String nomeDoProduto;
	
	@Column
	private String marcaDoProduto;
	
	@Column
	private double preco;
	
}
