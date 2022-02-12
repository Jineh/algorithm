import sys

n = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split()))
count=0
for idx, x in enumerate(score):
    if(x==1):
        count+=x
        score[idx]=count
    else:
        count=0
print(sum(score))
