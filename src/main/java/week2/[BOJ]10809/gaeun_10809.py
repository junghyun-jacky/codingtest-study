word = input()
list = [-1 for i in range(26)]

for s in word:
    list[ord(s) - 97] = word.index(s)
    
for i in list:
    print(i)

print(*word)
