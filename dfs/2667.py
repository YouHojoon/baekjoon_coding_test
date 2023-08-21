def dfs(index, graph, visited, cur):
    for i in graph[index]:
        if visited[i] == 0:
            visited[i] = cur
            dfs(i, graph, visited, cur)
            
n = int(input())
graph = [[] * (n * n) for _ in range(n * n)]
visited = [0] * (n * n)
maps = [[0] * (n) for _ in range(n)]
cur = 1

for i in range(n):
    for j,c in enumerate(input()):
        maps[i][j] = int(c)
        if maps[i][j] == 1:
                if i != 0 and maps[i -1][j] == 1:
                    graph[n * (i-1) + j].append(n*i+j)
                    graph[n * i + j].append(n * (i-1) + j)
                if j != 0 and maps[i][j-1] == 1:
                    graph[n * i + j-1].append(n*i+j)
                    graph[n * i + j].append(n * i + j-1)
                if i != n-1 and maps[i + 1][j] == 1:
                    graph[n * (i+1) + j].append(n*i+j)
                    graph[n * i + j].append(n * (i+1) + j)
                if j != n-1 and maps[i][j+1] == 1:
                    graph[n * i + j+1].append(n*i+j)
                    graph[n * i + j].append(n * i + j+1)
                    
for i in range(n*n):
  if visited[i] == 0 and maps[i//n][i%n] == 1:
    visited[i] = cur
    dfs(i,graph,visited,cur)
    cur += 1
    
total = max(visited)
answer = [0] * total

for i in visited:
  if i != 0:
    answer[i-1] += 1
    
print(total)
answer.sort()
for i in answer:
  print(i)

