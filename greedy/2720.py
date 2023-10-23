import sys
k = int(sys.stdin.readline())
coins = [25, 10, 5, 1]

for _ in range(k):
    m = int(sys.stdin.readline())
    ans = [0,0,0,0]
    
    for i in range(4):
        ans[i] = m // coins[i]
        m %= coins[i]
        
    for i in ans:
        print(i,end=" ")
    print()
