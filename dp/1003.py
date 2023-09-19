import sys
k = int(sys.stdin.readline())

for _ in range(k):
    n = int(sys.stdin.readline())
    dp = [[0]* 2 for _ in range(n+1)] 
    
    if n == 0:
        print("1 0")
        continue
    if n == 1:
        print("0 1")
        continue
        
    dp[0][0] = 1
    dp[0][1] = 0
    
    dp[1][0] = 0
    dp[1][1] = 1
    
    for i in range(2, n+1):
        dp[i][0] = dp[i-1][0] + dp[i-2][0]
        dp[i][1] = dp[i-1][1] + dp[i-2][1]
    
    print("%d %d"%(dp[n][0], dp[n][1]))
