#참고 : https://77dptjd.tistory.com/9
import sys
sys.setrecursionlimit(10**4)

def dfs(graph,x,y,visited):
    move = ((1,0),(-1,0),(0,1),(0,-1))
    visited[y][x] = False

    for dx,dy in move:
        nx = x + dx
        ny = y + dy
        
        if (0<=nx<len(graph[y])) and (0<=ny<len(graph)):
            if visited[ny][nx] and graph[ny][nx] != 0:
                dfs(graph,nx,ny,visited)
                

def melt(graph,x,y, visited):
    move = ((1,0),(-1,0),(0,1),(0,-1))
    
    for dx,dy in move:
        nx = x + dx
        ny = y + dy
        
        if (0<=nx<len(graph[y])) and (0<=ny<len(graph)):
            if not visited[ny][nx] and graph[ny][nx] == 0:
                graph[y][x] -= 1
        if graph[y][x] == 0:
            break
             
                
                
h,w = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
t = 0

while True:
    t+=1
    visited = [[False] * w for _ in range(h)]
    area = 0
    
    for y in range(1,h-1):
        for x in range(1,w-1):
            if graph[y][x] != 0 and not visited[y][x]:
                visited[y][x] = True
                melt(graph,x,y, visited)
               
    for y in range(1,h-1):
        for x in range(1,w-1):
            if graph[y][x] != 0 and visited[y][x]:
                dfs(graph,x,y,visited)
                area += 1
     
    if area >=2:
        print(t)
        break
    elif area == 0:
        print(0)
        break
            
