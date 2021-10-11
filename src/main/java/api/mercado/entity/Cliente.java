package api.mercado.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import api.mercado.subentity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column
	private String nomeDoCliente;
	
	@Column
	private Endereco endereco;
	
	@Column
	private String telCel;
	
}