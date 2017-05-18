)
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ComplexNum first = new ComplexNum(4.0, 5.0);
		ComplexNum second = new ComplexNum(2.0, 1.0);
		ComplexNum third = first.add(second);
		System.out.println(third.toString());
		
		/****************************************/
		
		ComplexNum x = new ComplexNum(2.0, -4.0);
		ComplexNum y = new ComplexNum(4.0, 0.0);
		ComplexNum z = new ComplexNum(0.0, 3.0);
		
		System.out.println("(X + Z) -> " + x.add(z));
		System.out.println("(X/Y + Z) -> " + (x.divide(y)).add(z));
	}

}
