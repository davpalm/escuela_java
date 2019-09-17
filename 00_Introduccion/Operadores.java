class Operadores{
	public static void main(String[] args)
	{
		System.out.println(5 !=5 ? "Pues si" : "Pues no");
		if(args[1].equals("aa"))
		{
			System.out.println("Quieres dos AA");
		}
		else
		{
			System.out.println("Quieres otra");
		}
		
		System.out.println(args[1].equals("aa") ? "Pues si" : "Pues no");
	}
}