package org.csystem.math;

/**
 * Complex class that represents a complex number
 * Last Update: 22nd June 2025
 * @author Java-Sep-2024 Group
 */

public class Complex {
	public double real;
	public double imag;
	
	private static Complex add(double re1, double im1, double re2, double im2)
	{	
		return new Complex(re1 + re2, im1 + im2);
	}
	
	private static Complex subtract(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}
	
	private static Complex multiply(double re1, double im1, double re2, double im2)
	{
		return new Complex(re1 * re2 - im1 * im2, re1 * im2 + re2 * im1);
	}
	
	public Complex()
	{		
	}
	
	public Complex(double a)
	{
		real = a;
	}
	
	public Complex(double a, double b)
	{
		real = a;
		imag = b;
	}
	
	public static Complex add(double value, Complex z)
	{
		return add(value, 0, z.real, z.imag);
	}
	
	public Complex add(double value)
	{
		return add(real, imag, value, 0);
	}
	
	public Complex add(Complex other)
	{
		return add(real, imag, other.real, other.imag);
	}
	
	public static Complex subtract(double value, Complex z)
	{
		return subtract(value, 0, z.real, z.imag);
	}
	
	public Complex subtract(double value)
	{
		return subtract(real, imag, value, 0);
	}
	
	public Complex subtract(Complex other)
	{
		return subtract(real, imag, other.real, other.imag);
	}
	
	public static Complex multiply(double value, Complex z)
	{
		return multiply(value, 0, z.real, z.imag);
	}
	
	public Complex multiply(double value)
	{
		return multiply(real, imag, value, 0);
	}
	
	public Complex multiply(Complex other)
	{
		return multiply(real, imag, other.real, other.imag);
	}

	//...
	
	public Complex getConjugate()
	{
		return new Complex(real, -imag);
	}
	
	public double getNorm()
	{
		return Math.sqrt(real * real + imag * imag);
	}
	
	public double getLength()
	{
		return getNorm();
	}
	
	public String toString()
	{
		return "|(%f, %f)| = %.3f".formatted(real, imag, getLength());
	}
}
