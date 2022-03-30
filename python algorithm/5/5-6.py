import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())
Q=[(pos, val) for pos, val in enumerate(list(map(int, sys.stdin.readline().split())))]
Q=deque(Q)
cnt=0
while True:
    cur=Q.popleft()
    if any(cur[1]<x[1] for x in Q):     # 하나라도 맞으면 참
        Q.append(cur)
    else:
        cnt+=1
        if cur[0]==m:
            print(cnt)
            break

# q=list(map(int, sys.stdin.readline().split()))
# dq = deque(q)
# cnt=0
# point = m

# while dq:
#     a=dq.popleft()
#     if a<max(dq):
#         dq.append(a)
#         if point ==0:
#             point=len(dq)-1
#         else:
#             point-=1
#     elif a>=max(dq) and point==0:
#         cnt+=1
#         print(cnt)
#         break
#     else:
#         cnt+=1
#         point-=1



