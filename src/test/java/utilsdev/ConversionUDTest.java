package utilsdev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import junit.framework.TestCase;

public class ConversionUDTest extends TestCase {

	public void testDateToString() {
		// Criar uma data de exemplo
		Date date = new Date();

		// Chamar o m�todo de convers�o
		String dateString = ConversionUD.convertDateToString(date);

		// Verificar se a data convertida est� no formato esperado
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(sdf.format(date), dateString);
	}

	public void testStringToDate() throws ParseException {
		// String de data de exemplo
		String dateString = "2023-09-14";

		// Chamar o m�todo de convers�o
		Date date = ConversionUD.convertStringToDate(dateString);

		// Verificar se a data convertida corresponde � data de exemplo
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(sdf.parse(dateString), date);
	}

	public void testConvertDateToLocalDateTime() {
		// Criar uma data de exemplo
		Date date = new Date();

		// Chamar o m�todo de convers�o
		LocalDateTime localDateTime = ConversionUD.convertDateToLocalDateTime(date);

		// Verificar se a data e hora foram convertidas corretamente
		assertNotNull(localDateTime);

		// Converter de volta para Date e verificar se s�o iguais
		Date convertedDate = ConversionUD.convertLocalDateTimeToDate(localDateTime);
		assertEquals(date, convertedDate);
	}

	public void testConvertLocalDateTimeToDate() {
		// Criar um LocalDateTime de exemplo
		LocalDateTime localDateTime = LocalDateTime.now();

		// Chamar o m�todo de convers�o
		Date date = ConversionUD.convertLocalDateTimeToDate(localDateTime);

		// Verificar se a data foi convertida corretamente
		assertNotNull(date);

		// Converter de volta para LocalDateTime e verificar se s�o iguais
		LocalDateTime convertedLocalDateTime = ConversionUD.convertDateToLocalDateTime(date);
		assertEquals(localDateTime, convertedLocalDateTime);
	}

	public void testConvertDateToDateTime() {
		// Criar uma data de exemplo
		Date date = new Date();

		// Chamar o m�todo de convers�o
		ZonedDateTime zonedDateTime = ConversionUD.convertDateToZonedDateTime(date);

		// Verificar se o ZonedDateTime foi criado corretamente
		assertNotNull(zonedDateTime);

		// Converter de volta para Date e verificar se s�o iguais
		Date convertedDate = ConversionUD.convertZonedDateTimeToDate(zonedDateTime);
		assertEquals(date, convertedDate);
	}

	public void testConvertDateTimeToDate() {
		// Criar um ZonedDateTime de exemplo
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());

		// Chamar o m�todo de convers�o
		Date date = ConversionUD.convertZonedDateTimeToDate(zonedDateTime);

		// Verificar se a data foi convertida corretamente
		assertNotNull(date);

		// Converter de volta para ZonedDateTime e verificar se s�o iguais
		ZonedDateTime convertedZonedDateTime = ConversionUD.convertDateToZonedDateTime(date);
		assertEquals(zonedDateTime, convertedZonedDateTime);
	}

	// Teste unit�rio para integerToString
	public void testIntegerToString() {
		assertEquals("10", ConversionUD.integerToString(10));
		assertEquals("0", ConversionUD.integerToString(0));
		assertEquals("-5", ConversionUD.integerToString(-5));
	}

	// Teste unit�rio para stringToInteger
	public void testStringToInteger() {
		assertEquals(Integer.valueOf(10), ConversionUD.stringToInteger("10"));
		assertEquals(Integer.valueOf(0), ConversionUD.stringToInteger("0"));
		assertEquals(Integer.valueOf(-5), ConversionUD.stringToInteger("-5"));
	}

	// Teste unit�rio para stringToInteger com exce��o esperada
	public void testStringToIntegerWithException() {
		try {
			ConversionUD.stringToInteger("abc"); // Isso deve lan�ar NumberFormatException
			fail("Uma exce��o NumberFormatException deve ser lan�ada.");
		} catch (NumberFormatException e) {
			// Exce��o esperada
		}
	}

	// Teste unit�rio para intToString
	public void testIntToString() {
		assertEquals("10", ConversionUD.intToString(10));
		assertEquals("0", ConversionUD.intToString(0));
		assertEquals("-5", ConversionUD.intToString(-5));
	}

	// Teste unit�rio para stringToInt
	public void testStringToInt() {
		assertEquals(10, ConversionUD.stringToInt("10"));
		assertEquals(0, ConversionUD.stringToInt("0"));
		assertEquals(-5, ConversionUD.stringToInt("-5"));
	}

	// Teste unit�rio para stringToInt com exce��o esperada
	public void testStringToIntWithException() {
		try {
			ConversionUD.stringToInt("abc"); // Isso deve lan�ar NumberFormatException
			fail("Uma exce��o NumberFormatException deve ser lan�ada.");
		} catch (NumberFormatException e) {
			// Exce��o esperada
		}
	}

}