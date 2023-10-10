import sys
n = int(sys.stdin.readline())
numbers = [0] + list(map(int,sys.stdin.readline().split()))
dp = [0] * (n+1)

for i in range(1,n+1):
    for j in range(i):
        if numbers[i] > numbers[j]:
            dp[i] = max(dp[j] + numbers[i], dp[i])
print(max(dp))
