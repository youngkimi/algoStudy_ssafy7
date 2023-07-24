import math
s = input()
c=0
r=0 
ans=""

for i in range(math.ceil(len(s)**0.5),len(s)+1,1):
    if len(s)%i==0:
        c=i
        r=len(s)//c
        
        break

temp=[["" for _ in range(r)]for _ in range(c)]

for i in range(c):
    for j in range(r):
        temp[i][j]=s[i*r+j]
for i in range(r):
    for j in range(c):
        ans+=temp[j][i]

print(ans)
