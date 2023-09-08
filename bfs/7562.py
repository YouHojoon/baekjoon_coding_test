import sys
from collections import deque
input = sys.stdin.readline
move = ((-1,2),(-2,1),(-1,-2),(-2,-1),(1,2),(2,-1),(1,-2),(2,1))
k = int(input())

for _ in range(k):
    l = int(input())

    graph = [[0] * l for _ in range(l)]
    queue = deque()

    x,y = map(int, input().split())
    i,j = map(int, input().split())

    queue.append((x,y))
    graph[y][x] = 1
    
    while queue:
        x,y = queue.popleft()

        if x == i and y == j:
            print(graph[y][x] - 1)
            break

        for dx,dy in move:
            nx = dx + x
            ny = dy + y

            if 0<=nx<l and 0<=ny<l and graph[ny][nx] == 0:
                graph[ny][nx] = graph[y][x] + 1
                queue.append((nx,ny))
