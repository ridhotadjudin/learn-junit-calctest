package nexsoft.test;

public class Calculator {
	
	public int penjumlahan(int a, int b) {
		return a+b;
	}
	public int pengurangan(int a, int b) {
		return a-b;
	}
	
	public int perkalian(int a, int b) {
		return a*b;
	}
	
	public int pembagian(int a, int b) {
		return a/b;
	}
	
	public int pembagian2(int a, int b) {
		int nilai = 0;
		try {
			nilai  = a/b;
		}catch(ArithmeticException e){
			
		}
		return nilai;
	}
	
	public boolean isGanjil(int a) {
		return a%2==1;
	}
	
	public boolean cekPass(String pass) {
		return pass.equals("mantap");
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
}
