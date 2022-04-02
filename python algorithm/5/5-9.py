import sys

s1=sys.stdin.readline()
s2=sys.stdin.readline()
d1 = dict()
d2 = dict()

for x in s1:
    d1[x]=d1.get(x, 0)+1    # 처음 값 설정 없으면 0 반환
for x in s2:
    d2[x]=d2.get(x, 0)+1
for i in d1.keys():
    if i in d1.keys():      # key 값 있는지 확인ㄴ
        if d1[i]!=d2[i]:    # 개수 비교
            print("NO")
            break
    else:
        print("NO")
        break
else:
    print("YES")


# for x in s1:
#     if x in d:
#         d[x]+=1
#     else:
#         d[x]=0
# for x in s2:
#     if x in d:
#         if d[x]==0:
#             print("NO")
#             break
#         else:
#             d[x]-=1
#     else:
#         print("NO")
# else:
#     print("YES")

