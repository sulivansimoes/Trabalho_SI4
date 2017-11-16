package br.edu.univas.si.model.util;

/**
 * Summary: Faz criptografia simples de uma string.
 * @author Súlivan
 */
public class Encryption {

	public static String encrypt(String texto ){
		
		int count = 0;
		String encriptado = "";
		
		for(int i =0; i< texto.length() ;i++){
				encriptado += encryption(texto.charAt(i), count-=4+i);
		}
		return encriptado;
	}
	
	private static char encryption(char caracter, int num){
		return caracter -= num;
	}
}
