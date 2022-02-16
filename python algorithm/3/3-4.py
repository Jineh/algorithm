import sys


a= int(sys.stdin.readline())
n = list(map(int, sys.stdin.readline().split()))
b= int(sys.stdin.readline())
m= list(map(int, sys.stdin.readline().split()))

result=[]
j=0
i=0
while i < a and j < b:
    if(n[i]<=m[j]):
        result.append(n[i])
        i+=1
    else:
        result.append(m[j])
        j+=1

if(i==a):
   result= result +m[j:]    # 리스트 합치기 '+'
if(j==b):
    result = result + n[i:]

for x in result:
    print(x, end=' ')



