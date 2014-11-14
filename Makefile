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

GetPropertyValues.class: GetPropertyValues.java
	$(COMPILER) $(FLAGS) GetPropertyValues.java



CarTest.class: CarTest.java
	$(COMPILER) $(FLAGS) CarTest.java

LightTest.class: LightTest.java
	$(COMPILER) $(FLAGS) LightTest.java

LaneTest.class: LaneTest.java
	$(COMPILER) $(FLAGS) LaneTest.java

TrafficSystemTest.class: TrafficSystemTest.java
	$(COMPILER) $(FLAGS) TrafficSystemTest.java

test: CarTest.class LightTest.class LaneTest.class TrafficSystemTest.class
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore CarTest
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore LightTest
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore LaneTest
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore TrafficSystemTest

clean:
	$(RM) *.class

.PHONY: clean
