public class Program {
    public static void main(String[] args) {
        assert gcd(32, 6) == 2;
        assert gcd(108, 30) == 6;
        assert gcd(1000, 10) == 10;
        assert gcd(1000, 48) == 8;
        assert gcd(1452, 36) == 12;
        assert gcd(194239, 1261) == 12;
        
        System.out.println("Tests passed");
    }
    
    public static int gcd(int a, int b) {
        int dividend;
        int divisor = (a > b ? a : b);
        int quotient;
        int remainder = (a < b ? a : b);
        
        System.out.format("Find gcd(%d, %d)\n", a, b);

        do {
            dividend = divisor;
            divisor = remainder;

            quotient = dividend / divisor;
            remainder = dividend % divisor;

            System.out.format(
                "%d = %d x %d + %d\n", 
                dividend, divisor, quotient, remainder);
        } while (remainder != 0);

        System.out.format(
            "\ngcd(%d, %d) = %d\n\n",
            a, b, divisor);

        return divisor;
    }
}