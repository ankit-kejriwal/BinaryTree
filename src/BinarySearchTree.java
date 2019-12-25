public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
    }

    public void insert(int temp){
        root = push(root,temp);
    }

    public Node push(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.key > val){
            root.left  = push(root.left,val);
        } else {
            root.right  = push(root.right,val);
        }
        return root;
    }

    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.key+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key+ " ");
        inOrder(root.right);
    }
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key+ " ");
    }

    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(11);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(13);
        binarySearchTree.insert(57);
        binarySearchTree.insert(25);
        binarySearchTree.insert(1);
        binarySearchTree.insert(90);
        binarySearchTree.insert(3);
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.postOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
    }
}
