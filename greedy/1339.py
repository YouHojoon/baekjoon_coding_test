#참고 : https://seongonion.tistory.com/111
import sys

n = int(sys.stdin.readline().rstrip())
strs = [sys.stdin.readline().rstrip() for _ in range(n)]
scores = dict()

for s in strs:
  for i,c in enumerate(s):
    # 문자가 여러번 나올 수 도 있음
    digit = 10 ** (len(s) - i -1) 
    if c not in scores.keys():
        scores[c] = digit
    else:
        scores[c] += digit

keys = sorted(scores.keys(), key=lambda x: scores[x], reverse=True)
cnt = 9
ans = 0

for key in keys:
    scores[key] = cnt
    cnt -= 1

for s in strs:
    for i,c in enumerate(s):
        ans += scores[c] * 10 **(len(s) -1 -i)

print(ans)
