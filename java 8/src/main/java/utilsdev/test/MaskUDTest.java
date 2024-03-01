package utilsdev.test;

import junit.framework.TestCase;
import utilsdev.utils.MaskUD;

public class MaskUDTest extends TestCase {

	/**
	 * Teste para verificar se o CNPJ � formatado corretamente.
	 */
	public void testFormatCNPJ() {
		String cnpj = "12345678901234";
		String formattedCNPJ = MaskUD.formatCNPJ(cnpj);
		assertEquals("12.345.678/9012-34", formattedCNPJ);

		cnpj = "1234567890";
		try {
			formattedCNPJ = MaskUD.formatCNPJ(cnpj);
			fail("Deve lan�ar uma IllegalArgumentException para o tamanho inv�lido do CNPJ.");
		} catch (IllegalArgumentException e) {
			assertEquals("O CNPJ deve conter 14 d�gitos num�ricos.", e.getMessage());
		}

		cnpj = "1234567890A1234";
		try {
			formattedCNPJ = MaskUD.formatCNPJ(cnpj);
			fail("Deve lan�ar uma IllegalArgumentException para caracteres n�o num�ricos.");
		} catch (IllegalArgumentException e) {
			assertEquals("O CNPJ deve conter 14 d�gitos num�ricos.", e.getMessage());
		}
	}

}
