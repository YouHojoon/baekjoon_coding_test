import sys
sys.setrecursionlimit(10**6)

n = int(input())
parent = [0] * (n+1)
graph = [[] * (n+1) for _ in range(n+1)]

for _ in range(n-1):
    x,y = map(int,input().split(" "))
    graph[x].append(y)
    graph[y].append(x)

stack = [1]

while len(stack) != 0:
    cur = stack.pop()
    
    for i in graph[cur]:
        if parent[i] == 0:
            parent[i] = cur
            stack.append(i)
        
        
for i in parent[2:]:
    print(i)
