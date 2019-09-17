public class HolaMundo
{
	public static void main(String[] args)
	{	
		System.out.println("Hola Mundo");
		String nombre="David";
		System.out.println("Hola " + nombre);
		
		byte unByte=127;
		System.out.println("Byte " + unByte);
		int entero=1234567890;
		System.out.println("Entero " + entero);
		long enteroLong=12345678901234890L;
		System.out.println("Long " + enteroLong);
		float nFloat=0.599999999f;
		System.out.println("Float " + nFloat);
		double nDouble=0.5999999999999;
		System.out.println("Double " + nDouble);
		char character=220;
		System.out.println("Caracter " + character);
		char[] texto={'a','b','c'};
		System.out.println("Caracter en array " + texto[0]);
		
	}
}