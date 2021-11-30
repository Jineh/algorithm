import sys
str=sys.stdin.readline().strip()

alphabet = list(range(97,123))  # 아스키코드 숫자 범위

for x in alphabet :
    print(str.find(chr(x))) 


