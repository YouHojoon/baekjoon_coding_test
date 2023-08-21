def dfs(index,graph,visited):
    for i in graph[index]:
        if not visited[i]:
            visited[i] = True
            dfs(i, graph,visited)

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    s, e = map(int, input().split(" "))
    graph[s].append(e)
    graph[e].append(s)
    
visited[1] = True         
dfs(1, graph, visited)
answer = 0

for i in range(n+1):
    if visited[i]:
        answer+=1
        
print(answer - 1)

