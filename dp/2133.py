# 참고 : https://lemonjade.tistory.com/2
# https://zu-techlog.tistory.com/88

import sys
n = int(sys.stdin.readline())
dp = [0] * 31
dp[2] = 3

for i in range(4,n+1):
    if i % 2 != 0:
        continue
    # i-2 에 3 * 2 를 채운 경우
    # 4, 6...i-4의 각 특수 케이스를 채운 경우
    # i의 특수 케이스
    dp[i] += dp[i - 2] * 3 + sum(dp[:i-2]) * 2 + 2
print(dp[n])
