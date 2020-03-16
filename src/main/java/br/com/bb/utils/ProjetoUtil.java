package br.com.bb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bb.exceptions.FormatoDataInvalidoException;

public abstract class ProjetoUtil {

	public static Date convertStringToDate(String dataStr, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		sdf.setLenient(false);
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(dataStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FormatoDataInvalidoException(String.format("A data %s é inválida ou está no formato inválido!"
					+ " Formato correto: %s",  dataStr, formato));
		}
		return dataFormatada;
	}
	
}
