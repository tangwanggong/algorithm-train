package day25;

/**
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * @date 2022/4/20
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0,sum = 0;
        for(int weight:weights){
            max = Math.max(max,weight);
            sum += weight;
        }
        int left = max,right = sum;
        while(left < right ){
            int mid = left + (right-left)/2;
            if(helper(weights,mid) > days){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    private int helper(int[] weights,int speed){
        int days = 0;
        for(int i=0;i<weights.length;){
            int cap = speed;
            while(i < weights.length){
                if(cap<weights[i]){
                    break;
                }else{
                    cap -= weights[i];
                    i++;
                }
            }
            days++;
        }
        return days;
    }
}
