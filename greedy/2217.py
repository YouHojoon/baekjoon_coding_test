import sys

n = int(sys.stdin.readline())
ropes = [int(sys.stdin.readline()) for _ in range(n)]
ropes.sort()
w = 0

for i in range(n):
    if (n - i) * ropes[i] > w:
        w = (n - i) * ropes[i]

print(w)
