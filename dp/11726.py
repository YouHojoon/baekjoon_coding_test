#참고 : https://duckracoon.tistory.com/entry/백준-11726-2xn-타일링-해설-python
import sys
n = int(sys.stdin.readline())

dp = [0] * (n+1)

if n == 1:
    print(1)
elif n == 2:
    print(2)
else:
    dp[1] = 1
    dp[2] = 2

    for i in range(3,n+1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
        
    print(dp[n])
