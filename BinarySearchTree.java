import java.util.*;
public class BinarySearchTree
{
    TreeNode<Integer> root;
    BinarySearchTree(Integer val)
    {
        root=new TreeNode<Integer>(val);
    }
    public void insert(Integer val)
    {
        insert(val, root);
    }
    private void insert(Integer val, TreeNode<Integer> rt)
    {
        if(val<rt.val)
        {
            if(rt.left==null)
                rt.left=new TreeNode<Integer>(val);
            else
                insert(val, rt.left);
        }
        else if(val>rt.val)
        {
            if(rt.right==null)
                rt.right=new TreeNode<Integer>(val);
            else
                insert(val, rt.right);
        }
    }
    public void search(Integer val)
    {
        TreeNode x=search(val, root);
        if(x==null)
        System.out.println("Element not found");
        else
        System.out.println("Element Found");
    }
    private TreeNode search(Integer val, TreeNode<Integer> rt)
    {
        if(val==rt.val)
        return rt;
        else if(val<rt.val)
        {
            if(rt.left!=null)
                return search(val, rt.left);
            else
                return null;
        }
        else
        {
            if(rt.right!=null)
                return search(val, rt.right);
            else
                return null;
        }
    }
    private TreeNode findParent(TreeNode<Integer> x, TreeNode<Integer> p)
    {
        if(p.right==x || p.left==x)
            return p;
        else
        {
            if(x.val<p.val)
            return findParent(x,p.left);
            else
            return findParent(x,p.right);
        }
    }
    public void delete(Integer val)
    {
        TreeNode x=search(val, root);
        if(x==null)
        throw new NoSuchElementException();
        else
        {
            if(x.right==null && x.left==null)
            {
                TreeNode m=findParent(x,root);
                if(m.right==x)
                    m.right=null;
                else
                    m.left=null;
            }
            else if(x.right==null && x.left!=null)
            {
                TreeNode parent=findParent(x,root);
                if(parent.right==x)
                parent.right=x.left;
                else
                parent.left=x.left;
            }
            else if(x.left==null && x.right!=null)
            {
                TreeNode parent=findParent(x,root);
                if(parent.right==x)
                parent.right=x.right;
                else
                parent.left=x.right;
            }
            else
            {
                TreeNode<Integer> par=x.left;
                while(par.right!=null)
                {
                    par=par.right;
                }
                int temp=par.val;
                delete(par.val);
                x.val=temp;
            }
        }
    }
    private int height(TreeNode<Integer> r)
    {
        if(r==null)
        return -1;
        int l=height(r.left);
        int ri=height(r.right);
        return Math.max(l,ri)+1;
    }
    public void inOrderTraversal()
    {
        inOrderTraversal(root);
    }
    public void preOrderTraversal()
    {
        preOrderTraversal(root);
    }
    public void postOrderTraversal()
    {
        postOrderTraversal(root);
    }
    private void inOrderTraversal(TreeNode r)
    {
        if(r==null)
            return;
        inOrderTraversal(r.left);
        System.out.print(r.val+", ");
        inOrderTraversal(r.right);            
    }
    private void preOrderTraversal(TreeNode r)
    {
        if(r==null)
            return;
        System.out.print(r.val+", ");
        preOrderTraversal(r.left);
        preOrderTraversal(r.right);            
    }
    private void postOrderTraversal(TreeNode r)
    {
        if(r==null)
            return;
        postOrderTraversal(r.left);
        postOrderTraversal(r.right);
        System.out.print(r.val+", ");            
    }
}
