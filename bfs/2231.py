#참고 : https://hseungyeon.tistory.com/245
import sys

n = int(sys.stdin.readline())
ans = 0
for i in range(0,n+1):
    tmp = i + sum(map(int, str(i)))
    if tmp == n:
        ans = i
        break
        
print(ans)


