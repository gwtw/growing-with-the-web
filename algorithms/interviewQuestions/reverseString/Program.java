package algorithms.interviewQuestions.reverseString;

public class Program {
	public static void main(String[] args) {
		assert reverse1("abc123def").equals("fed321cba");
		assert reverse2("abc123def").equals("fed321cba");
		assert reverse3("abc123def").equals("fed321cba");
		assert reverse1("abcd1234").equals("4321dcba");
		assert reverse2("abcd1234").equals("4321dcba");
		assert reverse3("abcd1234").equals("4321dcba");
		
		System.out.println("Tests passed");
	}
	
	public static String reverse1(String text) {
	    char[] charArray = text.toCharArray();
	    int start = -1;
	    int end = charArray.length;
	    while (++start < --end) {
	        char temp = charArray[start]; 
	        charArray[start] = charArray[end];
	        charArray[end] = temp;
	    }
	    return String.valueOf(charArray);
	}
	
	public static String reverse2(String text) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = text.length() - 1; i >= 0; i--) {
	        sb.append(text.charAt(i));
	    }
	    return sb.toString();
	}
		
	public static String reverse3(String text) {
		return new StringBuilder(text).reverse().toString();
	}
}
