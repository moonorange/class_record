import numpy as np


print("Hello World")

print(input("please enter number "))

print(2 ** 10)

print(np.sqrt(2) ** 2)

age = int(input("please enter your age: "))
print(2018 - age)

num = [1.5, 2.3, 1.8, 4.2, 3.2]

def average(num):
    return(sum(num)/len(num))

print(average(num))

def variance(num):
    ave = average(num)
    
    return (sum([(x-ave)**2 for x in num]) / len(num))

print(variance(num))