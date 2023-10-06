# 참고 : https://codingwonny.tistory.com/306
import sys

n,m = map(int,sys.stdin.readline().split())
graph = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
dp = [[0] * (n+1) for _ in range(n+1)]

for y in range(1,n+1):
    for x in range(1,n+1):
        dp[y][x] = dp[y-1][x] + dp[y][x-1] - dp[y-1][x-1] + graph[y-1][x-1]

for _ in range(m):
    y1,x1,y2,x2 = map(int,sys.stdin.readline().split())
    ans = dp[y2][x2] - dp[y2][x1-1] - dp[y1-1][x2] + dp[y1-1][x1-1]
    print(ans)
