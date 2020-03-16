package br.com.bb.gateway.json;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import br.com.bb.domain.CotacaoDolar;
import br.com.bb.utils.ProjetoUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCotacaoDolar implements Serializable {

	private static final long serialVersionUID = 6616230116009546880L;

	private Double cotacaoCompra;
	private Double cotacaoVenda;
	private String dataHoraCotacao;
	
	public CotacaoDolar toCotacaoDolar(Date dataCotacao) throws ParseException {
		CotacaoDolar cotacaoDolar = new CotacaoDolar();
		cotacaoDolar.setDataRequisicao(new Date());
		cotacaoDolar.setCotacaoCompra(this.getCotacaoCompra());
		cotacaoDolar.setCotacaoVenda(this.getCotacaoVenda());
		cotacaoDolar.setDataHoraCotacao(ProjetoUtil.convertStringToDate(this.getDataHoraCotacao(), "yyyy-MM-dd HH:mm:ss.SSS"));
		cotacaoDolar.setDataCotacaoDolar(dataCotacao);
		return cotacaoDolar;
	}

}
