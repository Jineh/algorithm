import sys
from collections import deque
n, k = map(int, sys.stdin.readline().split())
q=list(range(1, n+1))
dq=deque(q)         # 데큐 변환

while dq:
    for _ in range(k-1):
        cur=dq.popleft() # 맨 앞 pop
        dq.append(cur)   # 맨 뒤 추가
    dq.popleft()       # k번째 pop
    if len(dq)==1:
        print(dq[0])
        dq.popleft()
