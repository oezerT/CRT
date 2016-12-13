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
        System.out.println(crt.pow(x,y));
        System.out.println(x.modPow(y, n));
    }
}
