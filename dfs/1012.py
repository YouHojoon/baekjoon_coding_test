import sys
sys.setrecursionlimit(10000)

def dfs(graph, x, y):
    move = ((1,0),(-1,0),(0,1),(0,-1))
    
    for dx,dy in move:
        new_x = x + dx
        new_y = y + dy
        
        if (0 <= new_x < len(graph[0])) and (0 <= new_y < len(graph)) and graph[new_y][new_x] == 1:
            graph[new_y][new_x] = 0
            dfs(graph,new_x,new_y)
            
n = int(input())

for _ in range(n):
    width, height, k = map(int,input().split(" "))
    cnt = 0
    maps = [[0] * (width) for _ in range(height)]
    
    for _ in range(k):
        j,i = map(int,input().split(" "))
        maps[i][j] = 1
                    
    for y in range(height):
      for x in range(width):
        if maps[y][x] == 1:
          maps[y][x] = 0
          dfs(maps,x,y)
          cnt += 1
    print(cnt)
