COMPILER = javac
FLAGS = -g

run: build
	java Simulation

build: Lane.class Light.class TrafficSystem.class Simulation.class Car.class


Car.class: Car.java
	$(COMPILER) $(FLAGS) Car.java

Simulation.class: Simulation.java
	$(COMPILER) $(FLAGS) Simulation.java

TrafficSystem.class: TrafficSystem.java
	$(COMPILER) $(FLAGS) TrafficSystem.java

Lane.class: Lane.java
	$(COMPILER) $(FLAGS) Lane.java

Light.class: Light.java
	$(COMPILER) $(FLAGS) Light.java

clean:
	$(RM) *.class

.PHONY: clean
