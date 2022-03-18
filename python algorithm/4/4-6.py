import sys
from tkinter import Y

n= int(sys.stdin.readline())
person =[]
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    person.append((a, b))
person.sort(reverse=True)   # 처음 값으로 내림차순
largest=0
cnt=0
for a, b in person:
    if b>largest:   # 두 번째 값은 위의 값만 비교하면 됨, 그래서 최댓값 구하는 방식으로 정렬
        largest=b
        cnt+=1
print(cnt)
