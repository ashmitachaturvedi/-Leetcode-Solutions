# 📝 1008. Binary Tree Cameras (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/binary-tree-cameras/)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Tree, Depth-First Search, Binary Tree, DP on Trees

### 🚀 Performance
- **Runtime:** 0 ms
- **Memory:** 44.8 MB

---

### 📜 Problem Description

You are given the  `root`  of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return  *the minimum number of cameras needed to monitor all nodes of the tree* .

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2018/12/29/bst_cameras_01.png) 

```
Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

```

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2018/12/29/bst_cameras_02.png) 

```
Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

```

**Constraints:**

	
- The number of nodes in the tree is in the range  `[1, 1000]` .
	
- `Node.val == 0`