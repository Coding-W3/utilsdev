package utilsdev.utils;

public class MaskUD {

	/**
	 * Formata um CNPJ com uma m�scara espec�fica.
	 *
	 * @param cnpj O CNPJ a ser formatado, representado como uma string de 14
	 *             d�gitos num�ricos.
	 * @return O CNPJ formatado com a m�scara "XX.XXX.XXX/XXXX-XX".
	 * @throws IllegalArgumentException Se o CNPJ n�o conter 14 d�gitos num�ricos.
	 */
	public static String formatCNPJ(String cnpj) {
		if (cnpj == null) {
			return "";
		}

		// Remove caracteres n�o num�ricos
		cnpj = cnpj.replaceAll("[^0-9]", "");

		if (cnpj.length() != 14) {
			throw new IllegalArgumentException("O CNPJ deve conter 14 d�gitos num�ricos.");
		}

		// Aplica a m�scara de formata��o
		return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
	}

}
