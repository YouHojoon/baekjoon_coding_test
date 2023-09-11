# 참고 : https://hongcoding.tistory.com/18
import sys
from collections import deque

h,w = map(int,input().split())
graph = [list(map(int,input())) for _ in range(h)]
queue = deque()
move = ((1,0),(-1,0),(0,1),(0,-1))

# 벽을 부쉈을때와 아닐 때를 같이 기록
visited = [[[0] * 2 for _ in range(w)] for _ in range(h)]
queue.append((0,0,0))

while queue:
    x,y,c = queue.popleft()
    
    if x == w - 1 and y == h - 1:
        print(visited[y][x][c]+1)
        exit(0)
    
    for dx,dy in move:
        nx = x + dx
        ny = y + dy
        
        if 0<=nx<w and 0<=ny<h:
            if graph[ny][nx] == 1 and c == 0:
                visited[ny][nx][1] = visited[y][x][0] + 1
                queue.append((nx,ny,1))
            elif graph[ny][nx] == 0 and visited[ny][nx][c] == 0:
                visited[ny][nx][c] = visited[y][x][c] + 1
                queue.append((nx,ny,c))
                
print(-1)
