# Thomas Mairella
# Rock Paper Scissors Game
# 3/8/26

# Import libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Read the CSV file into a DataFrame
df = pd.read_csv("Weather_App\\WeatherStationData.csv")

# Functions
def add_station():
    station = input("Enter the station name: ")
    location = input("Enter the location: ")
    date = input("Enter the date (YYYY-MM-DD): ")
    time_start = input("Enter the start time (HH:MM): ")
    time_end = input("Enter the end time (HH:MM): ")
    temp_highest = float(input("Enter the highest temperature: "))
    temp_lowest = float(input("Enter the lowest temperature: "))
    humidity = float(input("Enter the humidity (%): "))
    wind_mph = float(input("Enter the wind speed in mph: "))
    weather = input("Enter the weather description: ")

    new_station = {
        "Station": station,
        "Location": location,
        "Date": date,
        "Time Start": time_start,
        "Time End": time_end,
        "Temperature Highest": temp_highest,
        "Temperature Lowest": temp_lowest,
        "Humidity (%)": humidity,
        "Wind in mph": wind_mph,
        "Weather": weather
    }

    df.loc[len(df)] = new_station
    df.to_csv("Weather_App\\WeatherStationData.csv", index=False)
    print("New station added successfully!")

def edit_station():
    station_number = int(input("Enter the station number to edit (starting from 0): "))
    if station_number < 0 or station_number >= len(df):
        print("Invalid station number.")
        return 
    
    station = input("Enter the new station name: ")
    location = input("Enter the new location: ")
    date = input("Enter the new date (YYYY-MM-DD): ")
    time_start = input("Enter the new start time (HH:MM): ")
    time_end = input("Enter the new end time (HH:MM): ")
    temp_highest = float(input("Enter the new highest temperature: "))
    temp_lowest = float(input("Enter the new lowest temperature: "))
    humidity = float(input("Enter the new humidity (%): "))
    wind_mph = float(input("Enter the new wind speed in mph: "))
    weather = input("Enter the new weather description: ") 

    df.iloc[station_number] = [station, location, date, time_start, time_end, temp_highest, temp_lowest, humidity, wind_mph, weather]
    df.to_csv("Weather_App\\WeatherStationData.csv", index=False)
    print("Station edited successfully!")

def weather_analysis():
    average_temp = df[["Temperature Highest", "Temperature Lowest"]].mean().mean()
    min_temp = df[["Temperature Highest", "Temperature Lowest"]].min().min()
    max_temp = df[["Temperature Highest", "Temperature Lowest"]].max().max()

    average_humidity = df["Humidity (%)"].mean()
    min_humidity = df["Humidity (%)"].min()
    max_humidity = df["Humidity (%)"].max()
    
    average_wind = df["Wind in mph"].mean()
    min_wind = df["Wind in mph"].min()
    max_wind = df["Wind in mph"].max()

    print("Weather Analysis:")
    print(f"Average Temperature: {average_temp:.2f}")
    print(f"Minimum Temperature: {min_temp:.2f}")
    print(f"Maximum Temperature: {max_temp:.2f}")
    print(f"Average Humidity: {average_humidity:.2f}%")
    print(f"Minimum Humidity: {min_humidity:.2f}%")
    print(f"Maximum Humidity: {max_humidity:.2f}%")
    print(f"Average Wind Speed: {average_wind:.2f} mph")
    print(f"Minimum Wind Speed: {min_wind:.2f} mph")
    print(f"Maximum Wind Speed: {max_wind:.2f} mph")

def compare_stations():
    station1 = int(input("Enter the first station number to compare (starting from 0): "))
    station2 = int(input("Enter the second station number to compare (starting from 0): "))

    if station1 < 0 or station1 >= len(df) or station2 < 0 or station2 >= len(df):
        print("Invalid station numbers.")
        return 

    print(f"Comparing Station {station1} and Station {station2}:")
    print(df.iloc[station1])
    print(df.iloc[station2])

def graph_weather():
    type = input("What type of graph would you like to see? (Temperature, Humidity, Wind, etc.): ").lower()
    if type == "temperature":
        plt.plot(df["Date"], df["Temperature Highest"], label="Temperature Highest")
        plt.plot(df["Date"], df["Temperature Lowest"], label="Temperature Lowest")
        plt.xlabel("Date")
        plt.ylabel("Temperature")
        plt.title("Temperature Over Time")
        plt.legend()
        plt.show()
    elif type == "humidity":
        plt.bar(df["Date"], df["Humidity (%)"])
        plt.xlabel("Date")
        plt.ylabel("Humidity (%)")
        plt.title("Humidity Over Time")
        plt.show()
    elif type == "wind":
        plt.bar(df["Date"], df["Wind in mph"])
        plt.xlabel("Date")
        plt.ylabel("Wind Speed (mph)")
        plt.title("Wind Speed Over Time")
        plt.show()
    else:
        print("Invalid graph type.")

# Main Menu
print("Menu Choices:")
print("1. Add a new station")
print("2. Edit an existing station")
print("3. View all stations")
print("4. Weather Analysis")
print("5. Compare Stations")
print("6. Graph Weather Data")
print("7. Exit")

choice = input("\nEnter your choice: ")
match choice:
    case "1":
        add_station()
    case "2":
        print(df)
        edit_station()
    case "3":
        print(df)
    case "4":
        weather_analysis()
    case "5":
        print(df)
        compare_stations()
    case "6":
        print(df)
        graph_weather()
    case "7":
        print("Exiting the program.")