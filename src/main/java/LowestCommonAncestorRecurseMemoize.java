import java.util.HashMap;

public class LowestCommonAncestorRecurseMemoize {

    HashMap<Node, HashMap<Integer, Boolean>> memo = new HashMap<Node, HashMap<Integer, Boolean>>();

    Node lowestCommonAnestor(Node tree, int val1, int val2) {
        if (!containsBoth(tree, val1, val2)) return null;
        if (!containsBoth(tree.right, val1, val2) && !containsBoth(tree.left, val1, val2)) return tree;

        Node lcaLeft = lowestCommonAnestor(tree.left, val1, val2);
        Node lcaRight = lowestCommonAnestor(tree.right, val1, val2);

        return lcaLeft != null ? lcaLeft : lcaRight;
    }

    boolean contains(Node tree, int val) {
        if (tree == null) {
            saveToMemo(tree, val, false);
            return false;
        }
        if (tree.val == val) {
            saveToMemo(tree, val, true);
            return true;
        }

        boolean containsLeft = (getFromMemo(tree.left, val) != null) ? getFromMemo(tree.left, val) : contains(tree.left, val);
        boolean containsRight = (getFromMemo(tree.right, val) != null) ? getFromMemo(tree.right, val) : contains(tree.right, val);

        return containsRight || containsLeft;
    }

    void saveToMemo(Node tree, int val, boolean isContained) {
        if (memo.get(tree) == null) {
            HashMap<Integer, Boolean> entry = new HashMap<Integer, Boolean>();
            memo.put(tree, entry);
        }
        memo.get(tree).put(val, isContained);
    }

    Boolean getFromMemo(Node node, int val) {
        if (memo.get(node) == null) return null;
        return memo.get(node).get(val);
    }

    boolean containsBoth(Node tree, int val1, int val2) {
        return contains(tree, val1) && contains(tree, val2);
    }
}
