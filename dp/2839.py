import sys

n = int(sys.stdin.readline())
bag = 0

while n > 0:
    if n % 5 == 0:
        tmp = n // 5
        bag += tmp
        n -= 5 * tmp
        continue
    n -= 3
    bag +=1

if n == 0:
    print(bag)
else:
    print(-1)
