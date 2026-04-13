public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<String> nodeE = new BinaryTreeNode<>("e", null, null);
        BinaryTreeNode<String> nodeD = new BinaryTreeNode<>("d", null, null);
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("c", null, null);
        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("b", nodeD, nodeE);
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("a", nodeB, nodeC);

        BinaryTree<String> bt1 = new BinaryTree<>(5, nodeA);

        BinaryTreeNode<Double> node4 = new BinaryTreeNode<>(-9.3, null, null);
        BinaryTreeNode<Double> node3 = new BinaryTreeNode<>(2.9, null, null);
        BinaryTreeNode<Double> node2 = new BinaryTreeNode<>(-1.5, node4, null);
        BinaryTreeNode<Double> node1 = new BinaryTreeNode<>(3.4, node2, node3);

        BinaryTree<Double> bt2 = new BinaryTree<>(4, node1);

        System.out.println(bt1.getRoot().getValue());
    
        
    }
    
}
