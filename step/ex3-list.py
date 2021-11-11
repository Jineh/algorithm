import sys

mlist=list(sys.stdin.readline().strip())
n=int(sys.stdin.readline())
mlist2=[]

for i in range(n):
    cmd = sys.stdin.readline().split()

    if cmd[0] == 'L' and mlist != []:
        mlist2.append(mlist.pop())
    elif cmd[0] == 'D' and mlist2 != []:
        mlist.append(mlist2.pop())
    elif cmd[0] == 'B' and mlist != []:
        mlist.pop()
    elif cmd[0] == 'P':
        mlist.append(cmd[1])

print("".join(mlist + list(reversed(mlist2))))
