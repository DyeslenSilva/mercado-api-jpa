package api.mercado.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import api.mercado.subentity.Endereco;
import lombok.Data;

@Data
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;
	
	@Column
	private String nomeDoFuncionario;

	@Column
	private Endereco endereco;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
}
