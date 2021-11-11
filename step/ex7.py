import sys

n=int(sys.stdin.readline())
a= sys.stdin.readline().split()
m=int(sys.stdin.readline())
b= sys.stdin.readline().split()

for i in b:
    c=0
    for j in range(n):
        if i == a[j]:
            c=1
    print(c)
