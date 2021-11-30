natural = set(range(1,10001))
generated = set()

for i in range(1,10001):
    for j in str(i):
        i += int(j)
    generated.add(i)

self_num = sorted(natural-generated)
for i in self_num:
    print(i)