/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true){
		    int choice, n;
		    double rate, payment, bond;
		    System.out.print("1.Get future value\n2.Get present value\n3.Get bond\nPick you choice: ");
		    choice = scanner.nextInt();
		    
            if(choice==3){
                System.out.print("Enter market rate: ");
                rate = scanner.nextDouble();
                System.out.print("Enter bond rate: ");
                double bondRate = scanner.nextDouble();
                System.out.print("Enter period: ");
                n = scanner.nextInt();
                System.out.print("Enter bond value: ");
                bond = scanner.nextDouble();
                payment = bondRate / 100 * bond;
                System.out.println(getBond(rate,n,payment,bond));
                System.out.println();
                continue;
            } 

            System.out.print("Enter rate: ");
            rate = scanner.nextDouble();
            System.out.print("Enter period: ");
            n = scanner.nextInt();
            System.out.print("Enter payment amount: ");
            payment = scanner.nextDouble();
            System.out.print("Enter bond value: ");
            bond = scanner.nextDouble();
            
            if(choice==1) System.out.println(getFuture(rate,n,payment));
            if(choice==2) System.out.println(getPV(rate,n,payment));
            System.out.println("");
		}
	}
	
	public static double getBond(double r, int n, double payment, double bond){
	    r /= 100;
	    double bondPV = bond / Math.pow((1+r),n);
	   // System.out.println(bondPV + "\n" + getPV(r*100,n,payment));
	    return bondPV + getPV(r*100,n,payment);
	}
	
	public static double getFuture(double r, int n, double payment){
	    r /= 100; 
	    return (1+r)*(Math.pow((1+r),n)-1) / r * payment;
	}
	
	public static double getPV(double r, int n, double payment){
	    r /= 100;
	    return (1-1/(Math.pow((1+r),n))) / r * payment;
	}
	
}
