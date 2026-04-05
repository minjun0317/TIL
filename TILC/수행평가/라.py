# 라. 타이머 종료 시간 계산
def ganadi(h,m, addm):
    totalm = h * 60 + m + addm
    h1 = (totalm // 60) % 24
    m1 = totalm % 60
    return h1,m1


h = int(input("현재 시: "))
m = int(input("현재 분: "))
addm = int(input("추가 분: "))
h1,m1 = ganadi(h, m, addm)
print(f"종료 시간: {h1} {m1}")