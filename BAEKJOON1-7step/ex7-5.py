import sys
str = sys.stdin.readline().strip().upper()
word = list(set(str))

cnt_list = []
for x in word :
    cnt = str.count(x)
    cnt_list.append(cnt)

if cnt_list.count(max(cnt_list)) > 1:
    print('?')
else:
    m_index = cnt_list.index(max(cnt_list))
    print(word[m_index])