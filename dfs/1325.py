n,m  = map(int, input().split(" "))
graph = [[]* (n+1) for _ in range(n+1)]

for _ in range(m):
    a,b = map(int, input().split(" "))
    graph[b].append(a)

answer_sum = 0
answers = []

for i in range(1,n+1):
    tmp_sum = 0
    visited = [False] * (n+1)
    stack = [i]
    visited[i] = True

    if len(graph[i]) > 0:
      while len(stack) > 0:
        cur = stack.pop()

        for j in graph[cur]:
          if not visited[j]:
            visited[j] = True
            tmp_sum += 1
            stack.append(j)
              
      if tmp_sum > answer_sum:
          answer_sum = tmp_sum
          answers = [i]

      elif tmp_sum == answer_sum:
        answers.append(i)


for i in answers:
  print(i, end=" ")
