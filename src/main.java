import java.math.BigInteger;
import java.util.Random;

/**
 * Created by oezert on 08/12/2016.
 */
public class main {
	
	static BigInteger p;
	static BigInteger q;
	static BigInteger n;
	static BigInteger x;
	static BigInteger y;
	static final BigInteger TWO = BigInteger.valueOf(2);

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


		/*BigInteger[] newArray = createArrayOfRandomBigInt(5, p);
        System.out.println(newArray.length);
        for (BigInteger value:newArray) {
            System.out.println(value);
        }*/
    }

    static BigInteger[] createArrayOfRandomBigInt(int size, BigInteger maxValue) {
        BigInteger[] bigIntegers = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegers[i] = randomBigint(maxValue);
        }
        return bigIntegers;
    }

	static BigInteger randomBigint(BigInteger max) {
		Random randomGenerator = new Random();
		BigInteger result;
		do {
			result = new BigInteger(max.bitLength(), randomGenerator);
		} while (!(result.compareTo(TWO) >= 0 && result.compareTo(max) <= 0));
		return result;
	}
}
