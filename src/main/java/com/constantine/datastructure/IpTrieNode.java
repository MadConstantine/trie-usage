package com.constantine.datastructure;

public class IpTrieNode {

    private static final char digitsNumber = 256;
    private IpTrieNode[] children;
    private byte isEnd;

    public IpTrieNode() {
        children = new IpTrieNode[digitsNumber];
    }

    public void put(int value) {
        children[value] = new IpTrieNode();
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
