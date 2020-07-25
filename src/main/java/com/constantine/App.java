package com.constantine;

import com.constantine.datastructure.IpTrie;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {
        IpTrie trie = new IpTrie();

        try (BufferedReader buffer = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                trie.storeAddress(line);
            }
        }

        System.out.println("Number of unique addresses: " + trie.countUniqueAddresses());
    }
}
