# trie-usage
Example of Trie(prefix tree) data structure implementation for ipv4 addresses storage and counting purposes.

After building jar you can run it, passing path to file with ip's and adjusting heap size according to your machine and file size.

Command example: 'java -Xms15G -Xmx15G -jar trie-usage.jar ip_addresses'.

File should contain something like that:
...
145.67.23.4
8.34.5.23
89.54.3.124
89.54.3.124
3.45.71.5
3.46.71.5
8.35.5.45
145.67.23.4
8.35.5.0
...