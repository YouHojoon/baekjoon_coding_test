import sys

n, k = map(int,sys.stdin.readline().split())
dp = [1] * (k+1)
ans = 1
for i in range(1,k+1):
    dp[i] = dp[i-1] * i
    
for i in range(k):
    ans *= (n - i)

print(ans // dp[k] % 10007)
    

