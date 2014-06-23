package algorithms.interviewQuestions.fibonacciSequence;

import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        assert fib(0) == 0;
        assert fibV2(0) == 0;
        assert fibIter(0) == 0;
        assert fib(1) == 1;
        assert fibV2(1) == 1;
        assert fibIter(1) == 1;
        assert fib(4) == 3;
        assert fibV2(4) == 3;
        assert fibIter(4) == 3;
        assert fib(10) == 55;
        assert fibV2(10) == 55;
        assert fibIter(10) == 55;
        assert fib(20) == 6765;
        assert fibV2(20) == 6765;
        assert fibIter(20) == 6765;
        
        System.out.println("Tests passed");
    }
    
    public static int fib(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n much be >= 0");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
            
        return fib(n - 1) + fib(n - 2);
    }
  
    public static int fibV2(int n) {
        return fibV2(n, new HashMap<Integer, Integer>());
    }
    
    private static int fibV2(int n, HashMap<Integer, Integer> hash) {
        if (n < 0)
            throw new IllegalArgumentException("n much be >= 0");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (hash.containsKey(n))
            return hash.get(n);
        
        int value = fibV2(n - 1, hash) + fibV2(n - 2, hash);
        hash.put(n, value);
        return value;
    }
  
    public static int fibIter(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n much be >= 0");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        
        int first = 0;
        int second = 1;
        int counter = 1;
        int temp;
        
        while (counter < n) {
            temp = first;
            first = second;
            second = temp + first;
            counter++;
        }
        
        return second;
    }
}