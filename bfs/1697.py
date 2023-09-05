#참고 : https://chanhuiseok.github.io/posts/baek-14/
import sys
from collections import deque
def valid(x,visited):
    if (0<=x<=100000) and not visited[x]:
        return True
    else:
        return False
    
n,k = map(int, sys.stdin.readline().split())
queue = deque([(n,0)])
visited = [False] * 100001
visited[n] = True

while queue:
    cur, t  = queue.popleft()
    visited[cur] = True
    if cur != k:
        if valid(cur - 1, visited):
            visited[cur - 1] = True
            queue.append((cur - 1, t + 1))
        if valid(cur + 1, visited):
            visited[cur + 1] = True
            queue.append((cur + 1, t + 1))
        if valid(cur * 2, visited):
            visited[cur * 2] = True
            queue.append((cur * 2, t + 1))
    else:
        break
print(t)
