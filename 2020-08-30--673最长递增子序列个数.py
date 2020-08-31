from typing import List


class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        N = len(nums)
        count = [1] * N
        length = [0] * N
        for j in range(0, N):
            for i in range(0, j):
                if nums[i] < nums[j]:
                    if length[i] >= length[j]:
                        length[j] = length[i]+1
                        count[j] = count[i]
                    elif length[i] + 1 == length[j]:
                        count[j] = count[j] + count[i]
        longest = 0
        for l in length:
            if longest < l:
                longest = l
        ans = 0
        for i in range(N):
            if length[i]==longest:
                ans+=count[i]
        return ans