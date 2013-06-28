from numpy import sqrt, array, dot, int32

class KNN:
    '''
    A class containing various knn implementations
    '''

    def KNN(self):
        return self

    
    def computeKNN(self, elementsToPredict, elementsToPredictFrom):
        ''' For all rows in segmentToRain'''
        finalPrediction = []
        for anElementToPredict in elementsToPredict:
            K = 3
        
            print '\tFinding closest elements to vector (first fields are ignored): \n\t\t\t\t\t\t\t\t\t\t' + str(anElementToPredict)
        
            res = self._computeClosestK(anElementToPredict, elementsToPredictFrom, K)

            predictSum =0
            for closestVectorIndex in res:
                print '\t\tClosest vector(distance: '+str(closestVectorIndex[1])+'):    ' + str(elementsToPredictFrom[closestVectorIndex[0]] )
                predictSum = predictSum + array(elementsToPredictFrom[closestVectorIndex[0]][0], float)
            predict = float(predictSum)/float(K)
            print '\tFinal predict value: ' + str(predict)
            anElementToPredict[0] = predict
            finalPrediction.append( anElementToPredict )

        return finalPrediction

    '''
    Returns a list of lists, with K element, such that:
    - the list contains K closest elements in ascending order
    - for every element the first is the id of the row, the second is the distance
    That is:
    first list element row_id1, distance1
    second element row_id2, distance{K}
    ...
    K th element row_id{K}, distance{K}
    '''
    def _computeClosestK(self, predictedVector, testData, K):

        differenceArray = (testData.astype(int32) - predictedVector.astype(int32))**2
        result = []     

        for rowNumber in range(0,testData.shape[0]):
            diffRow = differenceArray[rowNumber,0::]
            distance = self._nrOfZeroColumns(diffRow)
            result.append( [rowNumber, distance] )

        #clever array sorting seen here: 
        #http://stackoverflow.com/questions/5047407/python-numpy-array-sorting
        #FM - right?
        arrayToSort = array(result)
        sortedArray =arrayToSort[arrayToSort[:,1].argsort()] 
        return sortedArray[0:K,:]

    def __eucledianWeightFunction(self, row1, row2):
        return sqrt(dot(row1, row2))

    def _nrOfZeroColumns(self, row1):
        distance = row1.shape[0]
        ''' the first field is the predict value - don't count it!'''
        for i in row1[1:]:
            if i ==0:
                distance = distance -1
        ''' the first field is the predict value - don't count it!'''
        distance = distance -1
        return distance

    