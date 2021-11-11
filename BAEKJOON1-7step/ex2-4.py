import sys
n=int(sys.stdin.readline())
m=int(sys.stdin.readline())

if n>0 and m>0:
    print("1")
elif n<0 and m>0:
    print("2")
elif n<0 and m<0:
    print("3")
elif n>0 and m<0:
    print("4")