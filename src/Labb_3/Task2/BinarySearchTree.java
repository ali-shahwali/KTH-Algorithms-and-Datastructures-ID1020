package Labb_3.Task2;
// code is inspired by Robert Sedgewick and Kevin Wayne from their booksite Algorithms 4th edition
/*
    A binary search tree consists of nodes that are recognised with keys and hold a value
    Any node to the left of a node has a smaller key, and any node to the right has a larger key.
    Insertion and delete times are dependent on the trees balancing which depends on the given root.
    Worst time complexity for insert and delet is O(n), the average case is O(n/2).
*/
public class BinarySearchTree<Key extends Comparable<Key>, Value>
{
    private Node root;

    // Node consists of a key, value a node pointing to the left or right node and number of nodes in subtree
    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;

        // constructor
        public Node(Key key, Value value, int size)
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    // creates empty BST
    public BinarySearchTree()
    {

    }

    // if given key returns null we know the tree doesnt contain that key.
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    // getting a value with a given key is done with recursion, we start at the root
    public Value get(Key key)
    {
        return get(root,key);
    }

    /*
        we recursively work our way down the tree using binary search to find the given key
        if we dont find it we return null, otherwise return the value
    */
    private Value get(Node node, Key key)
    {
        if (node == null)
            return null;

        int compare = key.compareTo(node.key);
        if(compare < 0)
            return get(node.left,key);
        else if(compare > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    // returns size of the whole tree
    public int size()
    {
        return size(root);
    }

    // returns size of the subtree
    private int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return node.size;
    }

    // we put in new values and keys recursively
    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    /*
        we recursively traverse the tree using binary search to find the correct position
        if the node is null we know we have reached a null link and we insert the new node
    */
    private Node put(Node node, Key key, Value value)
    {
        if(node == null)
            return new Node(key, value, 1);
        int compare = key.compareTo(node.key);

        if(compare < 0)
            node.left  = put(node.left, key, value);
        else if (compare > 0)
            node.right = put(node.right, key, value);
        else
            node.value   = value;

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


}
