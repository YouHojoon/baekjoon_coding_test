# 참고 : https://velog.io/@uoayop/BOJ-1010-다리-놓기Python
import sys
k = int(sys.stdin.readline())

for _ in range(k):
    n,m = map(int, sys.stdin.readline().split())
    dp = [[0] * (m+1) for _ in range(n+1)]
    
    for i in range(1,m+1):
        dp[1][i] = i
        
    for i in range(2,n+1):
        for j in range(i, m+1):
            for k in range(j,i-1,-1):
                dp[i][j] += dp[i-1][k-1]
                
    print(dp[n][m])
