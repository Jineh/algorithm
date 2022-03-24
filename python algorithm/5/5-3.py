import sys
a = list(sys.stdin.readline().strip())
stack=[]
res=''
for x in a:
    if x.isdecimal():
        res+=x
    else:
        if x=='(':
            stack.append(x)
        elif x=='*' or x=='/':
            while stack and (stack[-1]=='*' or stack[-1]=='/'):
                # 같은 순위라면 pop하고 출력
                res+=stack.pop()
            stack.append(x)
        elif x=='+' or x=='-':
            while stack and stack[-1]!='(':
                # 제일 순위가 낮아서 이전의 값들 다 출력, 괄호 값일 수도 있어서
                res+=stack.pop()
            stack.append(x)
        elif x==')':
            # 괄호 끝나면 그 전의 값 다 출력
            while stack and stack[-1]!='(':
                res+=stack.pop()
            stack.pop()
while stack:    # 남은 연산자 값 뒤에서부터 다 출력
    res+=stack.pop()
print(res)
