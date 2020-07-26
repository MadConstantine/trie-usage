package com.constantine.datastructure;

import java.util.*;

public class IpTrieNode implements Comparable<IpTrieNode> {

    private short value;
    private TreeSet<IpTrieNode> children;
    private byte isEnd;

    public IpTrieNode(boolean isLeaf, short value) {
        if (!isLeaf) {
            children = new TreeSet<>();
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
    }

    public IpTrieNode get(short value) {
        IpTrieNode node = null;
        for (IpTrieNode temp: children) {
            if(temp.equals(new IpTrieNode(true, value))) {
                node = temp;
            }
        }
        return node;
    }

    public boolean contains(short value) {
        return children.contains(new IpTrieNode(true, value));
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

    @Override
    public boolean equals(Object o) {
        IpTrieNode that = (IpTrieNode) o;
        return this.value == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public int compareTo(IpTrieNode o) {
        return Short.compare(value, o.getValue());
    }
}
