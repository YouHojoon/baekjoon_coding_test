#참고 : https://velog.io/@rovna/백준-1213번-팰린드롬-만들기
import sys

chars = dict()

for c in sys.stdin.readline().rstrip():
    if c not in chars.keys():
        chars[c] = 1
    else:
        chars[c] += 1
cnt = 0
mid = ''
ans = ''

for k,v in sorted(chars.items()):
    if v % 2 != 0:
        cnt += 1
        mid = k
        if cnt > 1:
            print("I'm Sorry Hansoo")
            exit()
    
    ans += k * (v // 2)

        
print(ans + mid + ans[::-1])        
        
