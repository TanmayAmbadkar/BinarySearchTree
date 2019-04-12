public class BSTDriver
{
    public static void main(String args[])
    {
        BinarySearchTree bst=new BinarySearchTree(75);
        bst.insert(100);
        bst.insert(45);
        bst.insert(120);
        bst.insert(99);
        bst.insert(32);
        bst.insert(35);
        bst.insert(48);
        bst.insert(98);
        bst.insert(-100);
        bst.insert(76);
        bst.insert(74);
        bst.insert(57);
        bst.insert(73);
        bst.inOrderTraversal();
        System.out.println("\b");
        bst.delete(57);
        bst.inOrderTraversal();
        System.out.println("\b");
        bst.delete(75);
        bst.inOrderTraversal();
        System.out.println("\b");
        bst.delete(73);
        bst.inOrderTraversal();
        System.out.println("\b");
    }
}       
