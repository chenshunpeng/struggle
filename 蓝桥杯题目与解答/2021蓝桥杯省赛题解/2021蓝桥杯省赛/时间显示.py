n = int(input())
n = n // 1000
n = n % 86400
h = n // 3600
n = n % 3600
m = n // 60
s = n % 60
print("{:0>2}:{:0>2}:{:0>2}".format(str(h),str(m),str(s)))
