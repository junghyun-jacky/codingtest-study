def is_prime_number(x):
    if x == 1:
      return False
    for i in range(2, x):
        if x % i == 0:
            return False
    return True 

case = int(input())
numbers = map(int, input().split())

count = 0
for i in numbers:
  if(is_prime_number(i)):
    count += 1

print(count)
