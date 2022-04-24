package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Estudante")
public class Estudante extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519710901493485449L;
	@Column(name="data_ingresso")
	private Date dataIgresso;
	
	private Long codEstudante;
	private String nome;
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="curso_id_fk")
	private Curso curso ;
	
	@OneToMany
	private List<Pagamento> pagamentos;
	public Renovacao getRenovacao() {
		return renovacao;
	}

	public void setRenovacao(Renovacao renovacao) {
		this.renovacao = renovacao;
	}

	@OneToOne
	@JoinTable(name="inscricao")
	private Disciplina disciplina;
	
	@OneToOne
	@JoinTable(name="renovacao_estudante")
	private Renovacao renovacao;




	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDataIgresso() {
		return dataIgresso;
	}

	public void setDataIgresso(Date dataIgresso) {
		this.dataIgresso = dataIgresso;
	}

	public Long getCodEstudante() {
		return codEstudante;
	}

	public void setCodEstudante(Long codEstudante) {
		this.codEstudante = codEstudante;
	}



	public Estudante() {
		super();
	}

	public Estudante(Long id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade, Date data_ingresso, Long cod_estudante, Curso curso) {
		this.dataIgresso = data_ingresso;
		this.codEstudante = cod_estudante;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCod_estudante() {
		return codEstudante;
	}

	public void setCod_estudante(Long cod_estudante) {
		this.codEstudante = cod_estudante;
	}

	public Date getData_ingresso() {
		return dataIgresso;
	}


	public void setData_ingresso(Date data_ingresso) {
		this.dataIgresso = data_ingresso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Estudante [dataIgresso=" + dataIgresso + ", codEstudante=" + codEstudante + ", nome=" + nome
				+ ", curso=" + curso + ", disciplina=" + disciplina + ", renovacao=" + renovacao + "]";
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	
}
