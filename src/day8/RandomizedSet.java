package day8;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * @date 2022/2/17
 */
class RandomizedSet {
    // list用来存储数据
    private List<Integer> list = new ArrayList<>();
    // map用来做索引,以及判断有无val
    private Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        // 获取需要删除的索引
        int index = map.get(val);
        // 获取最后添加的val和需要删除的索引值换位
        int last = list.get(list.size()-1);
        list.set(index,last);
        // 更新索引
        map.put(last,index);
        list.remove(list.size()-1);
        // 删除val的索引
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
