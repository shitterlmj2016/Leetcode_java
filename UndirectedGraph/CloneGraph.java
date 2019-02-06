import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: CloneGraph
 * @description: Clone Graph
 * @author: Xincheng Huang - xinchenh
 * @create: 02-05-2019 21:09
 **/
public class CloneGraph {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }

    //DFS
    private UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbour : node.neighbors
        ) {
            UndirectedGraphNode copy = helper(neighbour);
            clone.neighbors.add(copy);
        }

        return clone;
    }
}
