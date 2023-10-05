#참고 : https://hongcoding.tistory.com/115
import sys
t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    stickers = [list(map(int,sys.stdin.readline().split())) for _ in range(2)]
    #(0,0) , (0,1) 둘 중에 하나로 시작  
    if n > 1:
        stickers[0][1] += stickers[1][0]
        stickers[1][1] += stickers[0][0]
    
        for i in range(2,n):
            # [0][i-2]을 고려하지 않는 이유는 [1][i-1]에 누적되어 있기 때문
            stickers[0][i] += max(stickers[1][i-1], stickers[1][i-2])
            stickers[1][i] += max(stickers[0][i-1], stickers[0][i-2])
        
    print(max(stickers[0][-1], stickers[1][-1]))
