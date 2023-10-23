import sys
t = int(sys.stdin.readline())

ans = [0,0,0]
buttons = [300,60,10]

if t % 10 != 0:
    print(-1)
else:
    for i in range(3):
        ans[i] = t // buttons[i]
        t %= buttons[i]

    for i in ans:
        print(i, end=" ")
    
