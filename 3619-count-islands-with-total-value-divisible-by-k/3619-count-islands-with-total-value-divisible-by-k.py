from collections import deque

class Solution(object):
    def countIslands(self, grid, k):
        """
        :type grid: List[List[int]]
        :type k: int
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        count = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] > 0 and not visited[r][c]:
                    # BFS to find the total value of the island
                    queue = deque([(r, c)])
                    visited[r][c] = True
                    island_sum = 0

                    while queue:
                        curr_r, curr_c = queue.popleft()
                        island_sum += grid[curr_r][curr_c]

                        for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                            nr, nc = curr_r + dr, curr_c + dc
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] > 0 and not visited[nr][nc]:
                                visited[nr][nc] = True
                                queue.append((nr, nc))

                    if island_sum % k == 0:
                        count += 1

        return count