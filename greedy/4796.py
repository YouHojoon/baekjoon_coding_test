import sys
cnt = 1
while True:
    
    l,p,v = map(int,sys.stdin.readline().split())
    if l + p + v == 0:
        break
    q = (v // p)
    ans = q * l
    v -= q * p

    print('Case %d: %d'%(cnt, ans + min(v,l)))
    cnt +=1 

