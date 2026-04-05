# 가. 1부터 n까지 소수의 개수
def ganadi(n):
    count = 0
    for i in range(2, n + 1):
        for j in range(2, int(i**0.5) + 1):
            if i % j == 0:
                break
            else:
                count += 1
    return count

n = int(input("n: "))
print(f"소수의 개수: {ganadi(n)}")