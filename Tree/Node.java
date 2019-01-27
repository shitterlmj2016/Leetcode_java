import java.util.List;

/**
 * This is a comment!
 *
 * @class: Node
 * @description: // Definition for a Node.
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 10:34
 **/
//这个是给普通树，非二叉树用的
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
