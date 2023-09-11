#참고 : https://velog.io/@waoderboy/알고리즘-백준-16236-아기상어-파이썬
from collections import deque
import sys

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
x,y = 0,0
cnt,t = 0,0
move = ((1,0),(-1,0),(0,1),(0,-1))
size = 2
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            x,y = j, i
            graph[y][x] = 0
            
def bfs(x, y):
    visited = [[0]*n for _ in range(n)]
    queue = deque([(x,y)])
    fishs = []
    visited[y][x] = 1

    while queue:
        x, y = queue.popleft()

        for dx,dy in move:
            nx = x + dx
            ny = y + dy

            if 0<=nx<n and 0<=ny<n and visited[ny][nx] == 0:
                if size > graph[ny][nx] and graph[ny][nx] != 0:
                    visited[ny][nx] =  visited[y][x] + 1
                    fishs.append((nx, ny,visited[ny][nx] - 1))
                elif size == graph[ny][nx] or graph[ny][nx] == 0:
                    visited[ny][nx] =  visited[y][x] + 1
                    queue.append((nx,ny))
                 
    return sorted(fishs, key = lambda x: (x[2], x[1], x[0]))


while True:
    fishs = deque(bfs(x,y))
    
    if not fishs:
        break
        
    x, y, dist = fishs.popleft()
    t += dist
    cnt += 1
    if size == cnt:
        size += 1
        cnt = 0

    graph[y][x] = 0
        
print(t)
