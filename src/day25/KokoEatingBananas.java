package day25;

/**
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 * @date 2022/4/20
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile:piles){
            max = Math.max(max,pile);
        }
        int left = 1,right = max;
        while(left<right){
            int mid = left + (right-left)/2;
            if(helper(piles,mid) > h){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public int helper(int[] piles,int speed){
        int sum = 0;
        for(int pile:piles){
            sum += pile % speed == 0 ?pile / speed:(pile / speed)+1;
        }
        return sum;
    }
}
