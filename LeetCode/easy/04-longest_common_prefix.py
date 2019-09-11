"""
"""

class Solution:
    def longestCommonPrefix(self, strs):
        #   Approach 1
        prefix = strs[0]
        if len(strs) == 0:
            return ""
        elif len(strs) == 1:
            return prefix
        
        matched = False
        for i in range(0, len(prefix)):
            for j in range(1, len(strs)):
                matched = prefix[:i+1] == strs[j][:i+1]
                if not matched:
                    st = prefix[:i] if i>0 else ""
                    return st
        if matched:
            return prefix
        return ""

prob = Solution()

test1 = ["flower", "flight", "flow"]
print(test1, " prefix: ", prob.longestCommonPrefix(test1))

test2 = [""]
print(test2, " prefix: ", prob.longestCommonPrefix(test2))

test3 = ["c", "c"]
print(test3, " prefix: ", prob.longestCommonPrefix(test3))

test4 = ["d"]
print(test4, " prefix: ", prob.longestCommonPrefix(test4))

test5 = ['daf', 'fda', 'deee']
print(test5, " prefix: ", prob.longestCommonPrefix(test5))