package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Example {
	
	public static void main(String[] args) {
		Example example = new Example();
//		example.evaluate();
//		example.init();
//		example.codef();
//		example.contarPalabras();
		example.reverseWord();
		
		
	}
	
	 public void contarPalabras() 
	 {
		 Scanner scan = new Scanner(System.in);
		 String oracion = scan.nextLine().replace(",", " ");
		 
		 String[] palabrasIndividuales = oracion.split(" ");
		 
		 List<String> palabra = Arrays.asList(palabrasIndividuales);
		
		 HashSet<String> conteo = new HashSet<>();
		 Hashtable<String, Integer> Cuentas = new Hashtable<String, Integer>();
		 
		 Iterator<String> pal = palabra.iterator();
		 
		 while(pal.hasNext()) 
		 {
			 
			 String word = pal.next();
			 if(conteo.contains(word)) 
			 {
				 int cuenta= Cuentas.get(word);
				 cuenta++;
				 Cuentas.put(word, cuenta);
				 
			 }else 
			 {
				 Cuentas.put(word, 1);
				 conteo.add(word);
			 }
			 
		 }
		 
		 System.out.println(Cuentas);
	 }

	 public void reverseWord() 
	 {
		 
		 Scanner scan = new Scanner(System.in);
		 String word = scan.nextLine();
		 String[] letters = word.split("");
		 List<String> allLetters = Arrays.asList(letters);
		 List<String> wordReversed = new ArrayList<String>();
		 
		 int i = 1;
		 for(String let: allLetters) 
		 { 
			 wordReversed.add(allLetters.get(allLetters.size()-i));
			 i++; 
		 }
		 
		 for(String let: wordReversed)System.out.print(let);
		 
	 }
	 
	 public void codef() 
	 {
		int[] inputArray = new int[] {3, 6, -2, -5, 7, 3};
		
		    int biggerProduct = 0;
		    for(int i: inputArray)
		    {
		        for(int j: inputArray)
		        {
		            int sitProduct = inputArray[i]*inputArray[j];
		            if(biggerProduct < sitProduct)
		            {
		                biggerProduct = sitProduct;
		            }
		        }
		    }
		    
		    Random ram = new Random();
		    List<Integer> lista = ram.ints(10, 0, 100).limit(10).boxed().collect(Collectors.toList());
		    IntSummaryStatistics stats= lista.stream().mapToInt((x) -> x).summaryStatistics();
		    

		 
	 }

	 public void evaluate() 
	{
		int number = 2;
		
		Scanner scan = new Scanner(System.in);
		
		int newnum = Integer.parseInt(scan.nextLine()) % 2;
		
		if(newnum==0) 
		{
			System.out.println("the number its an odd");
		}else 
		{
			System.out.println("the number its an non");
		}
	
	}
	 
	 public void init() 
	 {
		 MathOperation addition = (int a, int b) -> a + b;
		 MathOperation substraction = (int a, int b) -> a - b;
		 MathOperation multiplication = (int a, int b) -> {return a*b ;}; 
		 MathOperation division = (int a, int b) -> a/b;
		 
		 System.out.println("10 + 5 = " + operate(10, 5, addition));
		 
		 List<String> numberNames = Arrays.asList("uno","dos","tres","cuatro","cinco");
		 numberNames.forEach(System.out::println);
		 
		 numberNames
		 .stream()
		 .filter(s -> s.equals("dos"))
		 .map(String::toUpperCase)
		 .sorted()
		 .forEach(System.out::println);
		  
	 }
	
	 private int operate(int a, int b, MathOperation mathOperation){return mathOperation.operation(a, b);}; 
	 {
		 
	 }
	 
	 public interface MathOperation
	 {
		 public int operation(int a, int b);
	 }

	 
	 public void sort() 
	 {
		 List<Integer> list = Arrays.asList(8,2,4,9,5,6,7,1,3);
		 System.out.println("unsorted list" + list);
		 
		 OrderBy orderBy = new OrderBy();
		 Collections.sort(list, orderBy);
		 
	 }
	 
	 public class OrderBy implements Comparator<Integer>
	 {

		@Override
		public int compare(Integer a, Integer b) {
			return a-b;
		}
		 
	 }
	 
	 public static void eval() 
	 {
		 
	 }
	
	 
}
