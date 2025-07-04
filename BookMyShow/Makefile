# Define the compiler and the flags
JAVAC = javac
JFLAGS = -d bin -sourcepath src

# Define the source and bin directories
SRC_DIR = src
BIN_DIR = bin



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

run:
	java -cp bin com.example.BookMyShow

# Clean up the bin directory
clean:
	rm -rf $(BIN_DIR)

# PHONY targets
.PHONY: all clean
