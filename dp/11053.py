import sys

n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split()))
dp = [1] * n

for i in range(1,n):
    for j in range(i-1, -1, -1):
        if arr[i] > arr[j]:
            dp[i] = dp[j] + 1 if dp[i] < dp[j] + 1 else dp[i]
            
print(max(dp))
