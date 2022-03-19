import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
person = list(map(int, sys.stdin.readline().split()))
person.sort()
person = deque(person)  # 리스트 이동은 비효율, 데크 활용
cnt=0
while person:
    if len(person)==1:  # 한 명 남았을 때는 하나의 보트로 취급
        cnt+=1
        break
    if person[0]+person[-1]>m:
        person.pop()
        cnt+=1
    else:                       # 정렬된 상태, 큰 값과 작은 값 계산해서 작으면 pop
        person.popleft()
        person.pop()
        cnt+=1
print(cnt)
        
