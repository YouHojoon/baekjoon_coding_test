import sys
from collections import deque

h,w = map(int, sys.stdin.readline().split())
graph = [["X"]* w for _ in range(h)]
queue = deque()
dest_x,dest_y = 0,0
move = ((1,0),(-1,0),(0,1),(0,-1))
visited = [[False] * w for _ in range(h)]
prev_t = -1

def overflow():
    visited = [[False] * w for _ in range(h)]
    
    for y in range(h):
        for x in range(w):
            if graph[y][x] == "*" and not visited[y][x]:
                for dx,dy in move:
                    nx = x + dx
                    ny = y + dy

                    if 0<=nx<w and 0<=ny<h:
                        if graph[ny][nx] == ".":
                            graph[ny][nx] = "*"
                            visited[ny][nx] = True

for y in range(h):
    line = sys.stdin.readline()
    for x in range(w):
        graph[y][x] = line[x]
        if graph[y][x] == "S":
            queue.append((x,y,0))
            graph[y][x] = "."
            visited[y][x] = True
        if graph[y][x] == "D":
            dest_x,dest_y = x,y
            
while queue:
    x,y,t = queue.popleft()
    
    if x == dest_x and y == dest_y:
        print(t)
        exit(0)
    
    if prev_t != t:
        overflow()
        
    prev_t = t

    for dx,dy in move:
        nx = x + dx
        ny = y + dy

        if 0<=nx<w and 0<=ny<h and not visited[ny][nx]:
            visited[ny][nx] = True
            if graph[ny][nx] != "*" and graph[ny][nx] != "X":
                queue.append((nx,ny,t+1))
                
print("KAKTUS")
