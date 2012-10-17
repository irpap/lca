public class LowestCommonAncestorRecurse {
    Node lowestCommonAnestor(Node tree, int val1, int val2) {
        if (!containsBoth(tree, val1, val2)) return null;
        //If a node contains both values, but none of its children contain both values, then that's the lca.
        if (!containsBoth(tree.left, val1, val2) && !containsBoth(tree.right, val1, val2)) return tree;

        Node lcaLeft = lowestCommonAnestor(tree.left, val1, val2);
        Node lcaRight = lowestCommonAnestor(tree.right, val1, val2);
        return lcaLeft != null ? lcaLeft : lcaRight;
    }

    boolean contains(Node tree, int val) {
        if (tree == null) return false;
        if (tree.val == val) return true;
        return contains(tree.right, val) || contains(tree.left, val);
    }

    boolean containsBoth(Node tree, int val1, int val2) {
        return contains(tree, val1) && contains(tree, val2);
    }

}
