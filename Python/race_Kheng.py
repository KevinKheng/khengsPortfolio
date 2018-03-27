#Kevin Kheng
# Race Day
import random
import turtle
#intialize the coordinates of the red and green turtles
rx = -400
ry = 200
gx = -400 
gy = -200
red_turtle =turtle.Turtle()
green_turtle = turtle.Turtle()
red_turtle.shape("turtle")
green_turtle.shape("turtle")
red_turtle.color("red")
green_turtle.color("green")
#boundary function
def boundary():
    boundary = turtle.Turtle()
    boundary.ht()
    boundary.pensize(5)
    boundary.color("black")
    boundary.penup()
    boundary.goto(-400,400)
    boundary.pendown()
    for i in range(4):
        boundary.forward(800)
        boundary.right(90)
    
boundary()    
red_name  = input("Enter the name of the red turtle : ")
green_name = input("Enter the name of the green turte : ")
fname = input("Enter the name of the file for the red turtle's path : ")

red_turtle.penup()
green_turtle.penup()
red_turtle.goto(rx,ry)
green_turtle.goto(gx,gy)

#File reading
fin = open(fname,"r")
xs =[]
ys =[]

#Reading values from file and adding it to a list
for line in fin:
    line = line.strip()
    parts = line.split(" ")
    xval = int(parts[0])
    yval = int(parts[1])
    xs.append(xval)
    ys.append(yval)

count = 0
red_turtle.pendown()
green_turtle.pendown()

totalg = 0
totalr = 0
previous = rx

#Race logic
while totalr != 815 and gx < 400:
    
    #Green turtle logic
    gstep = random.randint(2,20) 
    gx = gx + gstep
    totalg = totalg + gstep   
    gy = gy + random.randint(-10,10)
    green_turtle.goto(gx,gy)
    
    #Red turtle racing
    red_turtle.goto(xs[count],ys[count])
    difference = abs(previous - xs[count])
    totalr += difference
    
    previous = xs[count]
    count = count + 1


#close file
fin.close()
if totalr > totalg :
    print("%s have went a distance of %d ,while %s went a distance of %d.%s is the winner."%(red_name,totalr,green_name,totalg,red_name))
else:
    print("%s have went a distance of %d ,while %s went a distance of %d.%s is the winner."%(green_name,totalg,red_name,totalr,green_name))
    
