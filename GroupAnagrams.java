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

        Map<String, List<String>> d = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted_word = Arrays.toString(c);
            
            if(!d.containsKey(sorted_word)){
                List<String> word_holder = new ArrayList<>();
                d.put(sorted_word, word_holder);
            }
            d.get(sorted_word).add(strs[i]);
        }

        List<List<String>> answer = new ArrayList<>();
        for (List<String> list : d.values()) {
            answer.add(list);
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(anagrams(strs));
    }
}

