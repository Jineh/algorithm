import sys 

n=int(sys.stdin.readline())
p=dict()        # 딕셔너리, 해쉬 사용법
for i in range(n):
    word = sys.stdin.readline()
    p[word]=1
for i in range(n-1):
    word = sys.stdin.readline()
    p[word]=0     # 단어 나오면 0 체크
for key, val in p.items():
    if val==1:
        print(key)
        break

# n=int(sys.stdin.readline())
# q=[]
# for i in range(n):
#     q.append(sys.stdin.readline())
# for i in range(n-1):
#     x= sys.stdin.readline()
#     q.remove(x)       # 같은 것은 제거
# print(q.pop())        # 남은 것 출력
