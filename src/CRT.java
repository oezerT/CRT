import java.math.BigInteger;

/**
 * Created by oezert on 08/12/2016.
 */
public class CRT {

    BigInteger p;
    BigInteger q;
    final BigInteger ONE = BigInteger.ONE;

    public CRT(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
    }

    public BigInteger pow(BigInteger basis, BigInteger exponent) {
    	long startTime = System.nanoTime();    

    	BigInteger a = basis.modPow(exponent.mod(p.subtract(ONE)), p);
    	BigInteger b = basis.modPow(exponent.mod(q.subtract(ONE)), q);
    	BigInteger[] eGCDResult = ExtendedGreatestCommonDivisor.run(p,q);
		BigInteger z =  eGCDResult[1];
		BigInteger diff = a.subtract(b);
		BigInteger v = (diff.multiply(z)).mod(p);
		BigInteger x =  (v.multiply(q)).add(b);
		long elapsedTime = System.nanoTime() - startTime;    
		System.out.println("CRT-Time: " + elapsedTime);
        return x;
    }
}
