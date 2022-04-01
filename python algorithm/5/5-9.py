import sys

s1=sys.stdin.readline()
s2=sys.stdin.readline()
d = dict()

for x in s1:
    if x in d:
        d[x]+=1
    else:
        d[x]=0
for x in s2:
    if x in d:
        if d[x]==0:
            print("NO")
            break
        else:
            d[x]-=1
    else:
        print("NO")
else:
    print("YES")

