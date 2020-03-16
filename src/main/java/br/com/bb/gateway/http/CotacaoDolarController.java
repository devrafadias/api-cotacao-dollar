package br.com.bb.gateway.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.bb.domain.CotacaoDolar;
import br.com.bb.exceptions.DataInvalidaException;
import br.com.bb.gateway.json.RespostaCotacaoDolar;
import br.com.bb.gateway.json.RespostaTipoCotacaoDolar;
import br.com.bb.gateway.json.TipoCotacaoDolar;
import br.com.bb.service.cotacao.CotacaoDolarService;
import br.com.bb.utils.ProjetoUtil;

@RestController
public class CotacaoDolarController {

	@Autowired(required=false)
	private CotacaoDolarService cotacaoDolarService;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(path = "/cotacoes/{dataCotacao}", method = RequestMethod.GET)
	public ResponseEntity<RespostaCotacaoDolar> consultarCotacoesDolar(@PathVariable("dataCotacao") String dataCotacaoStr) {
		RespostaCotacaoDolar retorno = new RespostaCotacaoDolar();
		List<CotacaoDolar> cotacoes = new ArrayList<CotacaoDolar>(0);
		try {
			if(dataCotacaoStr == null || dataCotacaoStr.isEmpty()) {
				throw new DataInvalidaException("A data da cotação deve ser informada!");
			}	
			Date dataCotacao = ProjetoUtil.convertStringToDate(dataCotacaoStr, "MM-dd-yyyy");
			RespostaTipoCotacaoDolar resposta = cotacaoDolarService.consultarCotacoesDolar(dataCotacaoStr);
			List<TipoCotacaoDolar> values = resposta.getValue();
			CotacaoDolar cotacaoDolar = null;
			for(TipoCotacaoDolar tipoCotacaoDolar : values) {
				cotacaoDolar = cotacaoDolarService.salvar(tipoCotacaoDolar.toCotacaoDolar(dataCotacao));
				cotacoes.add(cotacaoDolar);
			}
			
			retorno.setSucesso(true);
			retorno.setCotacoes(cotacoes);
			retorno.setMensagem(String.format("Consulta das cotações do dólar para a data %s foi registrado com sucesso.", dataCotacao));
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setSucesso(false);
			retorno.setMensagem(e.getMessage());
		}
		
		return new ResponseEntity<RespostaCotacaoDolar>(retorno, HttpStatus.OK);
	}
	
}
