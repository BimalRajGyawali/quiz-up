ALTER TABLE quiz_distribution
    ALTER COLUMN attempt_no DROP NOT NULL;

ALTER TABLE quiz
    ALTER COLUMN draft DROP NOT NULL;

ALTER TABLE quiz
    ALTER COLUMN duration_in_minute DROP NOT NULL;

ALTER TABLE quiz_distribution
    ALTER COLUMN grade DROP NOT NULL;

ALTER TABLE quiz
    ALTER COLUMN max_attempt DROP NOT NULL;

ALTER TABLE quiz
    ALTER COLUMN total_questions DROP NOT NULL;

ALTER TABLE question
    ALTER COLUMN weight DROP NOT NULL;