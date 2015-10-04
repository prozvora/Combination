# Combination
A program which computes all combinations of characters in a given string.

This program computes the combinations in two ways: recursively and iteratively.

## Usage

  **Input**
  ```
  java Combination ABCD i
  ```
  **Output**
  ```
  { {}, {D}, {C}, {D, C}, {B}, {D, B}, {C, B}, {D, C, B}, {A}, {D, A}, {C, A}, {D, C, A}, {B, A}, {D, B, A}, {C, B, A}, {D, C, B, A} }
  ```
  
  **Input**
  ```
  java Combination abcd r
  ```
  **Output**
  ```
  { {a, b, c, d}, {a, b, c}, {a, b, d}, {a, b}, {a, c, d}, {a, c}, {a, d}, {a}, {b, c, d}, {b, c}, {b, d}, {b}, {c, d}, {c}, {d}, {} }
  ```

## Notes
* Combination will handle repeated characters in a string and will not double print the same combination.
* Combination differentiates between upper case and lower case, so "A" and "a" are not equivalent.
* The order of combinations do not matter, so the program does not sort its output. The output is printed in the order it exists in the list.
