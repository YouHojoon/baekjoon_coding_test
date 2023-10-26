import sys
n = sys.stdin.readline().rstrip()
n = sorted(n, reverse=True)

if "0" not in n:
    print(-1)
elif sum(map(int,n)) % 3 != 0: # 모든 자리수의 합이 3의 배수면 3의 배수
    print(-1)
else:
    print(''.join(n))
