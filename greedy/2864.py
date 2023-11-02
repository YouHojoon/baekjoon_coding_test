import sys

a,b = sys.stdin.readline().split()

min_sum = int(a.replace("6","5")) + int(b.replace("6","5"))
max_sum = int(a.replace("5","6")) + int(b.replace("5","6"))

print("%d %d"%(min_sum, max_sum))
