from numpy import sqrt, array, dot

class KNN:
    '''
    A class containing various knn implementations
    '''

    def KNN(self):
        return self

    '''
    Returns a list of list, with K element, such that:
    - the list contains K closest elements in ascending order
    - for every element the first is the id of the row, the second is the distance
    '''
    def weightedKNN(self, predictedVector, testDataIds, testData, K):

        differenceArray = (testData - predictedVector)**2
        result = []     
        
        for rowNumber in range(0,testData.shape[2]):
            row = differenceArray[0::,rowNumber]
            row = row[0,0::]
            distance = self.__weightFunction(row, row)
            result.append( [testDataIds[rowNumber], distance] )

        #clever array sorting seen here: 
        #http://stackoverflow.com/questions/5047407/python-numpy-array-sorting
        #FM - right?
        arrayToSort = array(result)
        sortedArray =arrayToSort[arrayToSort[:,1].argsort()] 
        return sortedArray[0:K,:]

    def __weightFunction(self, row1, row2):
        return sqrt(dot(row1, row2))
