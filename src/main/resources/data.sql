-- Insert into units if they do not already exist
INSERT INTO units (unit_id, unit_name, last_revised) VALUES
(1, 'Arrays & Hashing', NULL),
(2, 'Two Pointers', NULL),
(3, 'Sliding Window', NULL),
(4, 'Stack', NULL),
(5, 'Binary Search', NULL),
(6, 'Linked List', NULL),
(7, 'Trees', NULL),
(8, 'Heap / Priority Queue', NULL),
(9, 'Backtracking', NULL),
(10, 'Tries', NULL),
(11, 'Graphs', NULL),
(12, 'Advanced Graphs', NULL),
(13, '1-D Dynamic Programming', NULL),
(14, '2-D Dynamic Programming', NULL),
(15, 'Greedy', NULL),
(16, 'Intervals', NULL),
(17, 'Math & Geometry', NULL),
(18, 'Bit Manipulation', NULL)
ON CONFLICT (unit_id) DO NOTHING; -- Prevents duplicate inserts

-- Insert into problems if they do not already exist
INSERT INTO problems (problem_id, problem_name, unit_id) VALUES
-- ARRAYS AND HASHING
(1, 'Contains Duplicate', 1),
(2, 'Valid Anagram', 1),
(3, 'Two Sum', 1),
(4, 'Group Anagrams', 1),
(5, 'Top K Frequent Elements', 1),
(6, 'Encode and Decode Strings', 1),
(7, 'Product of Array Except Self', 1),
(8, 'Valid Sudoku', 1),
(9, 'Longest Consecutive Sequence', 1),

-- TWO POINTERS
(10, 'Valid Palindrome', 2),
(11, 'Two Sum II Input Array Is Sorted', 2),
(12, '3Sum', 2),
(13, 'Container With Most Water', 2),
(14, 'Trapping Rain Water', 2),

-- SLIDING WINDOW
(15, 'Best Time to Buy And Sell Stock', 3),
(16, 'Longest Substring Without Repeating Characters', 3),
(17, 'Longest Repeating Character Replacement', 3),
(18, 'Permutation In String', 3),
(19, 'Minimum Window Substring', 3),
(20, 'Sliding Window Maximum', 3)
ON CONFLICT (problem_id) DO NOTHING; -- Prevents duplicate inserts