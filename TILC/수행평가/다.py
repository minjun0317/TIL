# 다. 피라미드 출력
def ganadi_pyramid(n):
    for i in range(1, n+1):
        print(f'{" " * (n - i) + "*" * (2*i - 1)}')


n = int(input("n: "))
ganadi_pyramid(n)
