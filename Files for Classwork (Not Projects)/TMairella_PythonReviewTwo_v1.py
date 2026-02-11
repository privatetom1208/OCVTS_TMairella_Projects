#Practice Activity 1

name = input("Enter name: ")
age = int(input("Enter age: "))
print(f"Hello {name}, you are {age} years old.")

#Practice Activity 2
if age >= 18:
    print("You are an adult.")
else:    print("You are a minor.")

#Practice Activity 3
menuoption = int(input("Enter menu option (1, 2, or 3): "))

match menuoption:
    case 1:
        print("You selected option 1.")
    case 2:
        print("You selected option 2.")
    case 3:
        print("You selected option 3.")
    case _:
        print("Invalid menu option.")
