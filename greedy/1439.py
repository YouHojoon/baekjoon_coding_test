import sys

s = sys.stdin.readline()
zero = 0
one = 0
tmp = s[0]

for c in s[1:]:
    if tmp == c:
        continue
    else:
        if tmp[-1] == "0":
            zero += 1
        else:
            one +=1
        tmp = c

print(min(zero,one))
