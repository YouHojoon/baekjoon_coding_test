#참고 : https://bio-info.tistory.com/195
import sys
import heapq

n,k = map(int, sys.stdin.readline().split())
jewels = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
bags = [int(sys.stdin.readline()) for _ in range(k)]

jewels.sort()
bags.sort()
ans = 0
max_h = []
for bag in bags:
    while jewels and jewels[0][0] <= bag:
        heapq.heappush(max_h, -jewels[0][1])
        heapq.heappop(jewels)
    
    if max_h:
        ans -= heapq.heappop(max_h)
    
    
print(ans)
    


