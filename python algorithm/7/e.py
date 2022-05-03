# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    my=S.splitlines()
    splitString =[]
    tripCount={}
    trip=[]
    result=""

    for mys in my:
        splitString.append(list(mys.split(",")))
    for a in splitString:
        if a[1] not in tripCount:
            tripCount[a[1]]=1
        else:
            tripCount[a[1]]+=1 
    print(len(tripCount))
    g=[[0] for _ in range(len(tripCount))]
    print(g)

print(solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, p, 2013-09-05 14:07:13"))
