import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: UndirectedGraphNode
 * @description: UndirectedGraphNode
 * @author: Xincheng Huang - xinchenh
 * @create: 02-05-2019 21:07
 **/
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
