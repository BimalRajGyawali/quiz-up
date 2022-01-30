CREATE TABLE question
(
    id             INTEGER NOT NULL,
    title          VARCHAR(255),
    option1        VARCHAR(255),
    option2        VARCHAR(255),
    option3        VARCHAR(255),
    option4        VARCHAR(255),
    correct_answer VARCHAR(255),
    weight         DOUBLE PRECISION,
    quiz_id        UUID,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE quiz
(
    id         UUID NOT NULL,
    title      VARCHAR(255),
    full_marks DOUBLE PRECISION,
    pass_marks DOUBLE PRECISION,
    CONSTRAINT pk_quiz PRIMARY KEY (id)
);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_QUIZ FOREIGN KEY (quiz_id) REFERENCES quiz (id);