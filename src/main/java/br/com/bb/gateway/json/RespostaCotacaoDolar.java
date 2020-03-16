package br.com.bb.gateway.json;

import java.util.List;

import br.com.bb.domain.CotacaoDolar;

public class RespostaCotacaoDolar {
	
	private boolean sucesso;
	
	private String mensagem;
	
	private List<CotacaoDolar> cotacoes;

	public RespostaCotacaoDolar() {
	}
	
	public RespostaCotacaoDolar(String message) {
		mensagem = message;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<CotacaoDolar> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<CotacaoDolar> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

}
