# 참고 : https://it-garden.tistory.com/341

import sys

n,k = map(int,sys.stdin.readline().split())
dp = [[0] * 201 for _ in range(201)] 

for i in range(201):
    dp[1][i] = 1 #1로 만들 수 있는 건 자기 자신
    dp[2][i] = 1 + i
    
for i in range(2,201):
    dp[i][1] = i
    for j in range(2,201):
        dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000
        
print(dp[k][n])
