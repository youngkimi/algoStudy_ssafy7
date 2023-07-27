for tc in range(1,11): 
    n=int(input())
    matrix=[]
    ans=0
    for i in range(100): 
        matrix.append(list(map(str,input().split())))

    for i in range(100):
        temp=" "
        for j in range(100):
            if(matrix[j][i]=='0'):
                continue
            if(temp[-1]==matrix[j][i]):
                continue
            temp+=matrix[j][i]
        ans+=temp.count("12")
    print("#{} {}".format(tc,ans))


