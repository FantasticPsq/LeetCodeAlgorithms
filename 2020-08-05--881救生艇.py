from typing import List

from datashape.py2help import reduce


# class Solution:
#     @staticmethod
#     def numRescueBoats(people: List[int], limit: int) -> int:
#         people.sort()
#         i, j = 0, len(people) - 1
#         ans = 0
#         while i <= j:
#             if people[i] + people[j] <= limit:
#                 ans += 1
#                 i += 1
#                 j -= 1
#             elif people[j] <= limit:
#                 ans += 1
#                 j -= 1
#             else:
#                 return 0
#
#         return ans

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x, y: x ^ y, nums)


# print(Solution.numRescueBoats([3, 2, 2, 1], 3))
print(Solution().singleNumber([1, -1, 1]))
