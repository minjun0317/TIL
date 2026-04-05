# 마. 세 수 중 최대, 모두 같음
def ganadi(a, b, c):
    if a == b == c:
        return "모두 같음"
    else:
        return max(a, b, c)


a = int(input("a: "))
b = int(input("b: "))
c = int(input("c: "))
print(ganadi(a, b, c))