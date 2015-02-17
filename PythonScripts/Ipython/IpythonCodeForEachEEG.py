reader=csv.reader(open("C:/Users/Raghavendra/Desktop/test1.csv","rb"),delimiter=',',quoting=csv.QUOTE_NONE)
fig, ax1 = plt.subplots(1, 1)
fig, ax2 = plt.subplots(1, 1)
fig, ax3 = plt.subplots(1, 1)
fig, ax4 = plt.subplots(1, 1)
fig, ax5 = plt.subplots(1, 1)
fig, ax6 = plt.subplots(1, 1)
fig, ax7 = plt.subplots(1, 1)
fig, ax8 = plt.subplots(1, 1)
fig, ax9 = plt.subplots(1, 1)
fig, ax10 = plt.subplots(1, 1)
fig, ax11 = plt.subplots(1, 1)
fig, ax12 = plt.subplots(1, 1)
fig, ax13 = plt.subplots(1, 1)
fig, ax14 = plt.subplots(1, 1)
fig, ax15 = plt.subplots(1, 1)
fig, ax16 = plt.subplots(1, 1)
ax1.set_title('Prediction Of seizures')
ax1.set_xlabel('Time')
ax1.set_ylabel('EEG recordings')
n=0
x=range(1000)
for row in reader:
    y=row[:1000]
    if n==0:
        ax1.plot(x,y)
    elif n==1:
        ax2.plot(x,y)
    elif n==2:
        ax3.plot(x,y)
    elif n==3:
        ax4.plot(x,y)
    elif n==4:
        ax5.plot(x,y)
    elif n==5:
        ax6.plot(x,y)
    elif n==6:
        ax7.plot(x,y)
    elif n==7:
        ax8.plot(x,y)
    elif n==8:
        ax9.plot(x,y)
    elif n==9:
        ax10.plot(x,y)
    elif n==10:
        ax11.plot(x,y)
    elif n==11:
        ax12.plot(x,y)
    elif n==12:
        ax13.plot(x,y)
    elif n==13:
        ax14.plot(x,y)
    elif n==14:
        ax15.plot(x,y)
    elif n==15:
        ax16.plot(x,y)
    n=n+1
