import sys
k = int(sys.stdin.readline())
dp = [-1] * 101

dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

for _ in range(k):
    cur = 1
    n = int(sys.stdin.readline())
    
    if dp[n] != -1:
        print(dp[n])
        continue
    
    for i in range(6,n+1):
        dp[i] = dp[i-1] + dp[cur]
        cur += 1
        
    print(dp[n])
        
        
        
        
