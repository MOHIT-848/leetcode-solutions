import sys

# Increase recursion depth for deep trees
sys.setrecursionlimit(300000)

class FenwickTree:
    def __init__(self, size):
        self.size = size
        self.tree = [0] * (size + 1)

    def update(self, idx, val):
        # Update idx (1-based) with XOR val
        while idx <= self.size:
            self.tree[idx] ^= val
            idx += idx & (-idx)

    def query(self, idx):
        # Prefix XOR sum up to idx (1-based)
        res = 0
        while idx > 0:
            res ^= self.tree[idx]
            idx -= idx & (-idx)
        return res

    def query_range(self, l, r):
        # Range XOR sum [l, r]
        return self.query(r) ^ self.query(l - 1)


class Solution(object):
    def palindromePath(self, n, edges, s, queries):
        """
        :type n: int
        :type edges: List[List[int]]
        :type s: str
        :type queries: List[str]
        :rtype: List[bool]
        """
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        parent = [0] * n
        depth = [0] * n
        heavy = [-1] * n
        size = [0] * n

        # Iterative DFS 1: Compute size, depth, parent, heavy child
        # Post-order traversal via explicit stack to avoid recursion limits
        stack = [(0, -1, False)]
        order = []
        while stack:
            u, p, visited = stack.pop()
            if visited:
                order.append(u)
                continue
            stack.append((u, p, True))
            for v in adj[u]:
                if v != p:
                    parent[v] = u
                    depth[v] = depth[u] + 1
                    stack.append((v, u, False))

        for u in order:
            sz = 1
            max_c_sz = 0
            for v in adj[u]:
                if v != parent[u]:
                    sz += size[v]
                    if size[v] > max_c_sz:
                        max_c_sz = size[v]
                        heavy[u] = v
            size[u] = sz

        # DFS 2: Decompose paths and assign positions
        pos = [0] * n
        head = [0] * n
        cur_pos = [1]  # 1-based indexing for Fenwick Tree

        # Use stack for heavy-first traversal
        stack = [(0, 0)]
        while stack:
            u, h = stack.pop()
            head[u] = h
            pos[u] = cur_pos[0]
            cur_pos[0] += 1

            # Push light children first so heavy child is popped and processed first
            for v in adj[u]:
                if v != parent[u] and v != heavy[u]:
                    stack.append((v, v))
            if heavy[u] != -1:
                stack.append((heavy[u], h))

        # Initialize Fenwick Tree with initial node masks
        bit = FenwickTree(n)
        node_masks = [1 << (ord(c) - ord('a')) for c in s]
        for i in range(n):
            bit.update(pos[i], node_masks[i])

        def path_query(u, v):
            xor_sum = 0
            while head[u] != head[v]:
                if depth[head[u]] > depth[head[v]]:
                    xor_sum ^= bit.query_range(pos[head[u]], pos[u])
                    u = parent[head[u]]
                else:
                    xor_sum ^= bit.query_range(pos[head[v]], pos[v])
                    v = parent[head[v]]

            if depth[u] > depth[v]:
                u, v = v, u
            xor_sum ^= bit.query_range(pos[u], pos[v])
            return xor_sum

        ans = []
        for q in queries:
            parts = q.split()
            if parts[0] == "update":
                u = int(parts[1])
                new_char = parts[2]
                new_mask = 1 << (ord(new_char) - ord('a'))
                # XOR difference to change the value in Fenwick tree
                diff = node_masks[u] ^ new_mask
                if diff != 0:
                    bit.update(pos[u], diff)
                    node_masks[u] = new_mask
            else:
                u = int(parts[1])
                v = int(parts[2])
                mask = path_query(u, v)
                # At most 1 bit set checks if mask is a power of 2 or 0
                ans.append((mask & (mask - 1)) == 0)

        return ans