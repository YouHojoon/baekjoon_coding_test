import sys

dp = [[[0] * 21 for _ in range(21)] for _ in range(21)]

for a in range(21):
    for b in range(21):
        for c in range(21):
            if a <= 0 or b<=0 or c<=0:
                dp[a][b][c] = 1
            elif a < b and b < c:
                dp[a][b][c] = dp[a][b][c -1] + dp[a][b-1][c-1] - dp[a][b-1][c]
            else:
                dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1]
            
while True:
    a,b,c = map(int,sys.stdin.readline().split())
    if a == -1 and b ==-1 and c == -1:
        break
    elif a <= 0 or b <=0 or c<= 0:
        print("w(%d, %d, %d) = 1"%(a,b,c))
    elif a > 20 or b > 20 or c > 20:
        print("w(%d, %d, %d) = %d"%(a,b,c,dp[20][20][20]))
    else: 
        print("w(%d, %d, %d) = %d"%(a,b,c,dp[a][b][c]))


