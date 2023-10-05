#참고 : https://infinitt.tistory.com/250
import sys
n = int(sys.stdin.readline())
p_list = [0] + list(map(int,sys.stdin.readline().split()))
dp = [0] * (n+1)

for i in range(1, n+1):
    for j in range(1,i+1):
        dp[i]= max(dp[i], dp[i-j] + p_list[j])
        
print(dp[n])
