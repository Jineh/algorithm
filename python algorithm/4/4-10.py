import sys 

n=int(sys.stdin.readline())
a=list(map(int, sys.stdin.readline().split()))
seq=[0]*n
for i in range(n):
    for j in range(n):
        if a[i]==0 and seq[j]==0:   
            seq[j]=i+1              # 0부터 시작하니까
            break
        elif seq[j]==0:             # 빈자리 였을 때만, 
            a[i]-=1                 # 오름차순이어서 먼저 들어가 있는 값은 무조건 작음
for x in seq:
    print(x, end=' ')