-- Create units table if it doesn't exist
CREATE TABLE IF NOT EXISTS units (
    unit_id INT PRIMARY KEY,
    unit_name VARCHAR(255) UNIQUE NOT NULL,
    last_revised DATE NULL
);

-- Create problems table if it doesn't exist
CREATE TABLE IF NOT EXISTS problems (
    problem_id INT PRIMARY KEY,
    problem_name VARCHAR(255) NOT NULL,
    completed BOOLEAN default false,
    unit_id INT NOT NULL,
    CONSTRAINT fk_problem_unit FOREIGN KEY (unit_id) REFERENCES units(unit_id) ON DELETE CASCADE
);

-- Create submissions table if it doesn't exist
CREATE TABLE IF NOT EXISTS submissions (
    submission_id SERIAL PRIMARY KEY,
    unit_id INT NOT NULL,
    time_taken BIGINT,
    date DATE,
    CONSTRAINT fk_submission_unit FOREIGN KEY (unit_id) REFERENCES units(unit_id) ON DELETE CASCADE
);
