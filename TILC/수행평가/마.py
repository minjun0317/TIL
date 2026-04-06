# 마. 세 수 중 최대, 모두 같음
a, b, c = map(int, input().split())

if a == b and b == c:
    print("모두 같음")

if a >= b and a >= c and not (a == b and b == c):
    print(a)

if b >= a and b >= c and not (a == b and b == c):
    print(b)

if c >= a and c >= b and not (a == b and b == c):
    print(c)