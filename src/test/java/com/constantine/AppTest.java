package com.constantine;

import com.constantine.datastructure.IpTrie;
import com.constantine.datastructure.IpTrieNode;
import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void countingTest() {
        String file = "145.67.23.4\n8.34.5.23\n89.54.3.124\n89.54.3.124\n3.45.71.5\n3.46.71.5\n8.35.5.45\n145.67.23.4\n8.35.5.0";

        IpTrie trie = new IpTrie();
        for (String address: file.split("\n")) {
            trie.storeAddress(address);
        }

        assertEquals(7, trie.countUniqueAddresses());
    }
}
