import sys
n,k = map(int,sys.stdin.readline().split())
coins = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

dp = [10001] * (k+1)
dp[0] = 0

for coin in coins:
    for j in range(coin, k+1):
         if dp[j - coin] + 1 < dp[j]:
                dp[j] = dp[j -coin] +1
if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])
