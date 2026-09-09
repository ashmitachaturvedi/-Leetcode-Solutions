# 📝 Insertion in a Doubly Linked List (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Doubly Linked List

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given the  **head**  of a doubly-linked list, a position  **p,**  and an integer  **x.**  Insert a new node with value x at the position just after pth node (0-based indexing) in the doubly linked list and return the head of the modified list.

**Examples:**

```
Input: p = 2, x = 6

Output: 2 <-> 4 <-> 5 <-> 6
Explanation: Insert a node of value 6 after the 2nd node.

```

```
Input: p = 0, x = 44 

Output: 1 <-> 44 <-> 2 <-> 3 <-> 4
Explanation: Insert a node of value 44 after the 0th node.

```

**Constraints:** 
0 ≤ p < list size ≤ 104
0 ≤ x, node->data ≤ 104