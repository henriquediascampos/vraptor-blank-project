package br.com.caelum.vraptor.modelos.testeCompilacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.caelum.vraptor.modelos.modeloGenerico.ModeloGenerico;

@Entity
public class TesteCompilacao extends ModeloGenerico {
	@Id
	@SequenceGenerator(name = "mysequence", sequenceName = "seq_cont_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mysequence")
	@Column(name="cont_id")
	private Long id;
	
	@Column
	String teste;

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
}
