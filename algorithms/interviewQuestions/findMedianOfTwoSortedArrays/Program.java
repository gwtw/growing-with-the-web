package algorithms.interviewQuestions.findMedianOfTwoSortedArrays;

public class Program {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {3, 4, 5, 6, 7};

        System.out.println(findMedian(a, b));

        System.out.println("Tests passed");
    }
    
    public static float findMedian(int[] list1, int[] list2) {
        if (list1.length != list2.length) {
            throw new IllegalArgumentException("list1 and list2 need to be the same size");
        }
        int size = list1.length;
        int move = size / 2;
        int position1 = move;
        int position2 = size - move; // so we're searching the same length

        if (list1[position1] == list2[position2])
            return list1[position1];

        boolean isSignGreater = list1[position1] > list2[position2];
        int last1 = 0;
        int last2 = 0;

// Problem: Can't just check if signs flip, need to see if they flip twice


        while (isSignGreater == list1[position1] > list2[position2] &&
               list1[position1] != list2[position2]) {
            last1 = list1[position1];
            last2 = list2[position2];
            if (isSignGreater) {
                move = position1 / 2;
                position1 -= move;
                position2 += move;
            } else {
                move = (position2) / 2;
                position1 += move;
                position2 -= move;
            }
        }

        if (list1[position1] == list2[position2])
            return list1[position1];
        return (float)(last1 + last2) * 2;
    }
}
