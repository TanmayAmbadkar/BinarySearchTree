public class BST {
    Tree root;

    BST(int val) {
        root = new Tree(val);
    }

    void InsertElement(int key) {
        root = InsertElement(key, root);
    }

    Tree InsertElement(int key, Tree rt) {

        if (rt.val > key) {
            if (rt.lc == null)
                rt.lc = new Tree(key);
            else
                rt.lc = InsertElement(key, rt.lc);
        }
        if (rt.val < key) {
            if (rt.rc == null)
                rt.rc = new Tree(key);
            else
                rt.rc = InsertElement(key, rt.rc);

        }
        return rt;
    }

    private Tree SearchElement(int a, Tree rt) {
        if (rt.val == a)
            return rt;
        else if (a > rt.val)
            return SearchElement(a, rt.rc);
        else
            return SearchElement(a, rt.lc);
    }

    void PreOrderTraverse(Tree rt) {
        if (rt != null) {
            System.out.println(rt.val + ", ");
            PreOrderTraverse(rt.lc);
            PreOrderTraverse(rt.rc);
        }
    }

    void InOrderTraverse(Tree rt) {
        if (rt != null) {
            InOrderTraverse(rt.lc);
            System.out.print(rt.val + ", ");
            InOrderTraverse(rt.rc);
        }

    }

    void PostOrderTraverse(Tree rt) {
        if (rt != null) {
            PostOrderTraverse(rt.lc);
            PostOrderTraverse(rt.rc);
            System.out.print(rt.val + ", ");
        }
    }

    Tree findparent(Tree node, int value) {
        if (node.lc != null) {
            if (node.lc.val == value)
                return node;
        }
        if (node.rc != null) {
            if (node.rc.val == value)
                return node;
        }

        if (node.val > value) {
            return findparent(node.lc, value);
        } else {
            return findparent(node.rc, value);
        }

    }

    void DeleteElement(int a) {

        Tree ele = SearchElement(a, root);
        if (ele.lc == null && ele.rc == null) {
            Tree parent = findparent(root, a);
            if (a > parent.val) {
                parent.rc = null;
            } else {
                parent.lc = null;
            }
        } else {
            if (ele.lc == null && ele.rc != null) {
                if (ele.val == root.val) {
                    int temp = root.rc.val;
                    DeleteElement(root.rc.val);
                    root.val = temp;
                } else {
                    Tree parent = findparent(root, a);
                    if (parent.rc == ele) {
                        parent.rc = ele.rc;
                    } else {
                        parent.lc = ele.rc;
                    }
                }
            } else {
                if (ele.rc == null && ele.lc != null) {
                    if (ele.val == root.val) {
                        int temp = root.lc.val;
                        DeleteElement(root.lc.val);
                        root.val = temp;
                    } else {
                        Tree parent = findparent(root, a);
                        if (parent.rc == ele) {
                            parent.rc = ele.lc;
                        } else {
                            parent.lc = ele.lc;
                        }
                    }
                } else {
                    Tree temp = ele.lc;
                    while (temp.rc != null) {
                        temp = temp.rc;
                    }
                    int key = temp.val;
                    DeleteElement(key);
                    ele.val = key;
                }
            }
        }
    }
}
