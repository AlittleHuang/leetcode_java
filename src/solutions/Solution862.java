package solutions;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution862 {


    private static final Solution862 SOLUTION = new Solution862();

    public static void main(String[] args) {
        //[-28,81,-20,28,-29]
        //89
        int[] a = {-28, 81, -20, 28, -29};
        int k = 89;
        System.out.println(SOLUTION.shortestSubarray(a, k));
//        test();
    }

    class Node implements Comparable<Node> {
        int i;
        int v;

        public Node(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return v - o.v;
        }

    }


    public int shortestSubarray(int[] A, int K) {
        int length = A.length;
        Node[] sums = new Node[length];
        int result = length;

        int sum = 0, min = A[0], lo = 0;
        SortedSet<Node> set = new TreeSet<>(Node::compareTo);

        for (int hi = 1; hi <= A.length; hi++) {
            int a = A[hi - 1];
            if (a >= K) return 1;
            sums[hi] = new Node(hi, a);
            set.add(sums[hi]);
            if (sum < min) {
                lo = hi;
            }

            int i = lo;
            if (sum - min >= K) {
                for (i = lo + 1; i < hi; i++) {
                    if (sums[i].v <= sum - K) {
                        result = hi - i;
                    }
                }
            }
            for (; lo < i; lo++) {
                set.remove(sums[lo]);
            }
            min = set.first().v;
            lo = set.first().i;
        }


        return result;
    }

    private static void test() {
        int length = 100000;
        int[] A = new int[length];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < length; j++) {
                A[j] = random.nextInt(1000000) - 500000;
            }
            long time = System.currentTimeMillis();
            int result = SOLUTION.shortestSubarray(A, 10000000);
            System.out.println(result + "-->time:" + (System.currentTimeMillis() - time));

        }
    }


}
