package com.constantine.datastructure;

public class IpTrieNode {

    private IpTrieNode[] children;
    private byte isEnd;

    public IpTrieNode(boolean isLeaf) {
        if (!isLeaf) {
            children = new IpTrieNode[256];
        } else {
            this.isEnd = 1;
        }
    }

    public void put(boolean isPreLeaf, int value) {
        if (isPreLeaf) {
            children[value] = new IpTrieNode(true);
        } else {
            children[value] = new IpTrieNode(false);
        }
    }

    public IpTrieNode get(int value) {
        return children[value];
    }

    public boolean contains(int value) {
        return children[value] != null;
    }

    public void setEnd() {
        this.isEnd = 1;
    }

    public boolean isEnd() {
        return this.isEnd == 1;
    }
}
