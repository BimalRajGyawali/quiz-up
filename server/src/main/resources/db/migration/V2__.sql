ALTER TABLE question
    ADD correct_option VARCHAR(255);

ALTER TABLE quiz
    ADD draft BOOLEAN;

ALTER TABLE quiz
    ADD duration_in_minute INTEGER;

ALTER TABLE quiz
    ADD max_attempt INTEGER;

ALTER TABLE quiz
    ADD name VARCHAR(255);

ALTER TABLE quiz
    ADD publish_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE quiz
    ADD total_questions INTEGER;

ALTER TABLE question
    DROP COLUMN correct_answer;

ALTER TABLE quiz
    DROP COLUMN full_marks;

ALTER TABLE quiz
    DROP COLUMN pass_marks;

ALTER TABLE quiz
    DROP COLUMN title;