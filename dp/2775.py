import sys
t = int(sys.stdin.readline())

for _ in range(t):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    
    dp = [[0]*(n+1) for _ in range(k+1)]
    
    for i in range(k+1):
        for j in range(1, n+1):
            dp[i][j] = sum(dp[i - 1][:j+1]) if i != 0 else j
    print(dp[k][n])
