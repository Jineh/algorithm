import sys

def DFS(L, s):
    global cnt
    if L==m:
        for a in res:
            print(a, end=' ')
        print()
        cnt+=1
        return
    else:
        for i in range(s, n+1):     # 조합은 자기 이전의 숫자를 찾지 않음
                res[L]=i            # s=start 값을 주어 이전의 값은 판별 x
                DFS(L+1, i+1)
            

if __name__=="__main__":
    n, m = map(int, sys.stdin.readline().split())
    cnt=0
    res=[0]*m
    DFS(0, 1)
    print(cnt)