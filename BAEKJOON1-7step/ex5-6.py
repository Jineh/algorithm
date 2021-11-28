import sys
n=int(sys.stdin.readline())

for _ in range(n):
    sum=0
    i=0
    a=list(sys.stdin.readline())
    for j in a:
        if j=='O':
            i+=1
            sum=sum+i
        else:
            i=0
    print(sum)
