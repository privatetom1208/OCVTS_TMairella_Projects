# import math

print("Temperature Converter")
print("Units: C = Celsius, F = Fahrenheit, K = Kelvin")

running = True
while running:
    try:
        temp = float(input("Enter the temperature: "))
    except ValueError:
        print("Invalid number. Please enter a numeric value.")

    from_unit = input("Enter input unit (C, F, K): ").upper()
    to_unit = input("Enter output unit (C, F, K): ").upper()

    # Validate Units
    if from_unit not in ["C", "F", "K"] or to_unit not in ["C", "F", "K"]:
        print("Invalid unit. Please enter C, F, or K.")
        continue

    # Kelvin cannot be negative
    if from_unit == "K" and temp < 0:
        print("Invalid: Kelvin cannot be negative.")
        continue

    # Convert input to Celsius first
    if from_unit == "C":
        celsius = temp
    elif from_unit == "F":
        celsius = (temp - 32) * 5/9 # Fahrenheit to Celsius conversion
    elif from_unit == "K":
        celsius = temp - 273.15 # Celsius to Kelvin conversion

    # convert Celsius to target unit
    if to_unit == "C":
        converted_temp = celsius
    elif to_unit == "F":
        converted_temp = (celsius * 9/5) + 32 # Celsius to Fahrenheit conversion
    elif to_unit == "K":
        converted_temp = celsius + 273.15 # Celsius to Kelvin conversion

    print(f"Result: {converted_temp:.2f}{to_unit}")

    choice = input("Convert Again? (yes/no): ").lower()
    if choice == "no":
        running = False