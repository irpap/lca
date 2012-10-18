import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LowestCommonAncestorTest {
    Node tree = new Node(5, new Node(2, new Node(35, Node.leaf(9), Node.leaf(4)), new Node(17, Node.leaf(73), Node.leaf(29))),
            new Node(8, new Node(1, Node.leaf(23), Node.leaf(12)), new Node(6, Node.leaf(37), Node.leaf(13))));

    //                5
    //            /      \
    //           /         \
    //        2                8
    //       /   \           /    \
    //       35     17      1         6
    //      /  \    / \    /  \      / \
    //     9    4  73  29  23   12  37  13

    @Test
    public void testDFS () {
        assertThat(LowestCommonAncestorDFS.lowestCommonAncestor(tree, 1, 13).val).isEqualTo(8);
        assertThat(LowestCommonAncestorDFS.lowestCommonAncestor(tree, 1, 1000)).isEqualTo(null);
        assertThat(LowestCommonAncestorDFS.lowestCommonAncestor(tree, 5, 1).val).isEqualTo(5);
    }

    @Test
    public void testBFS () {
        LowestCommonAncestorBFS lca = new LowestCommonAncestorBFS();
        assertThat(lca.lowestCommonAnestor(tree, 1, 13)).isEqualTo(8);
        assertThat(lca.lowestCommonAnestor(tree, 35, 17)).isEqualTo(2);
        assertThat(lca.lowestCommonAnestor(tree, 2, 12)).isEqualTo(5);
        assertThat(lca.lowestCommonAnestor(tree, 2, 1000)).isEqualTo(null);
        assertThat(lca.lowestCommonAnestor(tree, 5, 1)).isEqualTo(5);
    }

    @Test
    public void testRecurse () {
        LowestCommonAncestorRecurse lca = new LowestCommonAncestorRecurse();
        assertThat(lca.lowestCommonAnestor(tree, 1, 13).val).isEqualTo(8);
        assertThat(lca.lowestCommonAnestor(tree, 35, 17).val).isEqualTo(2);
        assertThat(lca.lowestCommonAnestor(tree, 2, 12).val).isEqualTo(5);
        assertThat(lca.lowestCommonAnestor(tree, 2, 1000)).isEqualTo(null);
        assertThat(lca.lowestCommonAnestor(tree, 5, 1).val).isEqualTo(5);
    }
}
