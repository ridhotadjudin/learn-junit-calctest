package nexsoft.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	Calculator calculator;
	
	@BeforeAll
	public static void setup() {
		System.out.println("BeforeAll");
	}
	
	@BeforeEach
	public void init() {
		calculator = new Calculator();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "data.csv",delimiter=';',numLinesToSkip = 1)
	public void test_perkalian(int a, int b,int Expected) {
		int result = calculator.multiply(a, b);
		assertEquals(Expected, result);
	}
	
	@ParameterizedTest
	@DisplayName("Operasi Multiply 3 Var")
	@CsvSource({"2,2,4","3,3,27","4,3,64"})
	public void testMultiply(String a, String b,String c) {
		int actual = calculator.multiply(Integer.parseInt(a), Integer.parseInt(b));
		assertEquals(Integer.parseInt(c), actual);
	}
	
	@DisplayName("Penambahan 3 variabel")
	@ParameterizedTest
	@MethodSource("menyediakanParameterTambah")
	public void testTambah(int a,int b, int c) {
		int result = calculator.penjumlahan(a, b);
		assertEquals(c, result);
	}
	
	// ini method source nya
	private static Stream<Arguments> menyediakanParameterTambah(){
		return Stream.of(
				Arguments.of(5,5,10),
				Arguments.of(-5,5,0),
				Arguments.of(5,-5,0),
				Arguments.of(-5,-5,-10)
				);
	}
	
	
	//cuma bisa 1 variabel
	@DisplayName("Pengecekan Angka Ganjil")
	@ParameterizedTest 							//harus instal junit jupiter params sesuai versi
	@ValueSource(ints = {3,5,7,9,11})
	public void cekGanjil(int number) {
		assertTrue(calculator.isGanjil(number));
	}
	
	@Disabled
	@DisplayName("Pengecekan Password")
	@ParameterizedTest 							//harus instal junit jupiter params sesuai versi
	@ValueSource(strings = {"makan","Mantap","mandi","mantap"})
	public void cekPass(String pass) {
		assertTrue(calculator.cekPass(pass));
	}
	
	@ParameterizedTest
	@DisplayName("Operasi Pengurangan")
//	@CsvSource({"1,1,0","2,1,1"})
	@CsvSource(value={"1:1:0","2:1:1"},delimiter=':')
	public void testKurang(String a, String b,String c) {
		int actual = calculator.pengurangan(Integer.parseInt(a), Integer.parseInt(b));
		assertEquals(Integer.parseInt(c), actual);
	}
	
	@Disabled //bisa ditempatkan sebelum atau sesudah test
	@Test
	public void testMinus() {
		int actual = calculator.pengurangan(5, 10);
//		assertEquals(0, actual,"ini gagal karena harusnya -95");
//		assertNotEquals(-94, actual,"ini gagal karena harusnya -95");
		assertAll(()->assertEquals(-5, actual),()->assertNotEquals(5, actual));
	}
	
//	@Disabled
	@Test
	@DisplayName("Menghitung Pembagian")
	public void testPembagian() {
//		int actual = calculator.pembagian(5, 0);
//		assertEquals(3, actual);
		
		// digunakan ketika menangkap eror throw dari fungsi
//		ArithmeticException actualException = assertThrows(ArithmeticException.class, ()->{
//			calculator.pembagian(5,1);
//		},"Tidak boleh dibagi dengan nol");
//		assertEquals("/ by zero", actualException.getMessage());
		
		// dapakai ketika fungsi tidak melempar eror karena sudah di tangkap di coding asli
		assertDoesNotThrow(()->{
			calculator.pembagian2(5, 0);
		},"Tidak ada throws");
	}
	
	@AfterEach
	public void close() {
	}
	
	@AfterAll
	public static void exit() {
		System.out.println("AfterAll");
	}
	
}
