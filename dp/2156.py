import sys

n = int(sys.stdin.readline())
wines = [0] + [int(sys.stdin.readline()) for _ in range(n)]
dp = [0] * (n+1)

if n == 1:
    print(wines[1])
elif n == 2:
    print(sum(wines[1:3]))
elif n == 3:
    print(max(sum(wines[1:3]), sum(wines[1:4:2])))
else:
    dp[1] = wines[1]
    dp[2] = sum(wines[1:3])
    for i in range(3,n+1):
        dp[i] = max(dp[i-1], dp[i-2] + wines[i], dp[i-3] + wines[i-1] + wines[i])
   
    print(max(dp))
    
    

