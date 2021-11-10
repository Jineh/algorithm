import sys
n=sys.stdin.readline().split()
print((int(n[0])+int(n[1]))%int(n[2]))
print(((int(n[0])%int(n[2]))+(int(n[1])%int(n[2])))%int(n[2]))
print((int(n[0])*int(n[1]))%int(n[2]))
print(((int(n[0])%int(n[2]))*(int(n[1])%int(n[2])))%int(n[2]))