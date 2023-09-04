import sys
n = int(input())

persons = []

scores = [0] * n
grades = [0] * n

for _ in range(n):
    x,y = map(int, input().split())
    persons.append((x,y))

for i in range(n):
    rank = 1
    for j in range(n):
      if i == j:
        continue

      x,y = persons[i]
      p,q = persons[j]
        
      if x < p and y < q:
          rank += 1
    print(rank, end=" ")

        

