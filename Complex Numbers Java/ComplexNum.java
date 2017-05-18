
public class ComplexNum {
	
	private double real;
	private double imaginary;
	
	public ComplexNum(double a, double b) {
		real = a;
		imaginary = b;
	}
	
	public ComplexNum(double a) {
		this(a, 0.0);
	}
	
	public ComplexNum() {
		this(0.0);
	}
	
	public double getReal() {
		return real;
	}
	
	private void setReal(double a) {
		real = a;
	}
	
	public double getImaginary() {
		return imaginary;
	}
	
	private void setImagianry(double b) {
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

}
