package structure;


/**

 * @create: 2018/9/14 9:53
 **/
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
       return String.valueOf(val);
    }
}
