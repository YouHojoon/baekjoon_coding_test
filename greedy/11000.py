import sys
import heapq
n = int(sys.stdin.readline())
sch = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]

sch.sort()
prev = []
ans = 0

while sch:
    start, end = heapq.heappop(sch)
    
    if prev and prev[0] <= start:
        heapq.heappop(prev)
    else:
        ans += 1 
    
    heapq.heappush(prev,end)
    
print(ans)    

