import sys

n, k = map(int, sys.stdin.readline().split())
a=list(map(int, sys.stdin.readline().split()))
b=set()     # 중복을 무시

for i in range(n):
    for j in range(i+1, n):
        for m in range(j+1, n):
            b.add(a[i] + a[j] + a[m])

b=list(b)   # 집합을 리스트 형태로 변경
b.sort(reverse=True)    #내림차순
print(b[k-1])