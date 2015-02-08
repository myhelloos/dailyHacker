n, m = map(int, raw_input().split())

theList = [long(raw_input()) for temp in range(n)]
coupleList = [i+j for i in theList for j in theList if i != j]
countZeroList = [str(theSum).count("0") for theSum in coupleList]
index = countZeroList.index(min(countZeroList))
print len(str(coupleList[index])) - min(countZeroList)
print countZeroList.count(min(countZeroList)) / 2
