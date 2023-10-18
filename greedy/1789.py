# 참고: https://data-flower.tistory.com/19
import sys

s = int(sys.stdin.readline())
cnt = 0

for i in range(1,s+1):
    if s - i >= 0:
        cnt += 1
        s -= i
    else:
        break
        
        
print(cnt)
