import sys

N, M = map(int, sys.stdin.readline().split())
graph=[]
for i in range(N):
    graph.append(list(sys.stdin.readline()))

graph[0][0] = 1  # int 배열로 만들기 위해
dx = [-1,1,0,0]  
dy = [0,0,-1,1]  
queue = [(0,0)]  # 처음 좌표

while queue:
     x, y = queue.pop(0)
     print("\n")
     print(x,y)


     for i in range(4):  # 상하좌우 4번
         nx = x +dx[i]
         ny = y +dy[i]

         if nx>=0 and ny>=0 and nx<N and ny<M:
             if graph[nx][ny]=="1":
                 queue.append([nx,ny]) # 1인 값을 리스트에 추가
                 graph[nx][ny] = graph[x][y]+1  # 누적해서 값 저장
                 print(queue)
                 print(graph)
             


print(graph[N-1][M-1])

