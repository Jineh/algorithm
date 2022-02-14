import sys

str = sys.stdin.readline().strip()
res =0

for i in str:
    if i.isdecimal():       # 0-9 숫자 확인
        res = res*10+int(i)
print(res)
cnt=0
for i in range(1, res+1):
    if res%i==0:        # 약수
        cnt+=1
print(cnt)