Building the program:
In order to build the program, the following files must exist in the directory:
Simulation.java, TrafficSystem.java, Light.java, Lane.java, Car.java, GetPropertyValues.java, config.properties, Makefile.
To build the program, simply type "make build" in the terminal. 

Run the program:
In order to run the program, type "make run" in the terminal. You don't have to build the program manually before running. 

There are three different options for running the Traffic Simulator:
1. Enter them yourself
2. Using the standard Values: 
Long lane = 20, left and straight lane = 5, the lights' period is 10, the straight light's green threshold = 3, the left light's green threshold = 5, the intensity = 2 and the left intensity = 3.  
3. Read them from a file (config.properties)

Mål redovisade med programmet:
N40
N41
I24
I25
D9
I22
K31
K32
S51
123
G16
H19
Q47

Eventuella utökningar:
* Support for busses that takes as much space as two cars.
* The possibility to switch between that intensity is precise and that intensity represents the likelihood of a car entering the system.   
