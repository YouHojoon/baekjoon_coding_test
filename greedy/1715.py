import sys
import heapq

n = int(sys.stdin.readline())
cards = [int(sys.stdin.readline()) for _  in range(n)]
ans = 0

if n == 1:
    print(0)

else:
    heapq.heapify(cards)
    while len(cards) >= 2:
        new_card = heapq.heappop(cards) + heapq.heappop(cards)
        heapq.heappush(cards, new_card)
        ans += new_card

    print(ans)
