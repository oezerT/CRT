import java.math.BigInteger;

/**
 * Created by oezert on 08/12/2016.
 */
public class main {
    public static void main(String[] args) {
        CRT crt = new CRT(BigInteger.valueOf(101), BigInteger.valueOf(103));
        BigInteger result = crt.pow(BigInteger.valueOf(500), BigInteger.valueOf(3000));
        System.out.println(result);
    }
}
