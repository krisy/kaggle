import numpy as np

class Statistics(object):
    '''
    A class for generating simple statistics of the data
    '''

    def Statistics(self):
        return self
    
    def generateStatistics(self, data):
        print '\tGenerating statistics ...'

        print '\tType of imported data: ' + data.dtype.name # by default all data is string in csv
        print '\tShape(size and dimension) of imported data: ' + str(data.shape)

        statistics = []

        #for all columns display statistics
        for columnNumber in range(0,data.shape[1]):
            columnStatistics = []
            columnData = data[0::,columnNumber].astype(np.int32)
            orderedUniValues =np.unique(columnData)
            
            columnStatistics.append( orderedUniValues.size ) # distinct values
            columnStatistics.append( orderedUniValues[0] ) # min
            columnStatistics.append( orderedUniValues[orderedUniValues.size-1] ) #max
            columnStatistics.append( np.average(columnData) ) #average
            columnStatistics.append( np.std(columnData) ) # std dev
            
            statistics.append(columnStatistics)
            

        print '\t\tStatistics for the columns (distinct, min, max, avg, dev):'
        for stat in statistics:
            print '\t\t' +str( stat)
        
        print '\tStatistics finished!'
        
        
    def getHints(self, data):
        print '\tGenerating hints ...'
        
        print '\tHints finished!'