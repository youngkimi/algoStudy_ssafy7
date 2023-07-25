from itertools import combinations

N,M = map(int,input().split())

ans=0
card = list(map(int,input().split()))

for i in combinations(card,3):
    if sum(i)>M:
        continue
    ans = max(ans,sum(i))

print(ans)

