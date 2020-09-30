import java.util.*;
import java.io.*;
public class BinarySearchTree
{
    TreeNode<Integer> root;
    BinarySearchTree()
    {
        root=null;
    }
    public void insert(int val)
    {
        root=insert(val, root);
    }
    private TreeNode<Integer> insert(int val, TreeNode<Integer> rt)
    {
        if(rt==null)
            rt=new TreeNode<Integer>(val);
        else if(val<rt.val)
        {
            if(rt.left==null)
                rt.left=insert(val,rt.left);
            else
                insert(val, rt.left);
        }
        else if(val>rt.val)
        {
            if(rt.right==null)
                rt.right=insert(val,rt.right);
            else
                insert(val, rt.right);
        }
        return rt;
    }
    public void search(int val)
    {
        TreeNode x=search(val, root);
        if(x==null)
        System.out.println("Element not found");
        else
        System.out.println("Element Found");
    }
    private TreeNode search(int val, TreeNode<Integer> rt)
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
    public void delete(int val)
    {
        TreeNode x=search(val,root);
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
                if(x==root)
                {
                    root=root.left;
                    return;
                }
                TreeNode parent=findParent(x,root);
                if(parent.right==x)
                parent.right=x.left;
                else
                parent.left=x.left;
            }
            else if(x.left==null && x.right!=null)
            {
                if(x==root)
                {
                    root=root.right;
                    return;
                }
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
        System.out.print(r.val+" ");
        inOrderTraversal(r.right);            
    }
    private void preOrderTraversal(TreeNode r)
    {
        if(r==null)
            return;
        System.out.print(r.val+" ");
        preOrderTraversal(r.left);
        preOrderTraversal(r.right);            
    }
    private void postOrderTraversal(TreeNode r)
    {
        if(r==null)
            return;
        postOrderTraversal(r.left);
        postOrderTraversal(r.right);
        System.out.print(r.val+" ");            
    }
}
