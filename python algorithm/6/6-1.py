import re
import sys

def DFS(x):
    if x==0:
        return
    else:
        DFS(x//2)
        print(x%2, end='')  # 출력 뒤부터 하고 싶을 때, 재귀함수 다음에 출력

if __name__=="__main__":
    n = int(sys.stdin.readline())
    DFS(n)
