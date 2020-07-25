package com.constantine;

import com.constantine.datastructure.IpTrie;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;

public class App {

    public static void main(String[] args) throws IOException {
        LocalTime start = LocalTime.now();
        System.out.println("Start time: " + start);

        //long count = 0;
        IpTrie trie = new IpTrie();

        try (BufferedReader buffer = new BufferedReader(new FileReader(args[0]))) {
            for(String line; (line = buffer.readLine()) != null; ) {
                trie.storeAddress(line);
//                count++;
//                System.out.println("Addresses stored: " + count);
            }
        }

//        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
//            stream.forEach(trie::storeAddress);
//        }

        System.out.println("Start counting...");
        System.out.println("Number of unique addresses: " + trie.countUniqueAddresses());

        LocalTime finish = LocalTime.now();
        System.out.println("Finish time: " + finish);
        System.out.println("Finished at: " + Duration.between(start, finish).getSeconds() + " seconds");
    }
}
