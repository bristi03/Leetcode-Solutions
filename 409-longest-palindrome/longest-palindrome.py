class Solution:
    def longestPalindrome(self, s: str) -> int:
        longest = 0
        charset = set()
        for ch in s:
            if ch in charset:
                charset.remove(ch)
                longest += 2
            else:
                charset.add(ch)
        if(charset):
            longest += 1
        return longest