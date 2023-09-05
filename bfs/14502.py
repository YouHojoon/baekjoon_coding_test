#참고 : https://heytech.tistory.com/368
import sys
import copy
from itertools import combinations

ans = 0
h, w = map(int,sys.stdin.readline().split())
graph = [list(map(int,sys.stdin.readline().split())) for _ in range(h)]
empty = [(x,y) for x in range(w) for y in range(h) if graph[y][x] == 0]
move = ((1,0),(-1,0),(0,1),(0,-1))

for comb in combinations(empty, 3):
        tmp = copy.deepcopy(graph)
        for x, y in comb:
            tmp[y][x] = 1
    
        virus = [(x, y) for x in range(w) for y in range(h) if tmp[y][x] == 2]
       
        while virus:
            x, y = virus.pop()
            for dx, dy in move:
                nx = x + dx
                ny = y + dy
                if 0 <= nx < w and 0 <= ny < h and tmp[ny][nx] == 0:
                    tmp[ny][nx] = 2
                    virus.append((nx, ny)) 
        
        cnt = 0
        for row in tmp:
            cnt += row.count(0)
        ans = max(ans, cnt)
            
print(ans)
