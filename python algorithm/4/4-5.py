import sys

n = int(sys.stdin.readline())
meeting=[]
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    meeting.append((a, b))   # 튜플 형식으로 저장
meeting.sort(key=lambda x : (x[1], x[0]))     # 람다 함수로 두 번째 값 정렬
et=0
cnt=0
for x, y in meeting:
    if x>=et:   # 첫 번째 값 비교해서 크거나 같으면 카운트
        et=y
        cnt+=1
print(cnt)





