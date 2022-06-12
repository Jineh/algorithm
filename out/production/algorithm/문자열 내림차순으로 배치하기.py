def solution(s):
    answer = ''
    num=[]
    for x in s:
        num.append(int(x+65))
    num.sort()
    for x in num:
        answer+=str(x)
    return answer

print(solution("Zbcdefg"))