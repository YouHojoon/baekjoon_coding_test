#참고 : https://velog.io/@piopiop/백준-9251-LCS-파이썬
import sys

str1 = ' ' + sys.stdin.readline().rstrip()
str2 = ' ' + sys.stdin.readline().rstrip()
dp = [[0] * len(str2) for _ in range(len(str1))]

for i in range(1,len(str1)): 
    for j in range(1, len(str2)):
        if str1[i] == str2[j]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
print(dp[-1][-1])
            

