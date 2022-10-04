
import java.util.Arrays;
import java.lang.Math;
import java.util.List;
import java.lang.CharSequence;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.*;

public class Polynomial {
	public double[] coefficients;
	public int[] exponents;
	
	public Polynomial() {
		coefficients = new double[] {0};
		exponents = new int[] {0};
		}
	
	public Polynomial(double[] coeff, int[] expo) {
		coefficients = new double[coeff.length];
		exponents = new int [expo.length];
		for(int i=0; i<coeff.length; i++)
			coefficients[i] = coeff[i];
		for(int i=0; i<expo.length; i++)
			exponents[i] = expo[i];
		}
	
	public int find(int value, int[] given) {
		for(int j=0; j<given.length; j++) {
			if(value == given[j])
				return j;
			}
		return -10;
		}
	
	public Polynomial add(Polynomial poly2) {
		double[] newCoeff = new double[coefficients.length + poly2.coefficients.length];
		int[] newExpo = new int[exponents.length + poly2.exponents.length];
		int len=0;
		for(int i=0; i<exponents.length; i++) {
			int j = find(exponents[i], poly2.exponents);
			if(j != -10) {
				newExpo[len] = exponents[i];
				newCoeff[len] = coefficients[i] + poly2.coefficients[j];
				len++;
				}
			else {
				newExpo[len] = exponents[i];
				newCoeff[len] = coefficients[i];
				len++;
				}
			}
		for(int k=0; k<poly2.exponents.length; k++) {
			if(find(poly2.exponents[k], newExpo) == -10) {
				newCoeff[len] = poly2.coefficients[k];
				newExpo[len] = poly2.exponents[k];
				len++;
				}
			}
		return new Polynomial(newCoeff, newExpo);
		}
	
	public double evaluate(double x) {
		double result = 0.0;
		for(int i=0; i<coefficients.length; i++)
			result += coefficients[i]*Math.pow(x, exponents[i]);
		return result;
		}
	
	public boolean hasRoot(double check) {
		if(Math.abs(evaluate(check)) < Math.pow(10,  -10))
			return true;
		else
			return false;
		}
	
	public Polynomial multiply (Polynomial poly2) {
		double[] newCoeff = new double[coefficients.length * poly2.coefficients.length];
		int[] newExpo = new int[exponents.length * poly2.exponents.length];
		int len=0;
		for(int i=0; i<exponents.length; i++) {
			for(int j=0; j<poly2.exponents.length; j++) {
				int index = find(exponents[i]+poly2.exponents[j], newExpo);
				if(index == -10) {
					newExpo[len] = exponents[i]+poly2.exponents[j];
					newCoeff[len] = coefficients[i]*poly2.coefficients[j];
					len++;
					}
				else
					newCoeff[index] = newCoeff[index]+(coefficients[i]*poly2.coefficients[j]);
				}
			}
		return new Polynomial(newCoeff, newExpo);
		}
	
	public Polynomial(File file) throws IOException {
        Scanner scan = new Scanner(file);
        String me2 = new String("");
        me2 = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<me2.length(); i++) {
        	if(i != 0 && me2.charAt(i) == '-')
        		sb.append('+');
        	sb.append(me2.charAt(i));
        	if((me2.charAt(i) == '-' || me2.charAt(i) == '+') && me2.charAt(i+1) =='x')
    			sb.append('1');
        	if((me2.charAt(i) == 'x') && (me2.charAt(i+1) == '+' || me2.charAt(i+1) == '-'))
        			sb.append('1');
        	}
        me2 = sb.toString();
        String[] me3 = me2.split("[+]");
        coefficients = new double[me3.length];
        exponents = new int[me3.length];
        for(int i=0; i<me3.length; i++) {
        	if(me3[i].contains("x")) {
        		String[] me4 = me3[i].split("[x]");
        		coefficients[i] = Double.parseDouble(me4[0]);
        		exponents[i] = Integer.parseInt(me4[1]);
        		}
        	else {
        		coefficients[i] = Double.parseDouble(me3[i]);
        		exponents[i] = 0;
        		}
        	}
        }
	
	public void saveToFile(String toPoly) throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<coefficients.length; i++) {
			sb.append(String.valueOf(coefficients[i]));
			sb.append('x');
			if(exponents[i] != 0)
				sb.append(String.valueOf(exponents[i]));
			if(i+1<coefficients.length && coefficients[i+1] >= Math.pow(10, -10))
				sb.append('+');
			}
		String to_file = sb.toString();
		try(PrintStream ps = new PrintStream(toPoly)){
			ps.println(to_file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
	}

