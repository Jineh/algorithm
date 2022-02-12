import sys


def digit_sum(x):
    sum =0
    for i in str(x):    # 숫자열 문자열로 변환
        sum+=int(i)
    return sum

N = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

max=0
for i in a:
    tot = digit_sum(i)
    if tot>max:
        max=tot
        res=i
print(res)


    
