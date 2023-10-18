import sys
n = int(sys.stdin.readline())

dists = list(map(int,sys.stdin.readline().split()))
citys = list(map(int,sys.stdin.readline().split()))

last_price = citys[0]
ans = last_price * dists[0]

for i in range(1,n-1):
    if last_price > citys[i]:
        last_price = citys[i]
        
    ans += last_price * dists[i]
    
print(ans)
