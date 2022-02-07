import sys

n =int(sys.stdin.readline())
a=list(map(int, sys.stdin.readline().split()))
ave = int((sum(a)/n) + 0.5)  # 소수 첫 번째 자리에서 반올림
min = 2147000000

for idx, x in enumerate(a):
    tmp = abs(x-ave)
    if tmp < min:
        min = tmp
        score = x
        res = idx+1
    elif tmp == min:    # 거리가 같을 때 본 점수 큰 것으로 선택
        if x> score:
            score = x
            res = idx + 1
print(ave, res)
    

