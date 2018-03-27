#Kevin Kheng 
#Paint Cost Calculator 
import math


'''
First I declared my variables.
Instead of dividing the surface area by 144, I converted my inches to feet first in order to make the program run better 
and also it makes more sense to me.
'''
height_inches = 0 
width_inches = 0 
length_inches = 0 

print("********************************************")
print("Welcome to my paint cost calculator program.")
print("********************************************")
height_inches = float(input("Enter the height of the room in inches: "))
width_inches = float(input( "Enter the width of the room in inches: "))
length_inches = float(input( "Enter the length of the room in inches:"))
'''
I convert the inches to feet by dividing the length , inches, and feet by 12.
I find the surface area of the 4 walls.
'''
height_feet = height_inches / 12 
width_feet = width_inches/ 12 
length_feet = length_inches/12
'''
I find the surface area first.
I use the if and else statement for the ceiling to see if they wanted to paint or not.
'''
total_surface_area = 2 * (height_feet * width_feet) + 2 *(height_feet * length_feet)
#print("total surface: " +str(total_surface_area))
ceiling_option = input("Do you want to paint the ceiling too? Type y for yes or n for no:")
if ceiling_option.lower().strip() == "y":
    ceiling = width_feet * length_feet
    total_surface_area = ceiling + total_surface_area
#    print("total surface area: " +str(total_surface_area))
else:
    total_surface_area = total_surface_area
#    print("total_surface_area"+str(total_surface_area))
'''
I declare my number of windows and doors.
I find the surface area of the window  and  door by multiplying its by its dimension.
I then take the total_surface_area subtract by the total surface area of window and door.

'''
number_of_doors = 0
number_of_doors = int(input("How many doors are there? "))
doors_total_surface_area = number_of_doors * 7 * 3 
#print("doors_total_surface_area: " + str(doors_total_surface_area))
number_of_windows = 0
number_of_windows = int(input("How many windows are there? "))
windows_total_surface_area = number_of_windows * 5 * 3
#print("windows_total_surface_area"+str(windows_total_surface_area))
total_surface_area = total_surface_area - windows_total_surface_area - doors_total_surface_area
#print("total surface: " +str(total_surface_area))
'''
In order for me to get my gallons of paint , I divide it by 350 so I know how much paint they need.I use the 
ceil function on this.I also did this for the primer,if they aske.
'''
gallons_of_paint = (total_surface_area/350)
gallons_of_paint = math.ceil(gallons_of_paint)
#print("gallons of paint " + str(gallons_of_paint) )
cost_of_paint = float(input("Enter the cost of paint: "))
cost_of_paint = gallons_of_paint * cost_of_paint
#print("The total cost of paint is:" +str(cost_of_paint))
primer_option = primer_option =  input("Is this the first time the room has been painted? Type y for yes or n for no: " )
primer = 0
total_cost = 0
gallons_of_primer = 0
if primer_option.lower().strip() == "y":
    cost_of_primer =float(input("Enter the cost of primer:"))
    gallons_of_primer = math.ceil(total_surface_area / 200)
#    print("total surface: " +str(total_surface_area))
#    print(gallons_of_primer)
    cost_of_primer = gallons_of_primer * cost_of_primer 
    total_cost = cost_of_paint + cost_of_primer 
else:
    gallons_of_primer = 0
    total_cost = cost_of_paint - 0
if primer_option.lower().strip() == "y":
   print("You need to buy %d gallons of paint and %d gallons of primer." %(gallons_of_paint, gallons_of_primer))
   print("Your total cost will be: $%.2f" %(total_cost))
   print("Thank you for using Kevin Kheng paint cost calculator.Good-bye.")
else:
    print("You need to buy %d2 gallons of paint."%(gallons_of_paint))
    print("Your total cost will be:$%.2f" %(total_cost))
    print("Thank you for using Kevin Kheng paint cost calculator.Good-bye.")
'''
I use the print statement earlier on to double check if my program of the math works.
I also commented it out
''' 







    
