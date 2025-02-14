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
(1, 'Contains Duplicate', 1),
(2, 'Valid Palindrome', 2),
(3, 'Best Time to Buy And Sell Stock', 3),
(4, 'Valid Parentheses', 4)
ON CONFLICT (problem_id) DO NOTHING; -- Prevents duplicate inserts