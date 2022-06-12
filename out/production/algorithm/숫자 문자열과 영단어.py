def solution(s):
    answer = 0
    str=""
    num=["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    
    for x in s:
        if s.isdigit()==True:
            return int(s)
        if x.isdigit()==True:
            answer=answer*10 + int(x)
        else:
            str+=x
            if str in num:
                answer=(answer*10) + num.index(str)
                str="" 
    return answer

print(solution("2three45sixseven"))