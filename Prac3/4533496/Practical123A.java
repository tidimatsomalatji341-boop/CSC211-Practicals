class Practical123A{
    public static void main(String[] args) {
        int[] heap = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        print(heap);

        System.out.println(validate(heap));
    }

    static public void print(int[] heap){
        int n = heap.length -1;

        int parent;
        int leftChild;
        int middleChild;
        int rightChild;;

        for(int i = 1; i <= n; i++){
            parent = i;
            leftChild = (3*parent) - 1;
            middleChild = 3*parent;
            rightChild = (3*parent) + 1;

            if(leftChild > n){
                break;
            }

            System.out.println("Node " + heap[parent] + " -> " + heap[leftChild] + ", " + heap[middleChild] + ", " + heap[rightChild]);
        }
    }

    static public int validate(int[] heap){
        int n = heap.length -1;

        int parent;
        int leftChild;
        int middleChild;
        int rightChild;
        int validation = -1;

        for(int i = 1; i <= n; i++){
            parent = i;
            leftChild = (3*parent) - 1;
            middleChild = 3*parent;
            rightChild = (3*parent) + 1;

        
            if(leftChild > n) break;

        
            boolean maxHeap = heap[parent] >= heap[leftChild]
                && (middleChild > n || heap[parent] >= heap[middleChild])
                && (rightChild > n || heap[parent] >= heap[rightChild]);

            boolean minHeap = heap[parent] <= heap[leftChild]
                && (middleChild > n || heap[parent] <= heap[middleChild])
                && (rightChild > n || heap[parent] <= heap[rightChild]);

            if(maxHeap || minHeap){
                validation = 1;
            } else {
                validation = -1;
                break;
            }
        }
        return validation;

    }
}