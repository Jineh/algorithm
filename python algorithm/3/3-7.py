import sys

n = int(sys.stdin.readline())
a=[]
mySum=0
m = n//2 
for i in range(0, m, 2):
        mySum=sum(a[m-1:m-1+i])

for i in range(n-3, 0, -2):
        mySum=sum(a[m-1:m-1+i])