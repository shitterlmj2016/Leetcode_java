import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: NaryTreePostorderTraversal
 * @description: 590. N-ary Tree Postorder Traversal
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 10:36
 **/
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        help(res, root);
        return res;
    }

    private void help(List<Integer> res, Node node) {
        if (node == null)
            return;
        for (int i = 0; i < node.children.size(); i++) {
            help(res, node.children.get(i));
        }
        res.add(node.val);
    }
}
