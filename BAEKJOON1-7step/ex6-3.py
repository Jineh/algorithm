import sys

def hansu(n):
    if n < 100:
        hansu = n
    else:
        hansu = 99
        for i in range(100, n+1):
            num = list(map(int,str(i)))

            if num[0] - num[1] == num[1] - num[2]:
                hansu +=1
    return hansu

num = int(sys.stdin.readline())
print(hansu(num))