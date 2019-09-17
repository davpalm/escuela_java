class EstructurasControl{
	public static void main(String[] args)
	{
		/*
		for(int i=0; i<args.length;i++)
		{
			System.out.println("Arg " + args[i]);
		}
		*/
		
		/*
		int i=0;
		while(i<args.length)
		{
			System.out.println("Arg " + args[i]);
			i++;
		}
		*/
		
		do
		{
			System.out.println("Se muestra siempre");
		} while(false);
		
		boolean ejecutar= 5<3 && 20==20;
		if(ejecutar)
		{
			System.out.println("La condicion es true");
		}
		else
		{
			System.out.println("La condicion es false");
		}
		
		int valor=1;
		switch(valor)
		{
			case 0:
				System.out.println("Valor 0");
				break;
			case 1:
				System.out.println("Valor 1");
				break;
			case 2:
				System.out.println("Valor 2");
				break;
			default:
				System.out.println("Otro valor");
				break;
		}
		
		if("" + 5 == "5")
		{
			System.out.println("Son iguales");
		}
	}
	
}