class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        // binary search
        int minCapacity = right;
        while (left <= right) {
            // need to check if mid weight will process all array under 4 days
            int mid = (left + right) / 2;
            if (canShip(weights, days, mid)) {
                minCapacity = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minCapacity;
    }


    private boolean canShip(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > capacity) {
                daysUsed++;
                sum = weight;
            } else {
                sum += weight;
            }
        }

        return daysUsed <= days;
    }

}