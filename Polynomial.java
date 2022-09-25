
import java.util.Arrays;
import java.lang.Math;

public class Polynomial {
	public double[] coefficients;
	
	public Polynomial() {
		coefficients = new double[] {0};
	}
	
	public Polynomial(double[] input) {
		coefficients = new double[input.length];
		for(int i=0; i<input.length; i++)
			coefficients[i] = input[i];
	}
	
	public Polynomial add(Polynomial poly2) {
		double[] coefficient2 = poly2.coefficients;
		int large, small;
		if(coefficients.length > coefficient2.length) {
			large = coefficients.length;
			small = coefficient2.length;
		}
		else {
			large = coefficient2.length;
			small = coefficients.length;
		}
		double[] sum = new double[large];
		for(int i=0; i<small; i++)
			sum[i] = coefficients[i] + coefficient2[i];
 		if(large != small && large == coefficients.length) {
			for(int i=small; i<large; i++)
				sum[i] = coefficients[i];
		}
		else {
			for(int i=small; i<large; i++)
				sum[i] = coefficient2[i];
		}
		return new Polynomial(sum);
	}
	
	public double evaluate(double x) {
		double result = 0.0;
		for(int i=0; i<coefficients.length; i++)
			result += coefficients[i]*Math.pow(x, i);
		return result;
	}
	
	public boolean hasRoot(double check) {
		if(Math.abs(evaluate(check)) < Math.pow(10, -10))
			return true;
		else
			return false;
	}
}