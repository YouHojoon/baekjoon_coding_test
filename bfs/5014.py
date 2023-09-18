import sys
from collections import deque

f,s,g,u,d = map(int, sys.stdin.readline().split())

visited = [False] * (f+1)
queue = deque([(s,0)])

while queue:
    s,t = queue.popleft()
    
    if s == g:
        print(t)
        exit(0)
    if s + u <= f and not visited[s + u]:
        queue.append((s + u, t+1))
        visited[s+u] = True
        
    if s - d > 0 and not visited[s - d]:
        queue.append((s - d, t+1))
        visited[s-d] = True
        
print("use the stairs")
        
    
