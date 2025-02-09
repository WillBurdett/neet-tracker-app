-- Drop tables if they already exist to avoid conflicts
DROP TABLE IF EXISTS submissions;
DROP TABLE IF EXISTS problems;
DROP TABLE IF EXISTS units;

-- Create units table
CREATE TABLE units (
    unit_id INT PRIMARY KEY,
    unit_name VARCHAR(255) UNIQUE NOT NULL,
    last_revised DATE NULL
);

-- Create problems table
CREATE TABLE problems (
    problem_id INT PRIMARY KEY,
    problem_name VARCHAR(255) NOT NULL,
    unit_id INT NOT NULL,
    CONSTRAINT fk_problem_unit FOREIGN KEY (unit_id) REFERENCES units(unit_id) ON DELETE CASCADE
);

-- Create submissions table
CREATE TABLE submissions (
    submission_id SERIAL PRIMARY KEY,
    unit_id INT NOT NULL,
    time_taken BIGINT,
    date DATE,
    CONSTRAINT fk_submission_unit FOREIGN KEY (unit_id) REFERENCES units(unit_id) ON DELETE CASCADE
);