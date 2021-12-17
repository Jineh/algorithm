import sys
str = sys.stdin.readline().strip()

croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in croatia:
    str = str.replace(i,'*')
print(len(str))