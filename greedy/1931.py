#참고 : https://suri78.tistory.com/26
import sys
n = int(sys.stdin.readline())

sch = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
sch = sorted(sch, key = lambda x: (x[1],x[0]))

cnt = 1
t = sch[0][1]

for i in range(1,n):
    if sch[i][0] >= t:
        cnt+= 1
        t = sch[i][1]
        
print(cnt)
