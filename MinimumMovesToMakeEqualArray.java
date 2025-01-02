class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int median;
        if(n%2==1)
        {
            median = nums[n/2];
        }
        else
        {
            median = nums[(n/2)-1];
        }
        int minmoves = 0;

        for(int i=0;i<n;i++)
        {
            minmoves += Math.abs(median - nums[i]);
        }

        return minmoves;
    }
}
