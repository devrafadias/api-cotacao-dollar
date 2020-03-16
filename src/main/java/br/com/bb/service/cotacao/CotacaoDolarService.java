package br.com.bb.service.cotacao;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bb.domain.CotacaoDolar;
import br.com.bb.gateway.json.RespostaTipoCotacaoDolar;
import br.com.bb.gateway.repository.CotacaoDolarRepository;

@Service
public class CotacaoDolarService{

	@Autowired(required=true)
	private CotacaoDolarRepository cotacaoDolarRepository;
	
//	@Value("${bank.link}")
	private String link;
	
	public CotacaoDolar salvar(CotacaoDolar cotacaoDolar) {
		return this.cotacaoDolarRepository.save(cotacaoDolar);
	}

	public RespostaTipoCotacaoDolar consultarCotacoesDolar(String dataCotacao) throws Exception {
		
		if(link == null) {
			String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)";
			link = url + "?%40dataCotacao=%27$dataCotacao$%27&%24format=json";
		}

		link = link.replace("$dataCotacao$", dataCotacao);
		
		System.out.println(link);
		
		RestTemplate restTemplate = new RestTemplate();

		try {
			return restTemplate.getForObject(new URI(link), RespostaTipoCotacaoDolar.class);
		} catch(HttpClientErrorException ex) {
			throw ex;
		}catch (RuntimeException ex) {
			throw ex;
		} catch (URISyntaxException ex) {
			throw ex;
		}

	}

}
