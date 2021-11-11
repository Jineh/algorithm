import sys

sys.setrecursionlimit(10 ** 8)
n = int(sys.stdin.readline())

tree = [[] for _ in range(n + 1)]
parent = [0 for _ in range(n + 1)]  #루트 없이 하려고 +1

for _ in range(n - 1): #n-1줄
    a, b = map(int, sys.stdin.readline().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(tree, s, parent):

    #시작 노드부터 인접한 노드들 탐색
    for i in tree[s]:

        #만약 방문하지 않은 노드라면
        if parent[i] == 0:
            
            #부모노드로 저장
            parent[i] = s
            dfs(tree, i, parent)

dfs(tree, 1, parent)

for i in range(2, n + 1):
    print(parent[i])