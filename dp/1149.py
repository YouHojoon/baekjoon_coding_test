import sys

n = int(sys.stdin.readline())
dp = [[0]*3 for _ in range(n)]
graph = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
dp[0] = graph[0]

for i in range(n):
    for j in range(3):
        rgb = [0,1,2]
        rgb.remove(j)
        x,y = rgb
        dp[i][j] = min(dp[i-1][x], dp[i-1][y]) + graph[i][j]
print(min(dp[n-1]))
