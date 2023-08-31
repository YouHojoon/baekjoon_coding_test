from collections import deque
import sys

h,w = map(int,sys.stdin.readline().split())
graph = [[0] * w for _ in range(h)]
move = ((1,0),(-1,0),(0,1),(0,-1))

for y in range(h):
    for x,c in enumerate(input()):
        graph[y][x] = int(c)
        
queue = deque([(0,0)])
prev = (0,0)

while len(queue) != 0:
    x,y = queue.popleft()
    
    if x == w -1 and y == h-1:
      break

    for dx,dy in move:
        nx = x + dx
        ny = y + dy
        
        if (0<=nx<w) and (0<=ny<h):
            if graph[ny][nx] == 1:
                graph[ny][nx] = graph[y][x] + 1
                queue.append((nx,ny))
            
print(graph[h-1][w-1])    
