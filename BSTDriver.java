public class DriverBST {
    public static void main(String args[]) {
        BST bst = new BST(100);
        bst.InsertElement(45);
        bst.InsertElement(30);
        bst.InOrderTraverse(bst.root);
        System.out.println("\b");
        bst.DeleteElement(100);
        bst.InOrderTraverse(bst.root);
        System.out.println("\b");
    }
}
