from numpy import array
from models import knn

predictedVector = array([1,2,3])
K = 2
testData = array( [( [1,3,4], [1,2,100], [1,2,5] ) ])
testDataIds = array([1,2,3])
print knn.KNN().weightedKNN(predictedVector, testDataIds, testData, K)