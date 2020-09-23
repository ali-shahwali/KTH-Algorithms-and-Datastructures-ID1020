package Labb_3;

import javax.swing.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, int size)
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public Value get(Key key)
    {
        return get(root,key);
    }
    private Value get(Node node, Key key)
    {
        int compare = key.compareTo(node.key);
        if(compare < 0)
            return get(node.left,key);
        else if(compare > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    public int size()
    {
        return size(root);
    }
    private int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return node.size;
    }

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }
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
