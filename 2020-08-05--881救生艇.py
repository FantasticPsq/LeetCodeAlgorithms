from typing import List


class Solution:
    @staticmethod
    def numRescueBoats(people: List[int], limit: int) -> int:
        people.sort()
        i, j = 0, len(people) - 1
        ans = 0
        while i <= j:
            if people[i] + people[j] <= limit:
                ans += 1
                i += 1
                j -= 1
            elif people[j] <= limit:
                ans += 1
                j -= 1
            else:
                return 0
        return ans


print(Solution.numRescueBoats([3, 2, 2, 1], 3))
