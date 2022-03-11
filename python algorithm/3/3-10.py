import sys
def check(a):
    for i in range(9):      # 행, 열 검사
        ch1=[0]*10
        ch2=[0]*10
        for j in range(9):   # 숫자 1 체크 중복 시 다른 숫자는 0
            ch1[a[i][j]]=1
            ch2[a[j][i]]=1
        if sum(ch1)!=9 or sum(ch2)!=9:
            return False
    for i in range(3):      # 그룹 검사
        for j in range(3):
            ch3=[0]*10
            for k in range(3):
                for s in range(3):
                    ch3[a[i*3+k][j*3+s]]=1  # 그룹 안에서 위치
            if sum(ch3)!=9:
                return False
    return True

a=[list(map(int, sys.stdin.readline().split())) for _ in range(9)]
if check(a):
    print("YES")
else:
    print("NO")