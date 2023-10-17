import sys
n = int(sys.stdin.readline())
a = sorted(list(map(int,sys.stdin.readline().split())))
b = list(map(int,sys.stdin.readline().split()))

indexs = sorted(range(n), key= lambda x: b[x], reverse=True)

ans = sum([a[i] * b[indexs[i]] for i in range(len(a))])
print(ans)

