/**
 * 
 */
package com.onfocus.jfood.util;

/**
 * @author Roner
 * 
 */
public class Utils {

	/**
	 * Método para validação de número de cpf
	 * 
	 * @param cpf
	 * @return verdadeiro para válido, falso para inválido
	 */
	public boolean validateCPF(String cpf) {
		int multiplicador = 9;
		int acumulador = 0;
		String cpfAux = null;
		int dv1 = 0;
		int dv2 = 0;
		// verifica se o cpf não tem 9 digitos
		if (cpf.length() != 9) {
			System.out.println("Numero invalido");
		} else {
			// Lógica de validação do cpf
			for (int pos = 8; pos >= 0; pos--) {
				acumulador += (cpf.charAt(pos) - 48) * multiplicador;
				multiplicador--;
			}
			if (acumulador % 11 == 10) {
				dv1 = 0;
			} else {
				dv1 = (acumulador % 11);
				cpfAux = cpf.concat(String.valueOf(dv1));
			}
			acumulador = 0;
			multiplicador = 9;
			for (int pos = 9; pos >= 0; pos--) {
				acumulador += (cpfAux.charAt(pos) - 48) * multiplicador;
				multiplicador--;
			}
			if (acumulador % 11 == 10) {
				dv2 = 0;
			} else {
				dv2 = acumulador % 11;
			}
		}
		// Monta string gerada pela validação
		String cpfVerificado = cpf + "-" + String.valueOf(dv1)
				+ String.valueOf(dv2);
		// Se o cpf gerado pela verificação for igual ao cpf informado pelo
		// usuário então retorna verdadeiro
		if (cpf.equals(cpfVerificado)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Método para validação de número de CNPJ
	 * 
	 * @param cnpj
	 * @return verdadeiro para válido, falso para inválido
	 */
	public boolean validateCNPJ(String cnpj) {
		int acumulador = 0;
		int multiplicador = 0;
		int dv1 = 0;
		int dv2 = 0;
		// verifica se o cnpj nao tem 12 dígitos
		if (cnpj.length() != 12) {
			System.out.println("Numero invalido");
		} else {
			// logica de verificação do cnpj
			for (int pos = 11; pos >= 0; pos--) {
				if (multiplicador < 2) {
					multiplicador = 9;
				}
				acumulador += (cnpj.charAt(pos) - 48) * multiplicador;
				multiplicador--;
			}
			if (acumulador % 11 == 10) {
				dv1 = 0;
			} else {
				dv1 = acumulador % 11;
			}
			String cnpjAux = cnpj.concat(String.valueOf(dv1));
			acumulador = 0;
			multiplicador = 9;
			for (int pos = 12; pos >= 0; pos--) {
				if (multiplicador < 2) {
					multiplicador = 9;
				}
				acumulador += (cnpjAux.charAt(pos) - 48) * multiplicador;
				multiplicador--;
			}
			if (acumulador % 11 == 10) {
				dv2 = 0;
			} else {
				dv2 = acumulador % 11;
			}
		}
		// monta a string com o resultado final da verificação
		String cnpjVerificado = cnpj.substring(0, 8) + "/"
				+ (cnpj.substring(8, 123)) + "-" + String.valueOf(dv1)
				+ String.valueOf(dv2);
		// caso o cnpj gerado na validação seja igual ao informado pelo usuário
		// então retorna verdadeiro.
		if (cnpj.equals(cnpjVerificado)) {
			return true;
		} else {
			return false;
		}

	}
}
