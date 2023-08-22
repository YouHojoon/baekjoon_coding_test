import copy
import sys

sys.setrecursionlimit(10000)
result = []

def dfs(graph,x,y):
  move = ((1,0),(-1,0),(0,1),(0,-1),(1,1),(1,-1),(-1,1),(-1,-1))

  for dx,dy in move:
    new_x = x + dx
    new_y = y + dy

    if (0<= new_x<len(graph[y])) and (0<= new_y <len(graph)) and graph[new_y][new_x] == 1:
      graph[new_y][new_x] = 0
      dfs(graph,new_x,new_y)



while True:
  w, h = map(int,input().split(" "))
  graph = [[0]*w for _ in range(h)]
  answer = 0
  if w == 0 and h == 0:
    break

  for y in range(h):
    string = input()
    for i in range(0,len(string),2):
      graph[y][i//2] = int(string[i])
  
  for y in range(h):
    for x in range(w):
      if graph[y][x] == 1:
        graph[y][x] = 0
        dfs(graph,x,y)
        answer +=1
  
  result.append(answer)


for i in result:
  print(i)

