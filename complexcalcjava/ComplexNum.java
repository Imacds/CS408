package com.googleworkshop.jakub.complexcalc;

public class ComplexNum extends Number {
	
	private double real;
	private double imaginary;

	public ComplexNum(String s){
		this(0,0);
		String[] parsed = s.split("\\+");
		for(int i = 0; i < parsed.length; i++){
			if(parsed[i].contains("i")){
				parsed[i] = parsed[i].replace("i", "");
				imaginary+=Double.parseDouble(parsed[i]);
			}else{
				real+=Double.parseDouble(parsed[i]);
			}
		}
	}

	public ComplexNum(double a, double b) {
		real = a;
		imaginary = b;
	}
	
	public double getReal() {
		return real;
	}
	
	public void setReal(double a) {
		real = a;
	}
	
	public double getImaginary() {
		return imaginary;
	}
	
	public void setImagianry(double b) {
		imaginary= b;
	}
	
	public ComplexNum subtract(ComplexNum second) {
		ComplexNum first = this;
		
		double tempReal = first.getReal() - second.getReal();
		double tempImaginary = first.getImaginary() - second.getImaginary();
		return new ComplexNum(tempReal, tempImaginary);
	}
	
	public ComplexNum add(ComplexNum second) {
		ComplexNum first = this;
		
		double tempReal = first.getReal() + second.getReal();
		double tempImaginary = first.getImaginary() + second.getImaginary();
		return new ComplexNum(tempReal, tempImaginary);
	}
	
	public ComplexNum multiply(ComplexNum second) {
		ComplexNum first = this;
		
		double tempReal = first.getReal() * second.getReal() - first.getImaginary() * second.getImaginary();
		double tempImaginary = first.getReal() * second.getImaginary() + first.getImaginary() * second.getReal();
		return new ComplexNum(tempReal, tempImaginary);
	}
	
	public ComplexNum divide(ComplexNum second) {
		ComplexNum first = this;
		
		double denom = second.getReal() * second.getReal() + second.getImaginary() * second.getImaginary();
		double tempReal = first.getReal() * second.getReal() + first.getImaginary() * second.getImaginary();
		double tempImaginary = first.getImaginary() * second.getReal() + first.getReal() * second.getImaginary();
		return new ComplexNum(tempReal/denom, tempImaginary/denom);
	}

	public String toString() {
		return "" + real + " + " + imaginary + "i";
	}

	/* Extends Number */
	@Override
	public int intValue() {
		return (int)real;
	}

	@Override
	public long longValue() {
		return (long)real;
	}

	@Override
	public float floatValue() {
		return (float)real;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return real;
	}

}
