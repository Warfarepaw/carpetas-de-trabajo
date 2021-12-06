import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PeluDo{
	
	public static void main(String[] args) {
		
		PeluDo pelu = new PeluDo();
//		System.out.print(pelu.reversedWord());
//		System.out.println(pelu.SwapTwoWitoutThirdVariable());
//		pelu.countWord();
//		pelu.primeNumber();
//		pelu.isPalindrome();
//		pelu.fibonacciSeries();
//		pelu.duplicateCharacters();
//		pelu.secondHighest();
		pelu.amstrongNumber();
		
	}
	
	public String reversedWord()
	{
		
		Scanner scan = new Scanner(System.in);
		
		
		String word = scan.nextLine();
		String[] letters = word.split("");
		
		StringBuilder reversedWord = new StringBuilder();

		
		for(int i = 1; i<=letters.length; i++) 
		{
			reversedWord.append(letters[letters.length - i]);
			
		}
		
		return reversedWord.toString();

	}
	
	public String SwaptwoWithThirdVariable()
	{
		int x, y, temp;
		
		System.out.println("Enter the values of X and Y");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("value of X=");
		x = scan.nextInt();
		System.out.print("value of Y=");
		y = scan.nextInt();
		
		System.out.println("value of X="+x+" value of Y="+y);
		System.out.println("sweeping x and y values");
		temp = x;
		x = y;
		y = temp;
		
		return "value of X="+x+" value of Y="+y;
		
	}
	
	public String SwapTwoWitoutThirdVariable() 
	{
		int x, y, temp;
		
		System.out.println("Enter the values of X and Y");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("value of X=");
		x = scan.nextInt();
		System.out.print("value of Y=");
		y = scan.nextInt();
		
		System.out.println("value of X="+x+" value of Y="+y);
		System.out.println("sweeping x and y values");
		
		x = x + y;
		y = x - y;
		x = x - y;
		
		return "value of X="+x+" value of Y="+y;
		
	}
	

	public int countWord() 
	{
		
		Scanner scan = new Scanner(System.in);
		String phrase = scan.nextLine();
		
		String[] words = phrase.split(" ");
		
		HashMap<String, Integer> count = new HashMap(); 
		
		for(int i = 0; i < words.length; i++) 
		{
			if(count.containsKey(words[i])) 
			{
				int wordCount = count.get(words[i]);
				wordCount++;
				count.put(words[i], wordCount);
			}else 
			{
				count.put(words[i], 1);
			}
		}
		
		for(Map.Entry values: count.entrySet()) 
		{
			System.out.println(values.getKey()+" "+ values.getValue());
			
		}
		return 0;
	}
	
	public void primeNumber() 


	{
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
				
		if(number%2 == 0) 
		{
			System.out.println("the number = "+ number +" its a prime number");
		}else 
		{
			System.out.println("the number = "+ number + " its an odd number");
		}
		
	}

	public void isPalindrome() 
	{
		Scanner scan = new Scanner(System.in);
		
		String word  = scan.next();
		
		StringBuilder reversedWord = new StringBuilder(word);
		StringBuilder normalWord = new StringBuilder(word);
		
		reversedWord.reverse();
		
		System.out.println(normalWord.toString());
		System.out.println(reversedWord.toString());
		
		if(normalWord.toString().equals(reversedWord.toString())) 
		{
			System.out.println("the word its a palindrome");
		}else 
		{
			System.out.println("");
			System.out.println("the word its not a palindrome");
		}
		
		
	}

	public void fibonacciSeries() 
	{
		int num, a = 0, b = 0, c = 1;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of times");
		num = scan.nextInt();
		
		System.out.println("Fibonjacci Series of the number is:");
		
		for (int i = 0; i < num; i++) {
		
				a = b;
				b = c;
				c = a+b;
				System.out.print(a + " ");

		}
	}

	public void iterates() 
	{
		 
		
		Scanner scan = new Scanner(System.in);
		String words = scan.next();
		String[] letras = words.split("");
		List<String> palabras = Arrays.asList(letras);
		
		Iterator iter = palabras.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next().toString()); 
			
		}
		
		for(String in: letras) 
		{
			System.out.println(in);
		}
		
	}
	
	public void duplicateCharacters() 
	{
		Scanner scan = new Scanner(System.in);
		
		String word = scan.next();
		
		String[] letters = word.split("");
		
		HashMap<String, Integer> duplicates = new HashMap();
		
		for (int i = 0; i < letters.length; i++) {
			
			if(duplicates.containsKey(letters[i])) 
			{
				int count = duplicates.get(letters[i]);
				count++;
				duplicates.put(letters[i], count);
			}else 
			{
				duplicates.put(letters[i], 1);
			}
			
		}
		
		System.out.println(duplicates);
	}

	public void secondHighest() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("how many numbers do you want in your list?");
		int number = scan.nextInt();
		int[] list = new int[number];
		for (int i = 0; i < number; i++) {
			System.out.print("ingresa el numero: ");
			list[i] = scan.nextInt();
			System.out.println("");
		}
		
		Arrays.sort(list);
		System.out.println(list[list.length-1]);
		
	}

	public void amstrongNumber() 
	{
		
		Scanner scan = new Scanner(System.in);
		String[] str = scan.next().split("");
		int [] sum = new int[str.length];
		int amstrongNumber = 0;
		
		for (int i = 0; i < str.length; i++) {
			sum[i] = Integer.parseInt(str[0]);
			for (int j = 0; j <str.length; j++) {
				sum[i] = sum[i] * Integer.parseInt(str[i]);
				
			}
			System.out.println(sum[i]);
			amstrongNumber = amstrongNumber + sum[i];
		}
		System.out.println(amstrongNumber);
		
	}
}
