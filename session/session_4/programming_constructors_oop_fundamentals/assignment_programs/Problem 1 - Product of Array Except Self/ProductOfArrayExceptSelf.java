public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] ans1 = productExceptSelf(nums1);
        System.out.print("[");
        for(int i=0; i<ans1.length; i++) System.out.print(ans1[i] + (i==ans1.length-1?"":", "));
        System.out.println("]");
        
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] ans2 = productExceptSelf(nums2);
        System.out.print("[");
        for(int i=0; i<ans2.length; i++) System.out.print(ans2[i] + (i==ans2.length-1?"":", "));
        System.out.println("]");
    }
}
