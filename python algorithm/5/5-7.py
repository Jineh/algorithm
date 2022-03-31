import sys
from collections import deque

m= sys.stdin.readline()
n = int(sys.stdin.readline())

for i in range(n):
    plan =  sys.stdin.readline()
    dq=deque(m)
    for x in plan:
        if x in dq:             # 큐 안에 있을 때
            if x!=dq.popleft(): # 맨 앞부터 순서대로 확인
                print("#%d NO" %(i+1))
                break
    else:
        if len(dq)==0:          # 아예 선행 과목이 없을 때도 있어서 체크
            print("#%d YES" %(i+1))
        else:
            print("#%d NO" %(i+1))