import java.util.*;

public class BinaryTree {
    Node root;
    BinaryTree(){
    }

    public void insert(Node temp, int key){
        if(temp == null){
            temp = new Node(key);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();
            if(temp.left == null){
                temp.left = new Node(key);
                break;
            } else {
                queue.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new Node(key);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public void levelOrderTraversal(Node temp){
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.key+" ");
            if(temp.left!= null){
                queue.add(temp.left);
            }
            if(temp.right!= null){
                queue.add(temp.right);
            }
        }
        System.out.println();
    }

    public void inOrderTraversal(Node temp) {
        if(temp == null){
            return;
        }
        inOrderTraversal(temp.left);
        System.out.print(temp.key+ " ");
        inOrderTraversal(temp.right);
    }

    public void inOrderTraversalWithoutRecursion(Node temp){
        if (temp == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node curr = temp;
        while (curr!=null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr =curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.key+ " ");
            curr = curr.right;
        }
    }

    public void preOrderTraversalWithoutRecursion(Node temp){
        Stack<Node> stack = new Stack<>();
        stack.push(temp);
        while (!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.key+" ");
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
    }

    public List<Integer> postOrderTraversalWithoutRecursion(Node temp){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(temp == null) return list;
        stack.push(temp);
        while (!stack.isEmpty()){
            Node curr = stack.pop();
            list.add(0,curr.key);
            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }
        return list;
    }

    public void preOrderTraversal(Node temp) {
        if(temp == null){
            return;
        }
        System.out.print(temp.key+ " ");
        preOrderTraversal(temp.left);
        preOrderTraversal(temp.right);
    }
    public void postOrderTraversal(Node temp) {
        if(temp == null){
            return;
        }
        postOrderTraversal(temp.left);
        postOrderTraversal(temp.right);
        System.out.print(temp.key+ " ");
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.levelOrderTraversal(binaryTree.root);
        binaryTree.insert(binaryTree.root,7);
        binaryTree.insert(binaryTree.root,8);
        binaryTree.insert(binaryTree.root,9);
        binaryTree.levelOrderTraversal(binaryTree.root);
        System.out.println("Inorder traversal");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("PreOrder traversal");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("PostOrder traversal");
        binaryTree.postOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("InOrder traversal without recursion");
        binaryTree.inOrderTraversalWithoutRecursion(binaryTree.root);
        System.out.println();
        System.out.println("PreOrder traversal");
        binaryTree.preOrderTraversalWithoutRecursion(binaryTree.root);
        System.out.println();
    }
}
