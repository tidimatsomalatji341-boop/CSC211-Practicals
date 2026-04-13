class BinaryTree<E>{
    private int size;
    private BinaryTreeNode<E> root;

    public BinaryTree(){
        this.size = 0;
        this.root = null;
    }

    public BinaryTree(int size, BinaryTreeNode<E> root){
        this.size = size;
        this.root = root;
    }

    public int getsize(){
        return size;
    }

    public BinaryTreeNode<E> getRoot(){
        return root;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setRoot(BinaryTreeNode<E> root){
        this.root = root;
    }

}