package br.com.bb.gateway.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.bb.domain.CotacaoDolar;
import br.com.bb.gateway.json.RespostaCotacaoDolar;

public class CotacaoDolarControllerTest {

	private final static String URL_API_REST = "http://localhost:8080/cotacoes/%s";

	private final static String DATA_VALIDA = "02-28-2020";

	private final static String DATA_INVALIDA = "02-30-2020";

	private final static String DATA_FORMATO_INVALID0 = "2020-02-28";

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testeRestApiDataValida() {
		try {
			RespostaCotacaoDolar resposta = consultarCotacoesDolar(DATA_VALIDA);
			System.out.println(resposta.getMensagem());
			for(CotacaoDolar cotacao : resposta.getCotacoes()) {
				System.out.println(cotacao);
			}
			
			assertNotNull(resposta);
			assertNotNull(resposta.getMensagem());
			assertNotNull(resposta.getCotacoes());
			assertEquals(true, resposta.getCotacoes().size() > 0);
			assertEquals(true, resposta.isSucesso());
			
		} catch (RestClientException e) {
			e.printStackTrace();
			fail("Falha no teste");
		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}

	@Test
	public void testeRestApiDataInvalida() {
		RespostaCotacaoDolar resposta = null;
		try {
			resposta = consultarCotacoesDolar(DATA_INVALIDA);
			System.out.println(resposta.getMensagem());
			assertEquals(false, resposta.isSucesso());
			assertNull(resposta.getCotacoes());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		} 
	}

	@Test
	public void testeRestApiDataFormatoInvalido() {
		RespostaCotacaoDolar resposta = null;
		try {
			resposta = consultarCotacoesDolar(DATA_FORMATO_INVALID0);
			System.out.println(resposta.getMensagem());
			assertEquals(false, resposta.isSucesso());
			assertNull(resposta.getCotacoes());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		} 
	}

	private RespostaCotacaoDolar consultarCotacoesDolar(String dataCotacao) throws URISyntaxException {
		String uri = String.format(URL_API_REST, dataCotacao);
		return restTemplate.getForObject(new URI(uri), RespostaCotacaoDolar.class);
	}

}
