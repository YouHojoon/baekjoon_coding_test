#참고 : https://velog.io/@e_juhee/python-백준-1707-이분-그래프
import sys
sys.setrecursionlimit(10**6)

def dfs(index, graph,visited,group):
    visited[index] = group
    
    for i in graph[index]:
        if visited[i] == 0:
            if not dfs(i,graph,visited,-group):
                return False
        else:
            if visited[i] == group:
                return False
    return True

k = int(input())

for _ in range(k):
    v,e = map(int,sys.stdin.readline().split())
    graph = [[]*(v+1) for _ in range(v+1)]
    visited = [0] * (v+1)
    
    for _ in range(e):
        s,e = map(int,sys.stdin.readline().split())
        graph[s].append(e)
        graph[e].append(s)
        
    for i in range(1,v+1):
        if visited[i] == 0:
            if not dfs(i,graph,visited,1):
                print("NO")
                break
        
        if i == v:
            print("YES")
    
