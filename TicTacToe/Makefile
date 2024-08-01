# Define the compiler and the flags
JAVAC = javac
JFLAGS = -d bin -sourcepath src

# Define the source and bin directories
SRC_DIR = src
BIN_DIR = bin

# List all the packages
PACKAGES = com/example \
           com/example/AbstractClass \
           com/example/ConcreteClass/board \
           com/example/ConcreteClass/game \
           com/example/ConcreteClass/Pieces \
           com/example/ConcreteClass/Players \
           com/example/enums

# Find all .java files in the source directory
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

# Convert .java filenames to .class filenames
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Default target
all: $(CLASSES)

# Compile .java files to .class files
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)
	$(JAVAC) $(JFLAGS) $<

# Clean up the bin directory
clean:
	rm -rf $(BIN_DIR)

# PHONY targets
.PHONY: all clean
