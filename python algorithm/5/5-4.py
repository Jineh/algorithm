import sys

a = list(sys.stdin.readline().strip())
b=[]
for i in range(len(a)):
        if a[i].isdecimal():
            b.append(int(a[i]))
        elif a[i]=='+':
            y=b.pop()       # 위에 값이 나중에 계산 되도록 순서 중요
            x=b.pop()
            b.append(x+y)
        elif a[i]=='-':
            y=b.pop()
            x=b.pop()
            b.append(x-y)
        elif a[i]=='*':
            y=b.pop()
            x=b.pop()
            b.append(x*y)
        elif a[i]=='/':
            y=b.pop()
            x=b.pop()
            b.append(x/y)
print(b.pop())



