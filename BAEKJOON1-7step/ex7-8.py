import sys
str = sys.stdin.readline()
number = ['ABC','DEF', 'GHI','JKL','MNO','PQRS','TUV','WXYZ']
result=0

for i in str:
    for j in number:
        if i in j:
            result+=number.index(j)+3

print(result)