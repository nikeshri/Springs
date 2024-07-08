public class Main {

    public static int maxSumIS(int[] arr, int n) {
        int[] msis = new int[n];

        // Initialize msis values for all indexes
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
        }

        // Compute maximum sum values in bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        // Find maximum value in msis array
        int max = msis[0];
        for (int i = 1; i < n; i++) {
            if (msis[i] > max) {
                max = msis[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        int n = arr.length;
        System.out.println("Maximum Sum Increasing Subsequence is " + maxSumIS(arr, n));
    }
}
