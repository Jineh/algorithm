import sys

num, m = map(int, sys.stdin.readline().split())
num = list(map(int, str(num)))      # str -> int -> list 삽입
stack =[]
for x in num:
    while stack and m>0 and stack[-1]<x:    # 빈 리스트가 아니고, m>0이고 마지막 리스트 값이 작으면
        stack.pop()
        m-=1
    stack.append(x)
if m!=0:                # 자릿수가 0이 아닐때 뒤에 부분 제거
    stack=stack[:-m]
res=''.join(map(str, stack))
print(res)
