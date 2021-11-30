import sys
a=set()

for i in range(10):
    a.add(int(sys.stdin.readline())%42)

print(len(a))