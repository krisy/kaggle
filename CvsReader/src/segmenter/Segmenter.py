import numpy as np

class Segmenter(object):
    '''
    A class for segmenting the data, e.g. given an array of elements, only certain number of random rows are kept
    '''
    
    nrItemsInSegment =1
    nrOfSegments =1
    data = None

    def Segmenter(self):
        return self

    def setNrItemsInSegment(self, nrItemsInSegment):
        self.nrItemsInSegment = nrItemsInSegment
        return self
    
    def setNrOfSegments(self, nrOfSegments):
        self.nrOfSegments = nrOfSegments
        return self
    
    def setData(self, data):
        self.data = data
        return self
    
    def generateSegment(self):
        print '\tGenerating segment ...'
        
        ret =[]

        for segmentNr in range(self.nrOfSegments):
            shuffeledData = np.random.permutation(self.data)
            segment = shuffeledData[:self.nrItemsInSegment,:]
            segmentData =  []
            segmentData.append(segment)
            segmentData.append(self.data)
            ret.append(segmentData)
        
        print '\tSegments generated!'
        return ret
    
    
