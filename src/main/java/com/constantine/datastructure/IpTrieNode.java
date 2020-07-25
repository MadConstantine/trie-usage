package com.constantine.datastructure;

import java.util.HashMap;

public class IpTrieNode {

    private HashMap<Short, IpTrieNode> children;
    private byte isEnd;

    public IpTrieNode(boolean isLeaf) {
        if (!isLeaf) {
            children = new HashMap<>();
        } else {
            this.isEnd = 1;
        }
    }

    public void put(boolean isPreLeaf, short value) {
        if (isPreLeaf) {
            children.put(value, new IpTrieNode(true));
        } else {
            children.put(value, new IpTrieNode(false));
        }
    }

    public IpTrieNode get(short value) {
        return children.get(value);
    }

    public boolean contains(short value) {
        return children.get(value) != null;
    }

    public void setEnd() {
        this.isEnd = 1;
    }

    public boolean isEnd() {
        return this.isEnd == 1;
    }
}
