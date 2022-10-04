import java.io.File;
import java.io.*;

public class Driver {
	public static void main(String [] args) throws IOException {
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6.5,5.2,-12.65,1};
		int [] e1 = {2,0,1,5};
		Polynomial p1 = new Polynomial(c1,e1);
		double [] c2 = {-2,-9.8889,2.2,3.3333,6.84,1};
		int [] e2 = {0,3,4,1,2,6};
		Polynomial p2 = new Polynomial(c2,e2);
		System.out.println(p1.evaluate(3));
		System.out.println(p2.evaluate(2));
		Polynomial s = p1.add(p2);
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(30.5))
			System.out.println("30.5 is a root of s");
		else
			System.out.println("30.5 is not a root of s");
		double[] c4 = {1,1};
		int [] e4 = {1,0};
		Polynomial p4 = new Polynomial(c4,e4);
		double[] c5 = {1,2,1};
		int[] e5 = {2,1,0};
		Polynomial p5 = new Polynomial(c5,e5);
		Polynomial pd = p4.multiply(p5);
		System.out.println("pd(12) = " + pd.evaluate(12));
		File file = new File("C:/Users/clare/text_poly.txt");
		Polynomial p3 = new Polynomial(file);
		System.out.println(p3.evaluate(1));
		Polynomial pd2 = p3.multiply(pd);
		System.out.println("pd2(4) = " + pd2.evaluate(4));
		p2.saveToFile("C:/Users/clare/toPoly.txt");
		}
	}