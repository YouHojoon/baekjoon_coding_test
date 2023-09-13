import sys
from collections import deque

n,l,r = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
move = ((1,0),(-1,0),(0,1),(0,-1))

def bfs(x,y, visited):
    queue1 = deque([(x,y)])
    queue2 = [(x,y)]
    visited[y][x] = True
    
    while queue1:
        x,y = queue1.popleft()
        
        for dx,dy in move:
            nx = x + dx
            ny = y + dy
                    
            if 0<=nx<n and 0<=ny<n and not visited[ny][nx]:
                #연합 발견시 
                if l<= abs(graph[y][x] - graph[ny][nx]) <=r:                     
                    queue1.append((nx,ny))
                    queue2.append((nx,ny))
                    visited[ny][nx] = True
                        
    return queue2
        
for i in range(2000):
    visited = [[False]*n for _ in range(n)]
    flag = False
    
    for y in range(n):
        for x in range(n):
            if not visited[y][x]:
                union = bfs(x,y,visited)
                
                if len(union) > 1:
                    flag = True
                    people = sum(graph[y][x] for x,y in union) // len(union)
                    
                    for j,k in union:
                        graph[k][j] = people        
    if not flag:
        print(i)
        break
            
            
