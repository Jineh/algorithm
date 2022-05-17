def solution(s):
    answer = True
    pcnt=0
    ycnt=0
    for x in s:
        if x=='p' or x=='P':
            pcnt+=1
        elif x=='y' or x=='Y':
            ycnt+=1
    if pcnt == ycnt:
        return True
    else:
        return False

print(solution("Pyy"))