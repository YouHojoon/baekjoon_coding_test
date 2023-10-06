#참고 : https://lbdiaryl.tistory.com/167
import sys

n = int(sys.stdin.readline())
numbers = list(map(int,sys.stdin.readline().split()))

dp1 = [1] * n
dp2 = [1] * n


for i in range(n):
    for j in range(i):
        if numbers[j] < numbers[i]:
            dp1[i] = max(dp1[i], dp1[j] + 1)

numbers.reverse()
for i in range(n):
    for j in range(i):
        if numbers[j] < numbers[i]:
            dp2[i] = max(dp2[i], dp2[j] + 1)
dp2.reverse()
for i in range(n):
    dp1[i] += dp2[i] - 1
    
print(max(dp1))
            
            

        
        
    

