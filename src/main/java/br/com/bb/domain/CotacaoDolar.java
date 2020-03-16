package br.com.bb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tb_cotacao_dolar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CotacaoDolar {

	@Id
	@GeneratedValue
	private Long id;
	private Date dataRequisicao;
	private Date dataCotacaoDolar;
	private Double cotacaoCompra;
	private Double cotacaoVenda;
	private Date dataHoraCotacao;
}
