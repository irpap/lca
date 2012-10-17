public class Node {
    final int val;
    final Node left;
    final Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static Node leaf(int val) {
        return new Node(val, null, null);
    }

    public String toString() {
        return String.valueOf(val);
    }
}
