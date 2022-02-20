package day10;

import structure.Node;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        // 处理左右子节点
        connectTwoNode(root.left,root.right);
        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        if(left == null){
            return;
        }
        // 左节点的下个是右节点
        left.next = right;
        // 处理左右节点下的左右节点
        connectTwoNode(left.left,left.right);
        connectTwoNode(right.left,right.right);

        // 单独处理左节点下的右子节点和右节点的下的左子节点
        connectTwoNode(left.right,right.left);
    }
}
