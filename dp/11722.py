import sys

n = int(sys.stdin.readline())
numbers = list(map(int,sys.stdin.readline().split()))
dp = [1]* n

for i in range(n):
    for j in range(i):
        if numbers[i] < numbers[j]:
            dp[i] = max(dp[j] + 1, dp[i])
print(max(dp))
