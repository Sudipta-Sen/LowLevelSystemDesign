# HashMap Internals
When we define a HashMap as:
```java
Map<Integer, String> map = new HashMap<>();
```

a new HashMap object is created with internal data structures to store key-value pairs. To use it, we typically call:
```java
map.put(1, "value");  
map.get(1);
```

But under the hood, several important mechanisms are at work.

## Key Concepts

1. Initial Capacity
    - If no initial size is provided, the default capacity is 16 (i.e., 2<sup>4</sup> ).
    - HashMap size is always in 2<sup>n</sup> format. If an initial size is provided, it is rounded up to the next power of 2 greater than or equal to the given value.

2. Load Factor
    - Default is 0.75, meaning resizing occurs when the map is 75% full.
    - Example: If current capacity is 128, resizing happens after ~96 entries.

3. Hash Function and Index Calculation
    - For `put(key, value)`, Java calculates the **hash code** of the key and applies modulo (internally optimized using bitwise operations) with current capacity to find the index in the internal array.
    - Each index in the array refers to either:
        - `null`
        - A **LinkedList** of entries (bucket)
        - A **TreeNode** (converted from list if needed)

4. Collision Handling
    - If two keys map to the same index (i.e., hash collision), entries are stored in a linked list at that index.
    - If a key already exists, its value is **updated** or create a new entry in linked list.
    - If not, a new node is **inserted**.

5. Treeification
    - If the number of entries in a bucket(linked list) exceeds **TREEIFY_THRESHOLD = 8**, and the map's capacity is at least 64, the bucket is converted into a **balanced binary tree** (Red-Black Tree) to improve lookup efficiency.

6. Maximum Capacity
    - The capacity is always a power of 2 and can go up to (2<sup>30</sup>)
        - This is because the backing array size must be representable within a 32-bit signed `int`, where max value is 2<sup>31</sup>-1 and largest integer possible with 2<sup>n</sup> format is 2<sup>30</sup>

## Resizing Mechanism

- When the number of entries exceeds `capacity * loadFactor`, the HashMap doubles its capacity.
- A new internal array is created, and all existing entries are **rehashed** and redistributed.
- **Important Note:** Rehashing can cause **entries to change their positions**, even if their hashcode remains the same. This is because the new index depends on the new array size (which affects the modulo operation).

## HashCode Rules
1. **Same object/value** → always gives the same hash code.
2. **Different objects/values** → may still produce the same hash code (leading to collisions).