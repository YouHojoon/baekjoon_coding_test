# 참고 : https://mong9data.tistory.com/66
import sys

s = sys.stdin.readline().split("-")
ans = sum(map(int,s[0].split("+")))
ans -= sum([sum(map(int,s[i].split("+"))) for i in range(1,len(s))])
print(ans)
    
