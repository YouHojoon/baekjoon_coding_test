#참고 : https://claude-u.tistory.com/208
import sys

n,k = map(int,sys.stdin.readline().split())
stuffs = [[0,0]] + [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [[0] * (k+1) for _ in range(n+1)]

for i in range(1,n+1):
  for j in range(1,k+1):
        w,v = stuffs[i]
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
            
print(dp[n][k])    
