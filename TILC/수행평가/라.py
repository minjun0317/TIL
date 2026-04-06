# 라. 타이머 종료 시간 계산
h = int(input())
m = int(input())
t = int(input())

m = m + t

while m >= 60:
    m = m - 60
    h = h + 1

while h >= 24:
    h = h - 24

# 두 자리 형식 맞추기
if h < 10:
    print("0", end="")
print(h, end=":")

if m < 10:
    print("0", end="")
print(m)