import sys
n=int(sys.stdin.readline())

group = 0
for _ in range(n):
    str = sys.stdin.readline().strip()
    error =0
    for j in range(len(str)-1):
        if str[j] != str[j+1]:
            new_word = str[j+1:]
            if new_word.count(str[j])>0:
                error +=1
    if error == 0:
        group += 1
print(group)