import sys
board = [list(map(int, sys.stdin.readline().split())) for _ in range(7)]
cnt =0
for i in range(3):
    for j in range(7):  # 행 검사
        tmp=board[j][i:i+5]
        if tmp==tmp[::-1]:
            cnt+=1
        for k in range(2): # 5개 비교니까 2번만 회문 비교하면 됨
            if board[i+k][j]!=board[i+5-k-1][j]:
                break
        else:
            cnt+=1
print(cnt)