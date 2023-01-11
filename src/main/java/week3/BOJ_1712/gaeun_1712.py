a, b, c = map(int, input().split())

if b >= c:
    print(-1)
else:
    num = a / (c - b)
    num = num + 1
    
    print(int(num))
