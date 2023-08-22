import copy
import sys

sys.setrecursionlimit(10000)
def dfs(graph,x,y,visited,isBlind=False):
    c = graph[y][x]
    move = ((1,0),(-1,0),(0,1),(0,-1))

    for dx,dy in move:
        new_x = x + dx
        new_y = y + dy
        
        if (0<=new_x<len(graph)) and (0<=new_y<len(graph)) and not visited[new_y][new_x]:
            new_c = graph[new_y][new_x]
            if new_c == c or (new_c == "R" or new_c == "G") and (c == "R" or c == "G") and isBlind:
                visited[new_y][new_x] = True
                dfs(graph,new_x,new_y,visited,isBlind)
                
            
n = int(input())
graph = [["V"] * n for _ in range(n)]
visited1 = [[False] * n for _ in range(n)]
visited2 = [[False] * n for _ in range(n)]
answer1 = 0
answer2 = 0

for y in range(n):
    for x,c in enumerate(input()):
        graph[y][x] = c

for y in range(n):
    for x in range(n):
        if not visited1[y][x]:
            visited1[y][x] = True
            dfs(graph,x,y,visited1)
            answer1+=1
           
            
        if not visited2[y][x]:
            visited2[y][x] = True
            dfs(graph,x,y,visited2, True)
            answer2+=1
            
print("%d %d"%(answer1, answer2))


