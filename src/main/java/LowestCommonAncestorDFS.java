import com.google.common.collect.ImmutableList;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorDFS {
    public static Node lowestCommonAncestor(Node tree, int val1, int val2) {

        List<Node> path1 = pathFromRoot(tree, val1, new LinkedList<Node>());
        List<Node> path2 = pathFromRoot(tree, val2, new LinkedList<Node>());

        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1).val != path2.get(i + 1).val) return path1.get(i);
        }
        return null;
    }

    static List<Node> pathFromRoot(Node tree, int val, List<Node> path) {
        if (tree == null) return ImmutableList.of();
        ImmutableList<Node> extendedPath = ImmutableList.<Node>builder().addAll(path).add(tree).build();
        if (tree.val == val) return extendedPath;

        List<Node> leftPath = pathFromRoot(tree.left, val, extendedPath);
        List<Node> rightPath = pathFromRoot(tree.right, val, extendedPath);

        return (!leftPath.isEmpty()) ? leftPath : rightPath;
    }
}
