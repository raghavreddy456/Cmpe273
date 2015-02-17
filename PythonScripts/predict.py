import csv
import array
import sys
import json


#from pprint import pprint 
csv.field_size_limit(sys.maxsize)
#data = array.array('i')

#count consecutive slopes
def readCSVSlope(patientID):
    n = 0
    peakslope = 0
    #with open('../source/' + filename + '.csv', 'rb') as csvfile:
    with open('/var/www/html/SeizurePredictor/' + patientID + '/input/' + patientID + '.csv', 'rb' ) as csvfile:
        reader = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in reader:

            n = n +1 
            i = 0
            slope = 0
            maxslope = 0
            minslope = 0
            
            #row = map (float, row)
            
            #calculate slope
            while i < len(row)-1:
                #print len(row)
                                    
                lastslope = slope   
                row[i]= int(row[i])
                row[i+1]= int(row[i+1])
                
                slope = row[i+1]-row[i]                
                #slope = 0
                
                if lastslope >= 0:
                    if slope >= 0:
                        slope = slope + lastslope
                else:
                    if slope < 0:
                        slope = slope - lastslope
                
                
                '''
                if slope > 0:
                    if lastslope > 0:
                        slope = slope + lastslope    
                
                if slope < 0:
                    if lastslope < 0:
                        slope = slope - lastslope                
                '''                    
                if maxslope < slope:
                    maxslope = slope
                    
                if minslope > slope:
                    minslope = slope
                i = i+ 1
            #print (maxslope, n , filename)
            #print (minslope, n , filename)
                
            if peakslope < maxslope:
                peakslope = maxslope    
            if abs(peakslope) < abs(minslope):
                peakslope = abs(minslope)    
            
        #print (peakslope, patientID)
        if peakslope > 660:
            return ("Seizure!")
        elif peakslope >620:
            return ("Warning")
        else: 
            return ("Ok")

def writeJson(patientID, status):

    #f = open('../source/' + filename + '.csv', 'rb')
    #with open('../source/' + output + '.json', 'w+') as data:
    with open('/var/www/html/SeizurePredictor/' + patientID + '/result/result.json', 'w+') as data:
        data.write('{"patients": [ { "patient": "' + patient + '", "result": "' + status +'" } ] }' )
    data.close()
        

try: 
    patient = sys.argv[1]
except:
    print 'need patient ID argument'
#output = "test2"

try:               
    status = readCSVSlope(patient)
except:
    print 'file ' + sys.argv[1] +'.csv not found'


try:
    writeJson(patient,status)
except: 
    print 'unable to write'
print ("done")

