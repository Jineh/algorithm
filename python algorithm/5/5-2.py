import sys

stack = list(sys.stdin.readline().strip())
my=[]
cnt=0

for i in range(len(stack)):
    if stack[i]=='(':
        my.append(stack[i])
    else:
        my.pop()
        if stack[i-1]=='(':     # 이 전의 값이랑 비교해서 레이저면 스택 값 합침
            cnt+=len(my)
        else:
            cnt+=1              # 막대 끝이면 마지막 막대 하나 더함
print(cnt)
