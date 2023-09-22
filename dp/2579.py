import sys
n = int(sys.stdin.readline())

graph = [int(sys.stdin.readline()) for _ in range(n)]
graph.reverse()
dp = [[0]*2 for _ in range(n)]

if n <= 3:
    if n == 1:
        print(graph[0])
    elif n == 2:
        print(graph[1] + graph[0])
    else:
        print(max(graph[0] + graph[2], graph[0] + graph[1]))
else:
    #마지막 계단
    dp[0][0] = graph[0]
    dp[0][1] = graph[0]

    dp[1][0] = dp[0][1]
    dp[1][1] = dp[0][1] + graph[1]

    dp[2][0] = dp[1][1]
    dp[2][1] = dp[0][1] + graph[2]

    for i in range(3,n):
        dp[i][1] = max(dp[i-2][1] + graph[i], dp[i-2][0] + graph[i] + graph[i-1])
        dp[i][0] = dp[i-1][1]

    print(max(dp[n-1]))
