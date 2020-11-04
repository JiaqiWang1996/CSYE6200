package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class DemoParameterPassing {

	private class Data {
		private int n = 0; // state

		public Data() {
			super();
		}
		public Data(int n) {
			super();
			this.n = n;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}		
		public void incrementN() {
			this.n++;
		}

		@Override
		public String toString() {
			return " " + n;
		}
	}
	
	/**
	 * Increment supplied object and return result
	 * 
	 * @param n		supplied object
	 * 
	 * @return		result of increment
	 */
	public Data incrementData(Data obj) {
		obj.incrementN();
		return obj;
	}
	/**
	 * add supplied object and offset and return result
	 * 
	 * @param n			supplied object
	 * @param offset	supplied offset
	 * 
	 * @return			resulting sum
	 */
	public Data offsetData(Data obj, int offset) {
		obj.setN(obj.getN() + offset);
		return obj;
	}
	/**
	 * multiply supplied object by factor and return result
	 * 
	 * @param n			supplied object
	 * @param factor	supplied factor
	 * 
	 * @return		result of multiplication
	 */
	public Data scaleData(Data obj, int factor) {
		obj.setN(obj.getN() * factor);
		return obj;
	}

	/**
	 * Increment supplied parameter and return result
	 * 
	 * @param n		supplied parameter
	 * 
	 * @return		result of increment
	 */
	public int incrementData(int n) {
		n++;
		return n;
	}
	/**
	 * add supplied parameter and offset and return result
	 * 
	 * @param n			supplied parameter
	 * @param offset	supplied offset
	 * 
	 * @return			resulting sum
	 */
	public int offsetData(int n, int offset) {
		n += offset;
		return n;
	}
	/**
	 * multiply supplied parameter by factor and return result
	 * 
	 * @param n			supplied parameter
	 * @param factor	supplied factor
	 * 
	 * @return		result of multiplication
	 */
	public int scaleData(int n, int factor) {
		n *= factor;
		return n;
	}
	
	/**
	 * Demonstrate passing a primitive parameter to a method
	 */
	public void passIntegerData() {
		int[] integers = { 1,2,3 };
		for (int n : integers) this.incrementData(n);
		for (int n : integers) System.out.print(n + ",");
		for (int n : integers) this.scaleData(n,3);
		for (int n : integers) System.out.print(n + ",");
		for (int n : integers) this.offsetData(n,100);
		for (int n : integers) System.out.print(n + ",");
		System.out.println();
	}
	
	/**
	 * Demonstrate passing a primitive parameter to a method
	 * and using the value returned
	 */
	public void passAndUseReturnIntegerData() {
		int n = 1;	// initial data
		
		System.out.print(n + ",");
		System.out.print(this.incrementData(n) + ",");
		System.out.print(this.scaleData(n, 3) + ",");
		System.out.print(this.offsetData(n, 100) + ",");
		System.out.print(n + ",");
		System.out.println();
	}
	
	/**
	 * Demonstrate passing an object parameter to a method
	 * and using the value returned
	 */
	public void passAndUseReturnObjectData() {
		Data obj = new Data(1);
		
		System.out.print(obj + ",");	// initial state
		System.out.print(this.incrementData(obj) + ",");
		System.out.print(this.scaleData(obj, 3) + ",");
		System.out.print(this.offsetData(obj, 100) + ",");
		System.out.print(obj + ",");	// initial state
		System.out.println();
	}
	
	/**
	 * Demonstrate passing an object parameter to a method
	 * and using the value returned
	 */
	public void passObjectData() {
		List<Data> dataList = new ArrayList<>();
		dataList.add(new Data(1));
		dataList.add(new Data(2));
		dataList.add(new Data(3));
		
		// show initial state of the Data Object List
		dataList.forEach((d) -> System.out.print(d + ", "));

		// Modify state of each Data object in List
		for (Data d : dataList) incrementData(d); 
		dataList.forEach((d) -> System.out.print(d + ", "));
		
		for (Data d : dataList) scaleData(d, 3); 
		dataList.forEach((d) -> System.out.print(d + ", "));

		for (Data d : dataList) offsetData(d, 100); 
		dataList.forEach((d) -> System.out.print(d + ", "));
		System.out.println();
	}
	public static void demo() {
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".demo()...");
		DemoParameterPassing obj = new DemoParameterPassing();
		
		obj.passIntegerData();
		obj.passAndUseReturnIntegerData();
		obj.passAndUseReturnObjectData();
		obj.passObjectData();

		{
			int n = 1;
			
		}
		
		System.out.println("\n\t" + DemoParameterPassing.class.getName() + ".demo()... done!");
	}

}
