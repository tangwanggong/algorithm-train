package day3;

/**
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] helper = new int[n];
        // 差分数组: helper[i] 代表第i个元素-前i-1个元素的和
        for (int i = 0; i < bookings.length; i++) {
            // l:起始,r:结束,c:订票数量
            int l = bookings[i][0],r = bookings[i][1],c = bookings[i][2];
            // 代表 l-1 开始的元素增加订票数量 c
            helper[l-1] += c;
            if(r < n){
                // 为了消除上面对后面所有元素的影响,从第r个元素开始减去影响
                helper[r] -= c;
            }
        }
        int[] result = new int[n];
        result[0] = helper[0];
        for (int i = 1; i < helper.length; i++) {
            // 返回结果
            result[i] = result[i-1] + helper[i];
        }
        return result;
    }

}
