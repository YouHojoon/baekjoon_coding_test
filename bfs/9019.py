# 참고 : https://aia1235.tistory.com/27
import sys
from collections import deque

k = int(sys.stdin.readline())

for _ in range(k):
    a,b = map(int, sys.stdin.readline().split())
    visited = [False] * 100001
    queue = deque([(a,"")])
    visited[a] = True
    
    while queue:
        a, op = queue.popleft()
        
        if a == b:
            print(op)
            break
        
        D = a * 2 % 10000
        S = (a - 1) % 10000
        L = a // 1000 + (a % 1000) * 10
        R = a // 10 + (a % 10) * 1000
        
        if not visited[D]:
            visited[D] = True
            queue.append((D,op + "D"))
        if not visited[S]:
            visited[S] = True
            queue.append((S,op + "S"))
        if not visited[L]:
            visited[L] = True
            queue.append((L,op + "L"))
        if not visited[R]:
            visited[R] = True
            queue.append((R,op + "R"))
        
