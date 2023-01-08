t = int(input())

for i in range(t):
    word = ""
    r,s = input().split()
    
    for s2 in list(s):
        word += s2 * int(r) 
    
    print(word)
