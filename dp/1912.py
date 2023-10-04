import sys
n = int(sys.stdin.readline())
numbers = list(map(int,sys.stdin.readline().split()))


for i in range(1,n):
    numbers[i] = max(numbers[i], numbers[i] + numbers[i-1])
        
print(max(numbers))
    
