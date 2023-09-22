import sys

h = int(sys.stdin.readline())
tree = [list(map(int,sys.stdin.readline().split())) for _ in range(h)]
dp = [[0]*(n+1) for n in range(h)]
dp[0][0] = tree[0][0]

for i in range(1,h):
    cur = tree[i]
    parent = dp[i-1]
    
    for j in range(len(cur)):
        if j == 0:
            dp[i][j] = parent[0] + cur[j]
        elif j == len(cur) - 1:
            dp[i][j] = parent[-1] + cur[j]
        else:
            lhs = j -1
            rhs = j
            dp[i][j] = max(parent[lhs],parent[rhs]) + cur[j]
            
print(max(dp[-1]))
