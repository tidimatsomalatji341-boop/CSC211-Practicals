class BinarySearchtree{
    private Node root;
    private int size;
    private int count = 0;

    public BinarySearchtree(){
        this.root = null;
        this.size = 0;
    }

    public BinarySearchtree(int size, Node root){
        this.root = root;
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public Node getRoot(){
        return root;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setRoot(Node root){
        this.root = root;
    }

    // QUESTION 2.1

    private boolean search(Node n, int data){
        if (n == null) {
            return false;
        }
        else if (n.getData() == data) {
            return true;
        }
        else if(n.getData() > data){
            return search(n.getLeft(), data);
        }
        else{
            return search(n.getRight(), data);
        }
    }
    
    public boolean search(int k){
        return search(this.root, k);
    }

    // QEUSTION 2.2

    private Node insert(Node n, int k){
        if(n == null){
            return new Node(k, null, null);
        }
        else if(k > n.getData()){
            n.setRight(insert(n.getRight(), k));;
        }
        else if (k < n.getData()) {
            n.setLeft(insert(n.getLeft(), k));;
        }
        return n;
    
    }

     public void insert(int k){
        if (!search(this.root, k)) {
            this.root = insert(this.root, k);
            size++;
        }
        else{
            System.out.println("Value " + k + " is a DUPLICATE!!!!");
        }
    }

    //QUESTION 2.3

    private int height(Node n){
        if (n == null) {
            return -1;
        }
            return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }

    public int height(){
        return height(this.root);
    }

    //QUESTION 2.4

    private void print_in_order(Node n){
        if (n == null) {
            return;
        }
        print_in_order(n.getLeft());
        System.out.println(n.getData());
        print_in_order(n.getRight());
            
    }

    public void print_in_order(){
        print_in_order(this.root);
    }
   

    //QUESTION 2.5

    public int find_the_kth_smallest(int k){
        if (k > getSize()){
            System.out.println("Input not valid");
            return -1;
        }

        count = 0;
        return kthHelper(root, k);

        
    }

    private int kthHelper(Node n, int k){
        if(n == null){
            return -1;
        }
        int left = kthHelper(n.getLeft(), k);
        if(left != -1){
            return left;
        }

        count++;
        if(count == k){
            System.out.println(n.getData());
            return n.getData();
        }

        return kthHelper(n.getRight(), k);
    }

    private Node findMax(Node n){
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
    }

    // QUESTION  2.6

    private Node delete(Node n, int k){
        if (n == null) {
            return null;
        }

        if(k < n.getData()){
            n.setLeft(delete(n.getLeft(), k));
        }
        else if(k > n.getData()){
            n.setRight(delete(n.getRight(), k));;
        }
        else{
            //CASE 1 - k is a leaf 
            if(n.getLeft() == null && n.getRight() == null){
                return null;
            }
            
            //CASE 2 - k is an internal node with one child
            else if(n.getLeft() == null || n.getRight() == null){
                // When k has only left child
                if(n.getLeft() != null){
                    return n.getLeft();
                }
                else{
                    return n.getRight();
                }
            }

            //CASE 3 - k is an internal node with two children
            else{
                //CASE 3a - replace k with in-order predecessor (Largest node in the left subtree)
                Node predecessor = findMax(n.getLeft()); // Find the largest node in the Left Sub-tree

                n.setData(predecessor.getData());

                n.setLeft(delete(n.getLeft(), predecessor.getData()));
            }

        }

        return n;
    }

    public void delete(int k){
        if(search(this.root, k)){
            this.root = delete(this.root, k);
            this.size--;
        }
        else{
            System.out.println("Value " + k + " not found. No deletion made.");
        }
    }

   
}