def solution(s):
    answer = 0
    ch=0
    if s.isdigit():
        answer = int(s)
    else:
        for x in s:
            if x=='-':
                ch= -1
            elif x=='+':
                ch= 1
            else:
                answer= answer*10 + int(x)
        answer=answer*ch
    return answer

print(solution("1234"))