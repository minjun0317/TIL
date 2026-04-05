# 나. 반복 횟수
def ganadi(n):
    count = 0
    while n != 1:
        if n % 2 == 0:
            n = n // 2
        else:
            n = 3 * n + 1
        count += 1
    return count

n = int(input("n: "))
print(f"반복 횟수: {ganadi(n)}")