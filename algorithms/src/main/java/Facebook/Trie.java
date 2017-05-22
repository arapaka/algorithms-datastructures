package Facebook;

/**
 * Created by archithrapaka on 4/22/17.
 */
public class Trie {
     TrieNode root;
     public Trie(){
         root = new TrieNode();
         root.val = ' ';
     }

     public void insert(String word) {
         TrieNode ws = root;

         for (int i = 0; i < word.length(); i++) {
             char c = word.charAt(i);

             if(ws.children[c - 'a'] == null) {
                 ws.children[c - 'a'] = new TrieNode(c);
                 ws.size++;
             }
             ws = ws.children[c - 'a'];
         }
         ws.isWord = true;
     }

     public boolean contains(String word) {
         TrieNode ws = root;
         for (int i = 0; i < word.length(); i++) {
             char c = word.charAt(i);
             if(ws.children[c - 'a'] == null) return false;
             ws = ws.children[c - 'a'];
         }
         return true;
     }

     public boolean startsWith(String prefix){
          return contains(prefix);
     }

    static class TrieNode {
        char val;
        boolean isWord; // is the end of the word
        TrieNode[] children = new TrieNode[26]; // children
        int size;
        public TrieNode(){

        }
        public TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
        public int getSize(){
            for (int i = 0; i < 26; i++) {
                 if(children[i] != null) {
                     size++;
                 }
            }
            return size;
        }
    }

    private void searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder sb = new StringBuilder("");
       // sb.append(c);
        //node = node.children[word.charAt(0) - 'a'];

        for (int i = 0; i < word.length();i++) {
            char c = word.charAt(i);
            if( node.val == ' ' || ( node.children[c - 'a'] != null && node.size == 1 && !node.isWord)) {
                sb.append(c);
                node = node.children[c - 'a'];
            }
            else {
               break;
            }
        }
        System.out.print(sb.toString());
    }
    public static void main(String[] args) {
         Trie trie = new Trie();
         String[] s = {"summi","summy","summer","summitt"};

        for (int i = 1; i < s.length; i++) {
            trie.insert(s[i]);
        }
        trie.searchLongestPrefix(s[0]);
        //System.out.print(trie.root.getSize());
    }
}
