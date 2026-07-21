class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        
        def wordIsSubstringOfAnyString(word):
            for value in words:
                if word in value and word != value:
                    return True;
            return False;
        
        substrings = []

        for word in words:
            if wordIsSubstringOfAnyString(word):
                substrings.append(word);
        
        return substrings


        