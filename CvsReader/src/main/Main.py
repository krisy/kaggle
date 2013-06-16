from reader import Reader
from statistics import Statistics
from segmenter import Segmenter

print 'Running Reader ...'
data = Reader.Reader().setLocation('../csv/train.csv').readCSV()


print 'Running Statistics ...'
stat = Statistics.Statistics().generateStatistics(data)


print 'Running Segmenter ...'
segment = Segmenter.Segmenter().setNrItemsInSegment(10).setNrOfSegments(3).setData(data).generateSegment()


print 'Main finished!'