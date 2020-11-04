package edu.neu.csye6200;

import static java.lang.Integer.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class DemoArrayAndLoops {
	/**
	 * Inner class Item
	 * is a consumer item bought and sold
	 * 
	 * @author dgpeters
	 *
	 */
	public class CompareItemById implements Comparator<Item>  {
		/**
		 * Implement Comparator interface
		 */
		@Override
		public int compare(Item o1, Item o2) {
			return Integer.compare(o1.getId(), o2.getId());
		}
	}
	public class CompareItemByPrice implements Comparator<Item>  {
		/**
		 * Implement Comparator interface
		 */
		@Override
		public int compare(Item o1, Item o2) {
			return Double.compare(o1.getPrice(), o2.getPrice());
		}
	}
	public class CompareItemByName implements Comparator<Item>  {
		/**
		 * Implement Comparator interface
		 */
		@Override
		public int compare(Item o1, Item o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	public class Item implements Comparable<Item>, Comparator<Item>{
		private int id;
		private double price;
		private String name;
		
		/**
		 * Implement Comparator interface
		 */
		@Override
		public int compare(Item o1, Item o2) {
			return Double.compare(o1.getPrice(), o2.getPrice());
		}
		
		/**
		 * Implement Comparable interface
		 */
		@Override
		public int compareTo(Item o) {
			return this.getName().compareTo(o.getName());
//			return Integer.compare(this.getId(), o.getId());
//			return Double.compare(this.getPrice(), o.getPrice());
		}

		public Item() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Item(int id, double price, String name) {
			super();
			this.id = id;
			this.price = price;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Item [id=" + id + ", price=" + price + ", name=" + name + "]";
		}
	}
	
	public void useRangeBasedLoop() {
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".useRangeBasedLoop()...");
		
		/**
		 * Initialize an array with the original initial values
		 */
		int[] numbers = { 1,2,3,4 };
		System.out.println("Originals...");
		for (int n : numbers) {
			System.out.print(n + ", ");
		}
		System.out.println();
		/**
		 * Change and see what happens
		 */
		System.out.println("Modify...");
		
		for (int n : numbers) {
			n++;
			System.out.print(n + ", ");	// show modified value
		}
		System.out.println();
		/**
		 * Show the final results
		 */
		System.out.println("Final Results...");
		for (int n : numbers) {
			System.out.print(n + ", ");
		}
		System.out.println();
		
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".useRangeBasedLoop()... done!");
	}
	public void useForLoop() {
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".useForLoop()...");
		
		/**
		 * Initialize an array with the original initial values
		 */
		int[] numbers = { 1,2,3,4 };
		System.out.println("Originals...");
		for (int i=0; i < 4; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println();
		/**
		 * Change and see what happens
		 */
		System.out.println("Modify...");
		
		for (int i=0; i < 4; i++) {
			numbers[i]++;
			System.out.print(numbers[i] + ", ");	// show modified value
		}
		System.out.println();
		/**
		 * Show the final results
		 */
		System.out.println("Final Results...");
		for (int i=0; i < 4; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println();
		
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".useForLoop()... done!");
	}
	/**
	 * Demonstrate the use of sort
	 */
	public void useSort() {
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".useSort()... ");
		
		{
			System.out.println("Sort array...");
			Integer[] numbers = { 9, 7, 23, 3, 5 };
			for (int n : numbers) System.out.print(n + ", ");
			System.out.println();
			
			Arrays.sort(numbers);	// sort Integer object references in array
			
			for (int n : numbers) System.out.print(n + ", ");
			System.out.println();
		}
		{
			String[] names = { "sam", "dan", "jim" };
//			String[] names = { “sam”,“dan”,”jim” };
			List<String> list = new ArrayList<>(Arrays.asList(names));
			for (String s : list) System.out.print(s + ", ");
			System.out.println();

//			Collections.sort(list);
			list.sort(null);	// no Comparator
			
			for (String s : list) System.out.print(s + ", ");
			System.out.println();
		}
		{
			List<Item> items = new ArrayList<>(Arrays.asList(
					new Item(2,.99,"bread"),
					new Item(1,3.49,"oj"),
					new Item(3,1.99,"milk"),
					new Item(4,.39,"candy")
					));
			for (Item s : items) System.out.println(s);

			System.out.println("Sorted Items...");
			/**
			 * No Comparator:
			 * List elements must implement Comparable for Natural Order
			 */
//			Collections.sort(items);
//			items.sort(null);	// no Comparator
			
			/**
			 * Use Comparator:
			 * to impose an explicit sort order as specified by Comparator
			 */

//			items.sort(Comparator.comparing(Item::getId));	// lambda
			items.sort(Comparator.comparing(Item::getPrice));	// lambda
//			items.sort(Comparator.comparing(Item::getName));	// lambda
//			items.sort(new Comparator<Item>() {	// anonymous inner class
//
//				@Override
//				public int compare(Item o1, Item o2) {
//					return o1.getName().compareTo(o2.getName());
//				}
//			});
//			items.sort(new CompareItemById());	// Comparator
//			items.sort(new CompareItemByPrice());	// Comparator
//			items.sort(new CompareItemByName());	// Comparator
//			items.sort(new Item());	// Item object implements Comparator
			
			for (Item s : items) System.out.println(s);
		}
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".useSort()... done!");		
	}
	public static void demo() {
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".demo()...");

		DemoArrayAndLoops obj = new DemoArrayAndLoops();
		
		obj.useRangeBasedLoop();
		obj.useForLoop();
		
		/**
		 * demonstrate auto-boxing
		 */
		int n = 2;		// primitive int
		Integer number = n+1;	// auto-boxing Integer wrapper object
//		Integer number = new Integer(n+1);	// Integer wrapper object
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);		// auto-boxing of primitive int into an Integer object
		numbers.add(n);		// auto-boxing of primitive int into an Integer object
		numbers.add(number);	//  add Integer object to list
		numbers.add(4);	//  add Integer object to list
//		numbers.add(new Integer(4));	//  add Integer object to list
		System.out.println(numbers.size() + " numbers in list.");
		/**
		 * Auto-unboxing in ranged base for loop
		 * as Integer objects are unboxed to primitive int
		 */
		for (int x : numbers) {
			System.out.print(x + ", ");
		}
		System.out.println();
		
		obj.useSort();
		
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".demo()... done!");
	}
}
