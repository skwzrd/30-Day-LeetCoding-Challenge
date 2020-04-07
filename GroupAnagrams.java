/*
Day 6

Given an array of strings, group anagrams together.

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GroupAnagrams{
    public static List<List<String>> anagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        
        int index = 0;
        Map<String, Integer> d = new HashMap();
        
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted_word = Arrays.toString(c);

            if(!d.containsKey(sorted_word)){
                List<String> word_holder = new ArrayList<>();
                word_holder.add(strs[i]);
                answer.add(word_holder);
                d.put(sorted_word, index++);
            }
            else{
                int sublist_index = d.get(sorted_word);
                answer.get(sublist_index).add(strs[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(anagrams(strs));
    }
}

