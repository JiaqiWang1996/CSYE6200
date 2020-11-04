package edu.neu.csye6200;

public class CalcComplex {
	private ComplexNumber a;
	private ComplexNumber b;
	private ComplexNumber result;
	
	/**
	 * Object Initializer Block
	 * executed with each constructor
	 */
	{
		this.a = new ComplexNumber();
		this.b = new ComplexNumber();
		this.result = new ComplexNumber();
	}
	public double realA = 0.0;
	public double imaginaryA = 0.0;
	public double realB = 0.0;
	public double imaginaryB = 0.0;
	public double realResult = 0.0;
	public double imaginaryResult = 0.0;
	/**
	 * Represent a complex number with both a real and imaginary part
	 * 
	 * @author dpeters
	 *
	 */
	private class ComplexNumber implements Comparable<ComplexNumber> {
		private double real;
		private double imaginary = 0.0;
		/**
		 * Object initializer block
		 * executed with each constructor
		 */
		{
			this.real = 0.0;
			this.imaginary = 0.0;
		}
		/**
		 * Implement Comparable
		 * 
		 * @param 		n	other ComplexNumber object to compare with
		 * 
		 * @return		signed integer metric where 0 is equal
		 */
		@Override
		public int compareTo(ComplexNumber n) {
			int metric = 0;
			if ( this.real == n.real) {
				metric = Double.compare(this.imaginary, n.imaginary);
			} else {
				metric = Double.compare(this.real, n.real);
			}
			return metric;
		}
		public ComplexNumber() {
			super();
		}
		public ComplexNumber(ComplexNumber n) {
			super();
			this.real = n.real;
			this.imaginary = n.imaginary;
		}
		public ComplexNumber(double real, double imaginary) {
			super();
			this.real = real;
			this.imaginary = imaginary;
		}
		public double getReal() {
			return real;
		}
		public void setReal(double real) {
			this.real = real;
		}
		public double getImaginary() {
			return imaginary;
		}
		public void setImaginary(double imaginary) {
			this.imaginary = imaginary;
		}
		public ComplexNumber add(ComplexNumber n) {
			this.real += n.real;
			this.imaginary += n.imaginary;
			return this;
		}
		public ComplexNumber sub(ComplexNumber n) {
			this.real -= n.real;
			this.imaginary -= n.imaginary;
			return this;
		}
		public ComplexNumber mult(ComplexNumber n) {
			this.real *= n.real;
			this.imaginary *= n.imaginary;
			return this;
		}
		public ComplexNumber div(ComplexNumber n) {
			this.real /= n.real;
			this.imaginary /= n.imaginary;
			return this;
		}
		public void info() {
			System.out.println(this);
		}
		
		@Override
		public String toString() {
//			StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + " result = ");
			StringBuilder sb = new StringBuilder("(");
			sb.append(real);
			if (imaginary < 0) {
				sb.append(" - ");	// negative imaginary part
			} else {
				sb.append(" + ");
			}
			sb.append(Math.abs(imaginary)).append("i");
			sb.append(")");
//			return sb.toString();
//			sb.append(this.complexNumber());
//			sb.append(", WHERE Real part").append(this.complexNumber()).append(" = ").append(this.realResult);
//			sb.append(", AND Imaginary part").append(this.complexNumber()).append(" = ").append(this.imaginaryResult);
			
			return sb.toString();
		}
	}

	
	public CalcComplex() {
		super();
		this.realA = 2.2;
		this.imaginaryA = 4.2;
		this.realB = 3.3;
		this.imaginaryB = 5.3;
		
		this.a.setReal(this.realA);
		this.a.setImaginary(this.imaginaryA);
		this.b.setReal(this.realB);
		this.b.setImaginary(this.imaginaryB );
		this.result.setReal(0.0);
		this.result.setImaginary(0.0);
	}

	public CalcComplex(double realA, double imaginaryA, double realB, double imaginaryB) {
		super();
		this.setState(realA, imaginaryA, realB, imaginaryB);
		this.realResult = 0;
		this.imaginaryResult = 0;
	}

	public CalcComplex(double realA, double imaginaryA, double realB, double imaginaryB, double realResult,
			double imaginaryResult) {
		super();
		this.setState(realA, imaginaryA, realB, imaginaryB);
		this.realResult = realResult;
		this.imaginaryResult = imaginaryResult;
	}
	
	public void setState(double realA, double imaginaryA, double realB, double imaginaryB) {
		this.realA = realA;
		this.imaginaryA = imaginaryA;
		this.realB = realB;
		this.imaginaryB = imaginaryB;
		
		this.a.setReal(this.realA);
		this.a.setImaginary(this.imaginaryA);
		this.b.setReal(this.realB);
		this.b.setImaginary(this.imaginaryB );
//		this.result.setReal(0.0);
//		this.result.setImaginary(0.0);
	}

	public ComplexNumber getA() {
		return this.a;
	}
	public void setA(ComplexNumber n) {
		this.a = n;
	}
	public ComplexNumber getB() {
		return this.b;
	}
	public void setB(ComplexNumber n) {
		this.b = n;
	}	
	public ComplexNumber getResult() {
		return this.result;
	}
	public void setResult(ComplexNumber n) {
		this.result = n;
	}
	
	private String complexNumber() {
		return this.complexNumber(realResult, imaginaryResult);
	}
	
	private String complexNumber(double real, double imaginary) {
		StringBuilder sb = new StringBuilder("(");
		sb.append(real);
		if (imaginary < 0) {
			sb.append(" - ");	// negative imaginary part
		} else {
			sb.append(" + ");
		}
		sb.append(Math.abs(imaginary)).append("i");
		sb.append(")");
		return sb.toString();
	}
	
	public void add() {
		System.out.println(this.getClass().getSimpleName() + " Add: " + this.complexNumber(this.realA, this.imaginaryA) + " + " + this.complexNumber(realB, imaginaryB));
		this.realResult = this.realA + this.realB;
		this.imaginaryResult = this.imaginaryA + this.imaginaryB;
		
		System.out.println("OR...");
		System.out.println(this.getClass().getSimpleName() + " Add: " + this.a + " + " + this.b);
		this.result = this.a.add(this.b);
	}

	public String info() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + " result = ");
		sb.append(this.complexNumber());
		sb.append(", WHERE Real part").append(this.complexNumber()).append(" = ").append(this.realResult);
		sb.append(", AND Imaginary part").append(this.complexNumber()).append(" = ").append(this.imaginaryResult);
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return this.info();
	}
	
	public static void demo() {
		System.out.println("\n\t" + CalcComplex.class.getName() + ".demo() starting...");
		CalcComplex obj = new CalcComplex();
		obj.add();
		System.out.println(obj);
		System.out.println("ComplexNumber Result: " + obj.getResult());
		System.out.println();
		obj.setState(1, 3, 2, -5);
		obj.add();
		System.out.println(obj);
		System.out.println("ComplexNumber Result: " + obj.getResult());
		System.out.println("\n\t" + CalcComplex.class.getName() + ".demo() done!");
	}

}
