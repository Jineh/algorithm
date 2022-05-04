import sys

def DFS(L, P):
    global cnt
    if L==n:
        cnt+=1
        for j in range(P):
            print(chr(res[j]+64), end='')       # 알바벳 출력
        print()
    else:
        for i in range(1, 27):
            if code[L]==i:      # 한자리 숫자
                res[P]=i
                DFS(L+1, P+1)
            elif i >=10 and code[L]==i//10 and code[L+1]==i%10:     # 두 자리 숫자
                res[P]=i
                DFS(L+2, P+1)


if __name__=="__main__":
    code = list(map(int, sys.stdin.readline().strip()))
    n=len(code)
    code.insert(n, -1)      # 마지막 값 비교 때 인덱스 오버 안 되게 추가
    res=[0]*(n+3)
    cnt=0
    DFS(0, 0)
    print(cnt)