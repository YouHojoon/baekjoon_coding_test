import sys
sys.setrecursionlimit(10*5)
def dfs(graph,x,y,depth,visited):
    move = ((1,0),(-1,0),(0,1),(0,-1))
    result = depth
    
    for dx,dy in move:
        new_x = x + dx
        new_y = y + dy
        
        if (0<=new_x<len(graph[y])) and (0<=new_y<len(graph)):
            c = graph[new_y][new_x]
            
            if not visited[ord(c)- ord('A')]:
                visited[ord(c)- ord('A')] = True
                
                tmp_result = dfs(graph,new_x,new_y, depth + 1, visited)
                if tmp_result > result:
                    result = tmp_result
                visited[ord(c)- ord('A')] = False
                
    return result
                    
h,w = map(int,input().split(" "))
graph = [["0"] * w for _ in range(h)]
visited = [False] * 26

for y in range(h):
    for x,c in enumerate(input()):
        graph[y][x] = c
        
        
visited[ord(graph[0][0]) - ord('A')] = True

print(dfs(graph,0,0,1,visited))
