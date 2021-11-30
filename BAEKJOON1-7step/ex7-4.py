import sys
n=int(sys.stdin.readline())

for _ in range(n):
    str = sys.stdin.readline().split()
    for i in str[1]:
        print(i*int(str[0]), end='')
    print()

