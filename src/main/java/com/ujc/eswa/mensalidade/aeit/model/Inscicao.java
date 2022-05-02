package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;

import javax.persistence.*;

public class Inscicao {
	@Entity
	@Table(name="inscricao")
	public class Inscricao {
		@Column(name="cod_inscricao")
		@Id
		private Long codInscricao;
		@Column(name="data_inscricao")
		private Date inscData;
		@Column(name="nota1")
		private Long nota1;
		@Column(name="nota2")
		private Long nota2;
		public Long getCodInscricao() {
			return codInscricao;
		}
		public void setCodInscricao(Long codInscricao) {
			this.codInscricao = codInscricao;
		}
		public Date getInscData() {
			return inscData;
		}
		public void setInscData(Date inscData) {
			this.inscData = inscData;
		}
		public Long getNota1() {
			return nota1;
		}
		public void setNota1(Long nota1) {
			this.nota1 = nota1;
		}
		public Long getNota2() {
			return nota2;
		}
		public void setNota2(Long nota2) {
			this.nota2 = nota2;
		}
		public Long getFaltas() {
			return faltas;
		}
		public void setFaltas(Long faltas) {
			this.faltas = faltas;
		}
		public Long getMedia() {
			return media;
		}
		public void setMedia(Long media) {
			this.media = media;
		}
		@Column(name="faltas")
		private Long faltas;
		@Column(name="media")
		private Long media;
		
	}
}
