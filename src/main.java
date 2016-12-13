import java.math.BigInteger;

/**
 * Created by oezert on 08/12/2016.
 */
public class main {
	
	static BigInteger p;
	static BigInteger q;
	static BigInteger n;
	static BigInteger x;
	static BigInteger y;
	
    public static void main(String[] args) {
    	p = BigInteger.valueOf(101);
    	q = BigInteger.valueOf(103);
    	n = p.multiply(q);
    	x = BigInteger.valueOf(500);
    	y = BigInteger.valueOf(3000);
    	
        CRT crt = new CRT(p, q);
        System.out.println("CRT-Result: " + crt.pow(x,y));
		long startTime = System.nanoTime();    
        System.out.println("ModPow-Result: " + x.modPow(y, n));
		long elapsedTime = System.nanoTime() - startTime; 
		System.out.println("ModPow-Time: " +elapsedTime);

    }
}
