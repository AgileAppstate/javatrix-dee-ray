#
# makefile
#

JUNIT_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT_RUNNER = org.junit.platform.console.ConsoleLauncher

default:
	"Options: compile, clean, test, check"

compile: Matrix.java MatrixTest.java Testtrix.java $(JUNIT_JAR)
	javac -cp .:$(JUNIT_JAR) MatrixTest.java
	javac Matrix.java
	javac Testtrix.java

clean:
	rm -f *~
	rm -f Testtrix.class
	rm -f Matrix*.class

test: $(JUNIT_JAR)
	java -cp .:$(JUNIT_JAR) $(JUNIT_RUNNER) --scan-class-path
