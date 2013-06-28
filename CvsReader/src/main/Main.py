from reader import Reader
from statistics import Statistics
from segmenter import Segmenter
from models import knn
import numpy 

numpy.set_printoptions(linewidth=1000)

print 'Running Reader ...'
data = Reader.Reader().setLocation('../csv/train.csv').readCSV()


print 'Running Statistics ...'
stat = Statistics.Statistics().generateStatistics(data)


print 'Running Segmenter ...'
segment = Segmenter.Segmenter().setNrItemsInSegment(2).setData(data).generateSegment()

print 'Run knn on segments ...';
finalPrediction = knn.KNN().computeKNN(segment[0], segment[1])

print '\n\n----------------------------------------Final predictions are:----------------------------------------\n'
print str(finalPrediction)

print 'Main finished!'