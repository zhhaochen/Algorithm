package Amazon;

import java.util.HashMap;
import java.util.Map;

public class Solution208 {

    private Solution208[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Solution208() {
        children = new Solution208[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Solution208 node = this;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) node.children[index] = new Solution208();
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Solution208 node = searchPre(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Solution208 node = searchPre(prefix);
        return node != null;
    }

    private Solution208 searchPre(String pre){
        Solution208 node = this;
        for (int i = 0; i < pre.length(); i++){
            int index = pre.charAt(i) - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }
}
