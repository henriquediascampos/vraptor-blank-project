package br.com.caelum.vraptor.modelos.pessoa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.caelum.vraptor.modelos.modeloGenerico.ModeloGenerico;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa")
public class Pessoa extends ModeloGenerico{
	@Id
	@SequenceGenerator(name = "mysequence", sequenceName = "seq_pess_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mysequence")
	@Column(name="pess_id")
	private Long id;

	@Column
	private String nome;
	
	@Column
	private String sobrenome;

	@Column(name= "dt_nacimento")
	private Date dtNacimento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNacimento() {
		return dtNacimento;
	}

	public void setDtNacimento(Date dtNacimento) {
		this.dtNacimento = dtNacimento;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}	
}