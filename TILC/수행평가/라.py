# 라. 타이머 종료 시간 계산
h, m = map(int, input().split())
t = int(input())

m = m + t

while m >= 60:
    m -= 60
    h += 1

while h >= 24:
    h -= 24

print(h, m)