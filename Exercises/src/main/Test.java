package main;

public class Test {
	
	public static void main(String [] args) 
	{
		changeCase("This is Interview");
	}
	
	public static String changeCase(String input) 
	{
		char[] a = input.toCharArray();
		StringBuilder cCase = new StringBuilder("");
		for(int i = 0; i < input.length() ; i++) 
		{
			int b = (int) a[i];
			if(b > 65 && b < 91) 
			{
				b = b + 32;
				a[i] = (char) b;
				//System.out.println(a[i]);
			}else
			{
				if((b > 97 && b < 123) ) 
				{
					b = b - 32;
					a[i] = (char) b;
					//System.out.println(a[i]);
				}

			}

			cCase.append(Character.toString(a[i]));
		}
		System.out.println(cCase);
		return "";
	}

}
