import sys
from collections import deque

v,e = map(int,sys.stdin.readline().split())
graph = [[]*(v+1) for _ in range(v+1)]
kevin = [[0]*(v+1) for _ in range(v+1)]

for _ in range(e):
    x,y = map(int,sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)
    
    
for i in range(1,v+1):
    queue = deque([i])
    
    while queue:
        x = queue.popleft()
        
        for j in graph[x]:                
            if kevin[i][j] == 0:
                kevin[i][j] = kevin[i][x] + 1
                queue.append(j)
                
results = []                
for x in kevin[1:]:
    results.append(sum(x))
    
for i,v in enumerate(results):
    if min(results) == v:
        print(i+1)
        break
