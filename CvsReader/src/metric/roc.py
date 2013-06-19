from operator import itemgetter

def auc(data):
    ''' 
     list of pairs ->  float  
       
     Computes area under ROC curve. The first element of each pair in data is
     a real number computed by the model. The second element is 0 or 1
     according to the pair is associated to a negative or postitive test case, 
     respectively. If there are no negatives or positives then AUC = 0 or 1 
     by definition. 

     >>> data = [(2,1), (1,0), (3,1), (4,0), (1,0)]
     >>> efficiency = auc(data)
     >>> efficiency
     0.66666666666666663
    '''
    
    sorted_data = sorted(data, key=itemgetter(0), reverse=True)
    positives = negatives = height = total = 0
    
    for row in sorted_data:
        if(row[1] == 1):
            positives += 1 
            height += 1
        else:
            negatives += 1
            total += height
            
    if(negatives == 0):
        return 1
    elif(positives == 0):
        return 0
    else:
        return float(total)/(positives * negatives)
    
if __name__ == '__main__':
    import doctest
    doctest.testmod()