# Compiler and flags
JAVAC = javac
JFLAGS = -d bin -sourcepath src

# Directories
SRC_DIR = src
BIN_DIR = bin

# Find all .java files in src/
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

# Default target: compile all sources at once
all:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) $(JFLAGS) $(SOURCES)

# Run main class (must match fully qualified name)
run:
	java -cp bin com.example.main

# Clean up compiled class files
clean:
	rm -rf $(BIN_DIR)

.PHONY: all run clean
