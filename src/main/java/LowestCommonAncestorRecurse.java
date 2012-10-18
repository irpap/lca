import java.util.Arrays;

public class LowestCommonAncestorRecurse {
    Node lowestCommonAnestor (Node tree, int val1, int val2) {
        if (!containsBoth(tree, val1, val2)) { return null; }
        Node lcaLeft = lowestCommonAnestor(tree.left, val1, val2);
        Node lcaRight = lowestCommonAnestor(tree.right, val1, val2);
        //If a node contains both values, but none of its children contain both values, then that's the lca.
        if (lcaLeft == null && lcaRight == null) { return tree; }
        return lcaLeft != null ? lcaLeft : lcaRight;
    }

    boolean containsBoth (Node tree, int val1, int val2) {
        return Arrays.equals(containsBothHelper(tree, val1, val2), new boolean[]{true, true});
    }

    private boolean[] containsBothHelper (final Node tree, final int val1, final int val2) {
        if (tree == null) { return new boolean[]{false, false}; }

        boolean[] leftContainsBoth = containsBothHelper(tree.left, val1, val2);
        boolean[] rightContainsBoth = containsBothHelper(tree.right, val1, val2);

        return new boolean[]{tree.val == val1 || leftContainsBoth[0] || rightContainsBoth[0],
                tree.val == val2 || leftContainsBoth[1] || rightContainsBoth[1]};
    }
}
