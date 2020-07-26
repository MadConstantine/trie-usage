package com.constantine.datastructure;

import java.util.*;

public class IpTrieNode {

    private final short value;
    private ArrayList<IpTrieNode> children;
    private byte isEnd;

    public IpTrieNode(boolean isLeaf, short value) {
        if (!isLeaf) {
            children = new ArrayList<>();
        } else {
            this.isEnd = 1;
        }
        this.value = value;
    }

    public void put(boolean isPreLeaf, short value) {
        if (isPreLeaf) {
            children.add(new IpTrieNode(true, value));
        } else {
            children.add(new IpTrieNode(false, value));
        }
        children.trimToSize();
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
            if(temp.getValue() == value) {
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
