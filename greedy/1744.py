#참고 : https://www.acmicpc.net/problem/1744
import sys
import heapq

def numbers_sum(numbers):
    result = 0
    
    for _ in range(len(numbers) // 2):
        x = heapq.heappop(numbers)
        y = heapq.heappop(numbers)

        result += x*y

    return result

n = int(sys.stdin.readline().rstrip())
negative = []
positive = []

ans = 0
for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    if x > 1:
        positive.append(-x)
    elif x <= 0:
        negative.append(x)
    else:
        ans += x

negative.sort()
positive.sort()

ans += numbers_sum(positive) + numbers_sum(negative)
if negative:
    ans += negative[0]
if positive:
    ans += -positive[0]
print(ans)
