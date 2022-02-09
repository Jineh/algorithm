import sys

def reverse(x):
    res =0
    while x>0:
        t=x%10  # 끝 자리 수
        res = res*10+t      # 자리수
        x=x//10
    return res



def isPrime(x):
    if x == 1:
        return False
    for i in range(2,x//2+1):   # 1제외하면 2부터 무조건 절반, 자기 자신까지 +1
        if(x%i==0):
            return False
    else:
        return True



n=int(sys.stdin.readline())
a=list(map(int, sys.stdin.readline().split()))

for i in a:
    x= reverse(i)
    if isPrime(x):
        print(x, end=' ')
