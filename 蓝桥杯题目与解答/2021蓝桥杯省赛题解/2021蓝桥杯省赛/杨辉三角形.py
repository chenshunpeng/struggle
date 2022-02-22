def C(a, b):  # 计算组合值
    res = 1
    tmp = a
    for j in range(1, b + 1):
        res = res * tmp // j
        if res > n:
            return res
        tmp -= 1
    return res
def check(k):
    l, r = k * 2, n
    while l < r:
        mid = l + r >> 1
        if C(mid, k) >= n:
            r = mid
        else:
            l = mid + 1
    if C(r, k) != n:
        return False
    print(r * (r + 1) // 2 + k + 1)
    return True


n = int(input())
if n == 1:
    print(1)
else:
    k = 16
    while not check(k):
        k -= 1