import numpy as np

class Segmenter(object):
    '''
    A class for segmenting the data, e.g. given an array of elements, only certain number of random rows are kept
    '''
    
    nrItemsInSegment =1
    data = None

    def Segmenter(self):
        return self

    def setNrItemsInSegment(self, nrItemsInSegment):
        self.nrItemsInSegment = nrItemsInSegment
        return self
    
    def setData(self, data):
        self.data = data
        return self
    
    '''
    Generate a list with 2 elements in it:
    - the first element is a random segment of self.data
    - the second element is all the remaining data
    '''
    def generateSegment(self):
        print '\tGenerating segment ...'
        
        ret =[]

        shuffeledData = np.random.permutation(self.data)
        segment = shuffeledData[:self.nrItemsInSegment,0:]
        ret.append(segment)
        complementSegment =self.data[self.nrItemsInSegment:,0:] 
        ret.append(complementSegment)
            
        print '\tSegments generated!'
        return ret
    
    
