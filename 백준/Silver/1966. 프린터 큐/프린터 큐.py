import sys

t = int(sys.stdin.readline())

for i in range(t):
    n, m = map(int, sys.stdin.readline().rstrip().split())
    rank = list(map(int, sys.stdin.readline().rstrip().split()))
    index = list(range(n))

    point = index[m]
    count = 0

    while True:
        if rank[0] < max(rank):
            rank.append(rank.pop(0))
            index.append(index.pop(0))
        else:
            count += 1

            if index[0] == point:
                break

            rank.pop(0)
            index.pop(0)
  
    print(count)