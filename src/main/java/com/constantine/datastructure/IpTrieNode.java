package com.constantine.datastructure;

public class IpTrieNode {

    private final short value;
    private IpTrieNode[] children;
    private byte isEnd;

    public IpTrieNode(boolean isLeaf, short value) {
        if (!isLeaf) {
            children = new IpTrieNode[10];
        } else {
            this.isEnd = 1;
        }
        this.value = value;
    }

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

    public IpTrieNode get(short value) {
        for (IpTrieNode temp: children) {
            if(temp.getValue() == value) {
                return temp;
            }
        }
        return null;
    }

    public boolean contains(short value) {
        for (IpTrieNode temp: children) {
            if(temp != null && temp.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public void setEnd() {
        this.isEnd = 1;
    }

    public boolean isEnd() {
        return this.isEnd == 1;
    }

    public short getValue() {
        return value;
    }
}
