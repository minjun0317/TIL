# 가. 1부터 n까지 소수의 개수
n = int(input())
count = 0

for i in range(2, n+1):
    ganadi = True
    
    for j in range(2, i):
        if i % j == 0:
            ganadi = False
    
    if ganadi:
        count += 1

print(count)
