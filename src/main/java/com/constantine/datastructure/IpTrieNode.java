package com.constantine.datastructure;

/**
 * Node of tree, designed to store octet of ipv4 address
 * as it's value and array with other nodes as it`s children
 */
public class IpTrieNode {

    private static final byte initCap = 10;
    private final short value;
    private IpTrieNode[] children;
    private byte isLeaf;

    /**
     * Constructs new tree node with children whether it's not leaf
     * Leafs dont have children in order to save memory
     * Children array have some initial capacity
     */
    public IpTrieNode(boolean isLeaf, short value) {
        if (!isLeaf) {
            children = new IpTrieNode[initCap];
        } else {
            this.isLeaf = 1;
        }
        this.value = value;
    }

    /**
     * Puts new node with value into tree
     */
    public void put(boolean isPreLeaf, short value) {

        for (short i=0; i<children.length; i++) {
            if (children[i] == null) {
                children[i] = new IpTrieNode(isPreLeaf, value);
                break;
            }
            if (i == children.length-1) {
                IpTrieNode[] temp = new IpTrieNode[children.length+5];
                System.arraycopy(children, 0, temp, 0, children.length);
                children = temp;
            }
        }
    }

    /**
     * Retrieves node with certain value
     * don't use it without 'contains' or you end up with null
     */
    public IpTrieNode get(short value) {
        for (IpTrieNode temp: children) {
            if(temp.getValue() == value) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Returns true if there is such node with certain value
     */
    public boolean contains(short value) {
        for (IpTrieNode temp: children) {
            if(temp != null && temp.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mark node as leaf
     */
    public void setEnd() {
        this.isLeaf = 1;
    }

    /**
     * Check if node is leaf
     */
    public boolean isEnd() {
        return this.isLeaf == 1;
    }

    /**
     * Get node's value
     */
    public short getValue() {
        return value;
    }
}
