#참고 : https://studyandwrite.tistory.com/387
def dfs(graph,x, y, visited):
    if x == len(graph[y])-1 and y == len(graph)-1:
        return 1
    if visited[y][x] != -1:
        return visited[y][x]
    
    result = 0
    for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
        nx, ny = x + dx, y + dy
        if 0 <= nx < w and 0 <= ny < h and graph[y][x] > graph[ny][nx]:
            result += dfs(graph,nx, ny,visited)
    
    visited[y][x] = result
    return visited[y][x]

h,w = map(int,input().split())
graph = [[0]* w for _ in range(h)]


for y in range(h):
    for x,v in enumerate(map(int,input().split())):
        graph[y][x] = v


visited = [[-1] * w for _ in range(h)]
print(dfs(graph,0,0,visited))
