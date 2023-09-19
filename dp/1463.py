# 참고 : https://jae04099.tistory.com/199
import sys
n = int(sys.stdin.readline())
dp = [0] * (n + 1)

for i in range(2, n + 1):
    dp[i] = dp[i - 1] + 1 # 1을 뺐을 때의 결과
    
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2] + 1)
        
print(dp[n])
    
    
