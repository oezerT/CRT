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
    static final BigInteger ONE = BigInteger.ONE;

    public static void main(String[] args) {
    	p = BigInteger.valueOf(101);
    	q = BigInteger.valueOf(103);
    	n = p.multiply(q);
    	x = BigInteger.valueOf(500);
    	y = BigInteger.valueOf(3000);

        BigInteger[] eGCDResult = ExtendedGreatestCommonDivisor.run(q,p);


        CRT crt = new CRT(p, q, eGCDResult[1]);
        System.out.println("CRT-Result: " + crt.pow(x,y));
		long startTime = System.nanoTime();    
        System.out.println("ModPow-Result: " + x.modPow(y, n));
		long elapsedTime = System.nanoTime() - startTime; 
		System.out.println("ModPow-Time: " +elapsedTime);

        //runtimeTest
		int amount = 100;
		BigInteger[] randomValuesX = createArrayOfRandomBigInt(amount, n.subtract(ONE));
        BigInteger[] randomValuesY = createArrayOfRandomBigInt(amount, n.subtract(ONE));
        System.out.println("n-1: " + n.subtract(ONE));

        long powMeanTime = calcMeanRuntimeForPow(randomValuesX, randomValuesY, crt);
        long modPowMeanTime = calcMeanRuntimeForModPow(randomValuesX, randomValuesY);
        System.out.println("CRT.pow mean time: " + powMeanTime + "ns\n");
        System.out.println("ModPow mean time: " + modPowMeanTime + "ns\n");

        System.out.println("relative time: " + (double)(powMeanTime)/(double)(modPowMeanTime) + "ns");
    }

    static long calcMeanRuntimeForPow(BigInteger[] randomValuesX, BigInteger[] randomValuesY, CRT crt) {
        long[] times = new long[randomValuesX.length];
        for (int i = 0; i < randomValuesX.length; i++) {
            times[i] = calcPowTime(crt, randomValuesX[i], randomValuesY[i]);
            System.out.println("time for " + randomValuesX[i] + " ^ " + randomValuesY[i] + " = " + times[i] + "ns");
        }
        return calcMean(times);
    }

    static long calcMeanRuntimeForModPow(BigInteger[] randomValuesX, BigInteger[] randomValuesY) {
        long[] times = new long[randomValuesX.length];
        for (int i = 0; i < randomValuesX.length; i++) {
            times[i] = calcModPowTime(randomValuesX[i], randomValuesY[i]);
            System.out.println("time for " + randomValuesX[i] + " ^ " + randomValuesY[i] + " = " + times[i] + "ns");
        }
        return calcMean(times);
    }

    static long calcPowTime(CRT crt, BigInteger x, BigInteger y) {
        long startTime = System.nanoTime();
        crt.pow(x, y);
        return System.nanoTime() - startTime;
    }

    static long calcModPowTime(BigInteger x, BigInteger y) {
        long startTime = System.nanoTime();
        x.modPow(y, n);
        return System.nanoTime() - startTime;
    }

    static long calcMean(long[] times) {
        long i = 0;
        for (long time : times)
            i += time;
        return i/times.length;
    }

    static BigInteger[] createArrayOfRandomBigInt(int size, BigInteger maxValue) {
        BigInteger[] bigIntegers = new BigInteger[size];
        for (int i = 0; i < size; i++)
            bigIntegers[i] = randomBigint(maxValue);
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
