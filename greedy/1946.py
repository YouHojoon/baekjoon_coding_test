#참고 : https://codingpractices.tistory.com/entry/Python-백준-1946번-이해하기
import sys

k = int(sys.stdin.readline())

for _ in range(k):
    n = int(sys.stdin.readline())
    
    scores = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
    scores = sorted(scores)
    
    cnt = 1
    x = scores[0][1]
    
    for i in range(1,n):
        if x > scores[i][1]:
            cnt += 1
            x = scores[i][1]
            
    print(cnt)
