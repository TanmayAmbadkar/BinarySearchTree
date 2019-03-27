public class TreeNode<Type>
{
    TreeNode left;
    TreeNode right;
    Type val;
    TreeNode()
    {
        left=null;
        right=null;
        val=null;
    }
    TreeNode(Type val)
    {
        left=null;
        right=null;
        this.val=val;
    }
}