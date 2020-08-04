"""
created by FantasticPsq on 2020/08/04
LeetCode 207 课程表
"""
from typing import List

"""
解法一:拓扑排序

"""


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0 for _ in range(numCourses)]
        adjacent = [[] for _ in range(numCourses)]
        from collections import deque
        queue = deque()
        for cur, pre in prerequisites:
            indegrees[cur] += 1
            adjacent[pre].append(cur)
        for i in range(numCourses):
            if not indegrees[i]:
                queue.append(i)
        while queue:
            node = queue.popleft()
            for j in adjacent[node]:
                indegrees[j] -= 1
                if not indegrees[j]:
                    queue.append(j)
            numCourses -= 1
        return numCourses == 0
