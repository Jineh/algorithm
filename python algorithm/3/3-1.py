import sys

n=int(sys.stdin.readline())

for i in range(n):
    str=input()
    str = str.upper()
    size =len(str)

    for j in range(size//2):
        if str[j]!=str[-1-j]:
            print("#%d NO" %(i+1)) 
            break
    else:
        print("#%d YES" %(i+1))
    
    
    


# if str == str[::-1]:
#         print("#%d YES" %(i+1))
#     else:
#         print("#%d NO" %(i+1))

