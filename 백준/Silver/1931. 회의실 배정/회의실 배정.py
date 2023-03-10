import sys

n = int(sys.stdin.readline())

time = []
for i in range(n):
    time.append(list(map(int, sys.stdin.readline().rstrip().split())))

time.sort(key=lambda x: (x[1], x[0]))

count = 1
end = time[0][1]
for i in range(1, n):
    if time[i][0] >= end:
        count += 1
        end = time[i][1]

print(count)