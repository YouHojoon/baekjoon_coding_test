# 참고 : https://wonyoung2257.tistory.com/65
import sys
import heapq
n,l = map(int,sys.stdin.readline().split())
p = list(map(int,sys.stdin.readline().split()))
p.sort()
ans = 1
start = p[0] - 0.5

for x in p[1:]:
    if start <= x <= start + l:
        continue
    else:
        ans += 1
        start = x - 0.5
print(ans)
