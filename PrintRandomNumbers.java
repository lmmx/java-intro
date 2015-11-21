import java.io.*;
// for anything more serious use:
import java.math.*;

/*
 * rounding numbers with Math.round can fail, so switched to it
 * (old Math.round code still here commented out)
 *
 * see discussion at:
 * http://stackoverflow.com/q/153724/2668831
 * 
 * More details on BigDecimal for rounding at:
 * via http://www.javaworld.com/article/2075315/core-java/make-cents-with-bigdecimal.html
*/

import java.util.Random;

public class PrintRandomNumbers {
	// the class declaration is public meaning accessible to other classes
	// private is used when hiding the internals e.g. in an API
	public static void main(String[] args) {
		int num_dp = 1; // number of decimal places
		double min = 0.1; // set the minimum value for RNG
		// this is added to zero as nextFloat's minimum (inclusive minimum)
		double max = 3.0; // set maximum value for RNG
		double scale = max - min;
		// increment (after scaling) because nextInt's maximum is exclusive
		System.out.print("The random numbers are: ");
		int i;
		for (i=0; i<=100; i++) {
			Random random = new Random();
			// scale while zero-based (so it remains zero-based)
			// then increment by minimum value (so becomes minimum value-based)
			double size_scaled = (random.nextDouble() * scale) + min;
 	 		BigDecimal size_scaled_dec = new BigDecimal(size_scaled);
  			size_scaled_dec = size_scaled_dec.setScale(num_dp, BigDecimal.ROUND_HALF_UP);
  	//		size_scaled = Math.round(size_scaled*10)/10.0d;
			if (i<100) {
				//System.out.print(size_scaled + ", ");
				System.out.print(size_scaled_dec.toString() + ", ");

			} else {
				//System.out.println("and " + size_scaled + ".");
				System.out.println("and " + size_scaled_dec.toString() + ".");
			}
		}
	}
}

