class JumpGame {
    // My solution - passes 73/75 test cases. Times out on last 2 cases.
    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int[] copy_nums = new int[len];
        for(int i=0; i<len; i++){
            if(i!=0){
                if(copy_nums[i]==0){// if we cant get to index i
                    return false;
                }
            }
            for(int j=i; j<=i+nums[i]; j++){
                if(j>=len){
                    break;
                }
                copy_nums[j] = 1;// mark ability to reach index
            }
        }
        if(copy_nums[len-1] == 0){
            return false;
        }
        else{
            return true;
        }
    }

    // Accepted solution
    public boolean canJump2(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable){
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}