class Reader:
    '''
    A simple class for reading a csv file ...
    '''
    def Reader(self):
        return self

    def readCSV(self):
        print '\tRunning CSV import ...'
        
        import csv as csv
        import numpy as np
        
        csv_file_object = csv.reader(open('../csv/train.csv', 'rb')) #Load in the csv file
        header = csv_file_object.next() #Skip the fist line as it is a header
        data=[] #Create a variable called 'data'
        for row in csv_file_object: #Skip through each row in the csv file
            data.append(row) #adding each row to the data variable
        data = np.array(data) #Then convert from a list to an array

        print '\tHeader: ' + str(header)
        print '\tSample row: ' + str(data[0])
        
        print '\tCVS import finished!'
        
        return data