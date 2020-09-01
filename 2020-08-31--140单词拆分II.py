from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        length = len(s)
        dp = [[]] * (length + 1)
        dp[0].append("")
        can = [False] * (length + 1)
        can[0] = True
        for i in range(1, length + 1):
            for j in range(0, i):
                if can[j] and s[j:i] in wordDict:
                    can[i] = True
        if not can[length]:
            return []
        for i in range(1, length + 1):
            if not can[i]:
                continue
            new_list = []
            for j in range(0, i):
                if not can[j]:
                    continue
                if len(dp[j]) > 0 and s[j:i] in wordDict:
                    for x in dp[j]:
                        string = "" if x == "" else " "
                        new_list.append(x + string + s[j:i])
            dp[i] = new_list

        return dp[length]


print(Solution().wordBreak("catsanddog", ["cat", "cats", "and", "sand", "dog"]))
s = "12345"
print(s[0:6])
