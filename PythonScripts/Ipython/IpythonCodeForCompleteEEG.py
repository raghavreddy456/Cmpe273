reader=csv.reader(open("C:/Users/Raghavendra/Desktop/test1.csv","rb"),delimiter=',',quoting=csv.QUOTE_NONE)
fig1=plt.figure()
ax1=fig1.add_subplot(16,1,1)
ax2=fig1.add_subplot(16, 1,2)
ax3=fig1.add_subplot(16, 1,3)
ax4=fig1.add_subplot(16, 1,4)
ax5=fig1.add_subplot(16, 1,5)
ax6=fig1.add_subplot(16, 1,6)
ax7=fig1.add_subplot(16, 1,7)
ax8=fig1.add_subplot(16, 1,8)
ax9=fig1.add_subplot(16, 1,9)
ax10=fig1.add_subplot(16, 1,10)
ax11=fig1.add_subplot(16, 1,11)
ax12=fig1.add_subplot(16, 1,12)
ax13=fig1.add_subplot(16, 1,13)
ax14=fig1.add_subplot(16, 1,14)
ax15=fig1.add_subplot(16, 1,15)
ax16=fig1.add_subplot(16, 1,16)
ax1.set_title('Prediction Of seizures')
ax1.set_xlabel('Time In Seconds')
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
fig1.savefig('C:/Users/Raghavendra/Google Drive/temp.png')
