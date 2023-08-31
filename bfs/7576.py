# 참고 : https://jae04099.tistory.com/entry/%EB%B0%B1%EC%A4%80-7576-%ED%86%A0%EB%A7%88%ED%86%A0-%ED%8C%8C%EC%9D%B4%EC%8D%AC-%ED%95%B4%EC%84%A4%ED%8F%AC%ED%95%A8

import sys
from collections import deque

w,h = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(h)]
move = ((1,0),(-1,0),(0,1),(0,-1))
t = 0
queue = deque()

for y in range(h):
  for x in range(w):
    if graph[y][x] == 1:
      queue.append((x,y))

while queue:
  x,y = queue.popleft()
  for dx,dy in move:
    nx = x + dx
    ny = y + dy

    if (0<=nx<w) and (0<=ny<h):
      if graph[ny][nx] == 0:
        graph[ny][nx] = graph[y][x] + 1
        queue.append((nx,ny))


for i in graph:
  for j in i:
    if j == 0:
      print(-1)
      exit(0)
  t = max(t,max(i))

print(t - 1)

