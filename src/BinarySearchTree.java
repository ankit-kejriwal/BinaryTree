import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public void preOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            if(temp!=null){
                System.out.print(temp.key+" ");
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public void postOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        List<Integer> list= new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            if(temp!=null){
                list.add(0,temp.key);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        for (int num:list) {
            System.out.print(num+" ");
        }
    }

    public void inOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (!stack.isEmpty() || temp !=null){
            while (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.key +" ");
            temp = temp.right;
        }
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
        System.out.println("PreOrder");
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        System.out.println("PostOrder");
        binarySearchTree.postOrder(binarySearchTree.root);
        System.out.println();
        System.out.println("InOrder");
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        System.out.println("PreOrder");
        binarySearchTree.preOrderIterative(binarySearchTree.root);
        System.out.println();
        System.out.println("PostOrder");
        binarySearchTree.postOrderIterative(binarySearchTree.root);
        System.out.println();
        System.out.println("InOrder");
        binarySearchTree.inOrderIterative(binarySearchTree.root);
        System.out.println();
    }
}
