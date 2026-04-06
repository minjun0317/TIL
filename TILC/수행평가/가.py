# 가. 1부터 n까지 소수의 개수
n = int(input())
count = 0

for i in range(2, n+1):
    prime = 1
    
    for j in range(2, i):
        if i % j == 0:
            prime = 0
    
    if prime == 1:
        count = count + 1

print(count)
