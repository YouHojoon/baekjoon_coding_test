import sys
sys.setrecursionlimit(10**4)
def dfs(graph,x,y,answers,answers_index):
    move = ((1,0),(-1,0),(0,1),(0,-1))
    
    for dx,dy in move:
        new_x = dx + x
        new_y = dy + y
        
        if (0<=new_x<len(graph[y])) and (0<=new_y<len(graph)):
            if graph[new_y][new_x] == 0:
                graph[new_y][new_x] = 1
                answers[answers_index] +=1
                dfs(graph,new_x,new_y,answers,answers_index)
                

h,w,k = map(int,input().split(" "))
graph = [[0] * (w) for _ in range(h)]

answers = []
answers_index = -1

for _ in range(k):
    lx,ly,rx,ry = map(int,input().split(" "))
    
    for y in range(ly,ry):
        for x in range(lx, rx):
            graph[y][x] = 1
 
for y in range(h):
    for x in range(w):
        if graph[y][x] == 0:
            graph[y][x] = 1
            answers.append(1)
            answers_index +=1
            dfs(graph,x,y,answers, answers_index)
            
answers.sort()
print(len(answers))
for i in answers:
    print(i,end=" ")
