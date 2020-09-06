# from math import ceil
#
#
# class Solution:
#     def getPermutation(self, n: int, k: int) -> str:
#         factorial = [1]
#         for i in range(1, n):
#             factorial.append(factorial[-1] * i)
#         ret = 0
#         last_num = 0
#         recorded_list = []
#         length = n
#         # while n > 0 and k > 0:
#         #     num = ceil(k / factorial(n - 1)) - 1
#         #     last_num = num + 1
#         #     while last_num in recorded_list:
#         #         last_num += 1
#         #     recorded_list.append(last_num)
#         #     k = k % factorial(n - 1)
#         #     print(k)
#         #     n = n - 1
#         #     recorded_list.append(last_num)
#         #     ret = (last_num + ret) * 10
#         # for i in range(1, 1 + length):
#         #     if i not in recorded_list:
#         #         ret = ret + i
#         # return str(ret)
#         valid = [1] * (n + 1)
#         ans = []
#         k = k - 1
#         for i in range(1, n + 1):
#             num = k // factorial[n - i]+1
#             for j in range(1, n + 1):
#                 num -= valid[j]
#                 if num == 0:
#                     ans.append(str(j))
#                     valid[j] = 0
#                     break
#             k %= factorial[n - i]
#         return "".join(ans)
#
#
# print(Solution().getPermutation(4, 9))

# Definition for a binary tree node.
# import collections
# from typing import List
#
#
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#
#
# class Solution:
#     def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
#         levelOrder = []
#         if not root:
#             return levelOrder
#         # 注意deque是从可迭代对象（iterable）创建数据
#         queue = collections.deque([root])
#         while queue:
#             level = list()
#             for i in range(0, len(queue)):
#                 node = queue.popleft()
#                 level.append(node.val)
#                 if node.left:
#                     queue.append(node.left)
#                 if node.right:
#                     queue.append(node.right)
#             levelOrder.append(level)
#         return levelOrder[::-1]
