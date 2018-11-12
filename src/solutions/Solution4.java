package solutions;

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int mid = length / 2 + 1;
        Integer[] result = new Integer[(length + 1) % 2 + 1];

        int i = 0, j = 0, k = 0;
        while (k < mid) {
            if (j == nums2.length || (i != nums1.length && nums1[i] < nums2[j])) {
                result[k++ % result.length] = nums1[i++];
            } else {
                result[k++ % result.length] = nums2[j++];
            }
        }

        return (result.length == 2) ? ((result[0] + result[1]) / 2.0) : result[0];
    }
}