"""
Day 6

Given an array of strings, group anagrams together.

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
"""

def anagrams(strs):
    answer = []
    d = {}
    for word in strs:
        l = list(word)
        l.sort()
        sorted_word = ''.join(l)

        if sorted_word not in d:
            d[sorted_word] = []

        d[sorted_word].append(word)

    answer = list(d.values())
    return answer

def main():
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(anagrams(strs))

if __name__ == "__main__":
    main()

