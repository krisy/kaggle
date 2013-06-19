def accuracy(data, tres):
    ''' 
     (list of pairs, float) ->  float  
       
     Computes percentage of correct predictions made by the model.  

     >>> data = [(2,1), (1,0), (3,1), (4,0), (1,0)]
     >>> tres = 2.3
     >>> efficiency = accuracy(data, tres)
     >>> efficiency
     0.59999999999999998
    '''
    num = correct = 0
    for row in data:
        num += 1
        if (row[0] >= tres and row[1] == 1  or row[0] < tres and row[1] == 0 ):
            correct += 1
    return float(correct) / num

if __name__ == '__main__':
    import doctest
    doctest.testmod()