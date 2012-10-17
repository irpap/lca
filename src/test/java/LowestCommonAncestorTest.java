import org.fest.assertions.Assertions;
import org.junit.Test;

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
    public void testDFS() {
        Node lca = LowestCommonAncestorDFS.lowestCommonAncestor(tree, 1, 13);
        Assertions.assertThat(lca.val).isEqualTo(8);

    }

    @Test
    public void testBFS() {
        LowestCommonAncestorBFS lowestCommonAncestorBFS = new LowestCommonAncestorBFS();
        Integer lca = lowestCommonAncestorBFS.lowestCommonAnestor(tree, 1, 13);
        Assertions.assertThat(lca).isEqualTo(8);
    }

    @Test
    public void testRecurse() {
        LowestCommonAncestorRecurse lcaRec = new LowestCommonAncestorRecurse();
        Node lca = lcaRec.lowestCommonAnestor(tree, 1, 13);
        Assertions.assertThat(lca.val).isEqualTo(8);
    }
    @Test
    public void testRecurseMemo() {
        LowestCommonAncestorRecurseMemoize lcaRecMemo = new LowestCommonAncestorRecurseMemoize();
        Node lca = lcaRecMemo.lowestCommonAnestor(tree, 1, 13);
        Assertions.assertThat(lca.val).isEqualTo(8);
    }

}
