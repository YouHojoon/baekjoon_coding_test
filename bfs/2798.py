# 참고 : https://day-moonlight.tistory.com/18
import sys

n,m = map(int,sys.stdin.readline().split())
cards = list(map(int,sys.stdin.readline().split()))
result = 0

for i in range(0, n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            tmp = cards[i] + cards[j] + cards[k]
            if tmp > m:
                continue
            elif tmp > result:
                result = tmp
print(result)
            
