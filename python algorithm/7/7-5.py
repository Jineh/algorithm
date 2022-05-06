import sys

def DFS(L):
    global res
    if L==n:
        cha=max(money)-min(money)
        if cha<res:
            tmp=set()
            for x in money:
                tmp.add(x)
            if len(tmp)==3:
                res=cha
    else:
        for i in range(3):
            money[i]+=coin[L]
            DFS(L+1)
            money[i]-=coin[L]

if __name__=="__main__":
    n=int(input())
    coin=[]
    tmp=[]
    money=[0]*3
    res=2147000000
    for _ in range(n):
        coin.append(int(input()))
    DFS(0)
    print(res)



# def DFS(L, a, b, c):
#     global res
#     if L==n:
#         if a!=b and b!=c and a!=c:
#             val=[a, b, c]
#             val.sort()
#             myVal = val[2]-val[0]
#             if res> myVal:
#                 res=myVal
#         else:
#             return
#     else:
#         DFS(L+1, a+coin[L], b, c)
#         DFS(L+1, a, b+coin[L], c)
#         DFS(L+1, a, b, c+coin[L])



# if __name__=="__main__":
#     n=int(sys.stdin.readline())
#     coin=[]
#     for i in range(n):
#         coin.append(int(sys.stdin.readline()))
#     res=2000000
#     DFS(0, 0, 0, 0)
#     print(res)