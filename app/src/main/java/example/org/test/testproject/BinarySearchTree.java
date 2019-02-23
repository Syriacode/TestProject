package example.org.test.testproject;

public class BinarySearchTree {
    Index index = new Index();

    Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size){
        if(preIndex.index>=size || low > high){
            return null;
        }
        Node root = new Node(pre[preIndex.index]);
        if (low == high){
            return root;
        }
        int i;
        for (i = low; i<=high; ++i){
            if (pre[i] > root.data){
                break;
            }
        }
        return root;
    }
    Node constructTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size - 1, size);
    }


    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int pre[] = new int[]{50,32,13,65,34,22,3,76,90};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Preorder traversal of the constructed tree is ");
        tree.printPreorder(root);
    }

}


