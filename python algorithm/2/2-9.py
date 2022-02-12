import sys

n = int(sys.stdin.readline())
result =[0]*(n)
maxResult = 0

for i in range(n):
    
    a=list(map(int,sys.stdin.readline().split()))
    if a[0]==a[1]==a[2]:
        result[i]=10000 + a[0]*1000
    elif a[0]==a[1] or a[0]==a[2]:
        result[i] = 1000+a[0]*100
    elif a[1]==a[2]:
        result[i] = 1000+a[0]*100
    else:
        max=a[0]
        if a[1]>max:
            max=a[1]
        if a[2]>max:
            max=a[2]
        result[i] = max*100
    if result[i]>maxResult:
        maxResult = result[i]
print(maxResult)
    



