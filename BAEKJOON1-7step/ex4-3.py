import sys
n=int(sys.stdin.readline())
num = n
i=0

while True:
    a= num//10
    b= num%10
    c= (a+b) %10
    num= (b*10) +c

    i=i+1
    if num==n:
        break

print(i)

    

