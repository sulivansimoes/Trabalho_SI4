package br.edu.univas.si.model.util;

public class teste {

	public static void main(String[] args) {

		String texto = "faculdade";
		String enc ="";
		String des ="";
		
		System.out.println("Normal: "+texto);
		
		enc = Encryption.encrypt(texto);
		System.out.println("Encriptado: "+enc);
		des = Encryption.decryption(enc);
		System.out.println("Desencriptado: "+des);

	}

}
