from collections import deque

def dfs(index,graph, visited):
    for i in range(len(graph[index])):
        if graph[index][i] == 1 and i not in visited:
            visited.append(i)
            dfs(i,graph,visited)

def bfs(start,graph, visited):
    queue = deque([start])
  
    while queue:
        cur = queue.popleft()

        for i in range(len(graph[cur])):
            if graph[cur][i] == 1 and i not in visited:
                visited.append(i)
                queue.append(i)

if __name__ == "__main__":
    n,m,v = map(int, input().split(" "))
    graph = [[0] * (n+1) for _ in range(n+1)]
    visited = [v] 
    
    for _ in range(m):
        s,e = map(int, input().split(" "))
        graph[s][e] = 1
        graph[e][s] = 1

    dfs(v, graph, visited)
   
    for i in visited:
      print(i, end=" ")
    print()
    visited = [v]
    bfs(v, graph, visited)
    for i in visited:
      print(i, end=" ")
         
