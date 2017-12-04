package br.edu.univas.si.view.util;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Summary: Coloca mascar·s comuns em JFormattedTextField.
 * @author S˙livan Simıes Silva
 */
public class MyMask {

	public static final void maskCpf(JFormattedTextField cpf){
	
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValidCharacters("1234567890");
			mascaraCpf.install(cpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskDate(JFormattedTextField date){
		
		try {
			MaskFormatter mascaraDate = new MaskFormatter("##/##/####");
			mascaraDate.setValidCharacters("1234567890");
			mascaraDate.setPlaceholderCharacter('_');
			mascaraDate.install(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskAno(JFormattedTextField ano){
		try {
			MaskFormatter mascaraAno = new MaskFormatter("####");
			mascaraAno.setValidCharacters("1234567890");
			mascaraAno.setPlaceholderCharacter('_');
			mascaraAno.install(ano);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskCodigoBarras(JFormattedTextField codigoBarras){
		
		try {
			MaskFormatter mascaraCodigoBarras = new MaskFormatter("####################");
			mascaraCodigoBarras.setValidCharacters("1234567890");
			mascaraCodigoBarras.install(codigoBarras);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskUnidadeMedida(JFormattedTextField unidadeMedida){
		
		try {
			MaskFormatter mascaraUnidadeMedida = new MaskFormatter("**");
			mascaraUnidadeMedida.setInvalidCharacters("@#$%®&!*.,/Á«?¡·È…ÕÌÛ”˙⁄„√ı’~");
			mascaraUnidadeMedida.install(unidadeMedida);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskDescricaoProduto(JFormattedTextField descricao){
	
		try {
			MaskFormatter mascaraDescricaoProduto = new MaskFormatter("************************************************************");
			mascaraDescricaoProduto.setInvalidCharacters("@#$%®&*.,/Á«?_+=");
			mascaraDescricaoProduto.install(descricao);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
