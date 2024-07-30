# ParkingLotDesign Project

## Introduction

The ParkingLot project is a simulation of a parking management system. It provides features to manage different types of vehicles, allocate parking spots based on various strategies, and compute parking costs using different pricing strategies. The design and implementation follows the SOLID principal of LLD

## Features

- Manage multiple types of vehicles (Two-Wheeler, Four-Wheeler)
- Allocate parking spots using strategies (Near Entrance, Near Exit)
- Compute parking costs based on hourly or minute-based strategies
- Handle parking ticket generation, entry, and exit gates

## Cloning the Repository


ParkingLotDesign is under LowLevelSystemDesign repository. You need to clone the LowLevelSystemDesign repository. You can clone this repository using either SSH or HTTPS.

### SSH
git@github.com:Sudipta-Sen/LowLevelSystemDesign.git

### HTTPS
https://github.com/Sudipta-Sen/LowLevelSystemDesign.git

## Compile the code

### Navigate to the ParkingLotDesign folder

cd low-level-system-design/ParkingLotDesign

### Run make to compile the codebase:

make

### Run the main class:

java -cp bin com.example.main

### Clean up the bin directory

make clean
