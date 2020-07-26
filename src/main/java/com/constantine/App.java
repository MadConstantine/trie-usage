package com.constantine;

import com.constantine.datastructure.IpTrie;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;

public class App {

    public static void main(String[] args) throws IOException {
        LocalTime start = LocalTime.now();
        System.out.println("Start time: " + start);

        IpTrie trie = new IpTrie();

        try (BufferedReader buffer = new BufferedReader(new FileReader(args[0]))) {
            for(String line; (line = buffer.readLine()) != null; ) {
                trie.storeAddress(line);
            }
        }

        System.out.println("Start counting...");
        System.out.println("Number of unique addresses: " + trie.countUniqueAddresses());

        LocalTime finish = LocalTime.now();
        System.out.println("Finish time: " + finish);
        System.out.println("Finished at: " + Duration.between(start, finish).getSeconds() + " seconds");
    }
}
