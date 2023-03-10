import sys

n = int(sys.stdin.readline())

newNum = n
cycle = 0

while True:
    #자리수 더하기
    if newNum < 10:
        sum = newNum + (newNum * 10) % 10
    else:
        sum = int(newNum / 10) + newNum % 10
  
    #오른쪽 수끼리 더하기
    if sum < 10:
        newNum = newNum % 10 * 10 + sum
    else:
        newNum = newNum % 10 * 10 + sum % 10
    
    cycle += 1

    if newNum == n:
        break

print(cycle)