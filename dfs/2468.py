import sys
sys.setrecursionlimit(10**8)
def dfs(graph,x,y,h,visited):
    move = ((1,0),(-1,0),(0,1),(0,-1))
    for dx,dy in move:
        new_x = x + dx
        new_y = y + dy

        if (0<=new_x<len(graph[y])) and (0<=new_y<len(graph)):
            if graph[new_y][new_x] > h and not visited[new_y][new_x]:
                visited[new_y][new_x] = True
                dfs(graph,new_x,new_y,h, visited)

n = int(input())
graph = [[0]*n for _ in range(n)]
answer = 0
max_height = 0

for i in range(n):
    graph[i] = list(map(int,input().split(" ")))
    tmp_max = max(graph[i])

    if tmp_max > max_height:
        max_height = tmp_max


for h in range(max_height):
    visited = [[False] * n for _ in range(n)]
    tmp_answer = 0
    for y in range(n):
        for x in range(n):
            if not visited[y][x] and graph[y][x] > h:
                visited[y][x] = True
                dfs(graph,x,y,h,visited)
                tmp_answer += 1
    if tmp_answer > answer:
        answer = tmp_answer


print(answer)
