#참고 : https://mong9data.tistory.com/68

import sys
n, k = map(int,sys.stdin.readline().split())
coins = [int(sys.stdin.readline()) for _ in range(n)]
dp = [0 for i in range(k+1)]
dp[0] = 1 # 동전 하나 사용을 위해
for coin in coins:
    for j in range(coin, k+1):
        if j-coin >= 0:
            dp[j] += dp[j-coin] # j==coin 이면 0이된다
    
print(dp[k])
