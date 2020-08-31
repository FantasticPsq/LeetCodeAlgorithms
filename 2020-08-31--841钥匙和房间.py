class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        N = len(rooms)
        book = [0] * N
        count = 0

        def dfs(node: int):
            s.add(node)
            nonlocal count
            count = count + 1
            for i in rooms[node]:
                if i not in s:
                    dfs(i)
                    book[i] = 1

        s = set()
        dfs(0)
        return count == N
