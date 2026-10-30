import heapq

class Solution(object):
    def shortestPath(self, n, edges, labels, k):
        """
        :type n: int
        :type edges: List[List[int]]
        :type labels: str
        :type k: int
        :rtype: int
        """
        # Build adjacency list
        graph = [[] for _ in range(n)]
        for u, v, w in edges:
            graph[u].append((v, w))
            
        # Min-heap storing (weight, current_node, consecutive_count)
        # Start at node 0 with count 1 and weight 0
        pq = [(0, 0, 1)]
        
        # dist[u][count] stores the minimum weight to reach node u with a streak of 'count'
        dist = {}
        
        while pq:
            w, u, count = heapq.heappop(pq)
            
            # If we reached the target node n - 1, return the total weight
            if u == n - 1:
                return w
                
            if (u, count) in dist and dist[(u, count)] < w:
                continue
                
            for v, weight in graph[u]:
                # Calculate next consecutive count
                if labels[u] == labels[v]:
                    next_count = count + 1
                else:
                    next_count = 1
                    
                # Skip if streak exceeds k
                if next_count > k:
                    continue
                    
                new_weight = w + weight
                
                if (v, next_count) not in dist or new_weight < dist[(v, next_count)]:
                    dist[(v, next_count)] = new_weight
                    heapq.heappush(pq, (new_weight, v, next_count))
                    
        return -1