import sys

n,m = map(int,sys.stdin.readline().split())
package_min = 1001
single_min = 1001

for _ in range(m):
    package, single = map(int,sys.stdin.readline().split())
    if single_min > single:
        single_min = single
    if package_min > package:
        package_min = package

if single_min * 6 < package_min:
    package_min = 6 * single_min
    
print(min((n // 6) * package_min + (n % 6) * single_min, (n // 6 + 1) * package_min))


