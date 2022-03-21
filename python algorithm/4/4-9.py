import sys

n=int(sys.stdin.readline())
a=list(map(int, sys.stdin.readline().split()))

lt=0
rt=n-1
x=0
res =""
tmp=[]

while lt<=rt:
    if a[lt]>x:
        tmp.append((a[lt], 'L'))    # 튜플로 값, 문자 저장
    if a[rt]>x:
        tmp.append((a[rt], 'R'))
    tmp.sort()
    if len(tmp)==0:     # 길이 0이면 증가하는 수열이 아니므로 멈춤
        break
    else:
        res=res+tmp[0][1]
        x=tmp[0][0]
        if tmp[0][1]=='L':      # 왼, 오른쪽 확인해서 포인터 이동
            lt=lt+1
        else:
            rt=rt-1
    tmp.clear()         # 리스트 비움

print(len(res))
print(res)


    
        