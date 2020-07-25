package com.constantine.datastructure;

import java.util.LinkedList;

/**
 * Data structure designed specially to store huge amounts ipv4 addresses
 * and count unique ones
 */
public class IpTrie {

    private IpTrieNode root;

    public IpTrie() {
        root = new IpTrieNode(false);
    }

    /**
     * Puts ipv4 address into the tree
     * @param address ipv4 address as a string
     */
    public void storeAddress(final String address) {
        String[] octets = address.split("\\.");
        IpTrieNode tempNode = root;

        for(int i=0; i<4; i++) {
            int octet = Integer.parseInt(octets[i]);
            if(!tempNode.contains(octet)) {
                tempNode.put(i == 3, octet);
            }
            tempNode = tempNode.get(octet);
        }
        tempNode.setEnd();
    }

    /**
     * Traverses through tree structure and counts addresses
     * @return amount of unique addresses
     */
    public long countUniqueAddresses() {
        long count = 0;
        LinkedList<IpTrieNode> list = new LinkedList<>();

        list.push(root);
        while(!list.isEmpty()) {
            IpTrieNode tempNode = list.pop();

            if (!tempNode.isEnd()) {
                for(int i=0; i<256; i++) {
                    if(tempNode.contains(i)) {
                        list.push(tempNode.get(i));
                    }
                }
            } else {
                count++;
            }
        }

        return count;
    }
}
