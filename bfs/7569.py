import sys
from collections import deque

m,n,h = map(int, sys.stdin.readline().split())
graph = []
move = ((1,0,0),(-1,0,0),(0,1,0),(0,-1,0),(0,0,1),(0,0,-1))
queue = deque()

for i in range(h):
    y = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
    graph.append(y)

for i in range(h):
    for y in range(n):
        for x in range(m):
            if graph[i][y][x] == 1:
                queue.append((x,y,i))
    
while queue:
    x,y,i = queue.popleft()
    
    for dx,dy,dh in move:
        nx = x + dx
        ny = y + dy
        nh = i + dh
        
        if 0<=nx<m and 0<=ny<n and 0<=nh<h and graph[nh][ny][nx] == 0:
            graph[nh][ny][nx] = graph[i][y][x] + 1
            queue.append((nx,ny,nh))

t = 0
for y in graph:
    for x in y:
        if x.count(0) > 0:
            print(-1)
            exit(0)
        t = max(t, max(x))
print(t - 1)
