class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        for (int i = 0; i < product.length; i++) {
            product[i] = 1;
        }

        int prefix = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix *= nums[i-1];
            product[i] = prefix;
        }

        int postfix = 1;
        for (int i = product.length - 2; i >= 0; i--) {
            postfix *= nums[i + 1];
            product[i] *= postfix; 
        }

        return product;
    }
}  
