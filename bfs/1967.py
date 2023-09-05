참고 : https://dbwp031.tistory.com/41
from collections import deque
import sys

def bfs(queue, graph, visited):
    dist, node = 0, 0
    
    while queue:
        cur, cur_dist = queue.popleft()
        
        for v, c in graph[cur]:
            if not visited[v]:
                visited[v] = True
                queue.append((v, c + cur_dist))
                if dist < cur_dist + c:
                    dist = cur_dist + c
                    node = v
                
                
    return node, dist
                    
n = int(sys.stdin.readline())
graph = [[] * (n+1) for _ in range(n+1)]
visited = [False] * (n+1)
queue = deque()

for _ in range(n-1):
    s,e,c = map(int,sys.stdin.readline().split())
    graph[s].append((e,c))
    graph[e].append((s,c))
    
    if len(queue) == 0:
        queue.append((s, 0))
        visited[s] = True    

s,d = bfs(queue, graph,visited) # 아무 노드에서 제일 먼 노드를 구함
visited = [False] * (n+1)
visited[s] = True
queue.append((s,0))
_,d = bfs(queue,graph,visited) # 거기서 제일 먼 노드를 구함 == 지름
print(d)

