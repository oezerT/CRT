import java.math.BigInteger;

public class ExtendedGreatestCommonDivisor {
	
	public static BigInteger[] run(BigInteger a, BigInteger b) {
		BigInteger result[] = new BigInteger[3];
		
		if (a.compareTo(BigInteger.valueOf(0)) == 0 || b.compareTo(BigInteger.valueOf(0)) == 0 ) {
			throw new IllegalArgumentException("One of the numbers is 0");
		} 
		else {
			a = a.abs();
			b = b.abs();
			
			BigInteger c = a;
			BigInteger d = b;
			
			BigInteger uc = BigInteger.ONE;
			BigInteger vc = BigInteger.ZERO;
			BigInteger ud = BigInteger.ZERO;
			BigInteger vd = BigInteger.ONE;
			
			while (c.compareTo(BigInteger.ZERO) != 0) {
				BigInteger q = d.divide(c);
				BigInteger remainder = d.subtract(q.multiply(c));
				d = c;
				c = remainder;
				
				BigInteger oldUc = uc;
				BigInteger oldVc = vc;
				BigInteger oldUd = ud;
				BigInteger oldVd = vd;
				uc = oldUd.subtract(q.multiply(oldUc));
				vc = oldVd.subtract(q.multiply(oldVc));
				ud = oldUc;
				vd = oldVc;
				result[0] = d;
				result[1] = ud;
				result[2] = vd;
			}
			return result;
		}
	}
}
