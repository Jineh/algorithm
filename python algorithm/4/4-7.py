import sys

l = int(sys.stdin.readline())
box = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
box.sort()      # 최소, 최대 값 찾을 필요 없이 처음부터 정렬
for _ in range(m):
    box[0]+=1
    box[l-1]-=1
    box.sort()
print(box[l-1]-box[0])


# l = int(sys.stdin.readline())
# box = list(map(int, sys.stdin.readline().split()))
# m = int(sys.stdin.readline())

# for _ in range(m):
#     maxx = box.index(max(box))
#     minn = box.index(min(box))
#     box[maxx]-=1
#     box[minn]+=1
# print(max(box)-min(box))


    
