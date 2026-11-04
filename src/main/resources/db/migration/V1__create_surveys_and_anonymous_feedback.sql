CREATE TABLE surveys (
 id UUID PRIMARY KEY,
 title VARCHAR(140) NOT NULL,
 course VARCHAR(140) NOT NULL,
 trainer VARCHAR(120) NOT NULL,
 opens_on DATE NOT NULL,
 closes_on DATE NOT NULL,
 status VARCHAR(16) NOT NULL DEFAULT 'OPEN',
 CONSTRAINT ck_survey_dates CHECK (closes_on >= opens_on)
);
CREATE TABLE feedback_responses (
 id UUID PRIMARY KEY,
 survey_id UUID NOT NULL REFERENCES surveys(id),
 content_score INTEGER NOT NULL CHECK (content_score BETWEEN 1 AND 5),
 trainer_score INTEGER NOT NULL CHECK (trainer_score BETWEEN 1 AND 5),
 materials_score INTEGER NOT NULL CHECK (materials_score BETWEEN 1 AND 5),
 would_recommend BOOLEAN NOT NULL,
 submitted_at TIMESTAMP WITH TIME ZONE NOT NULL
);
CREATE INDEX idx_feedback_survey ON feedback_responses(survey_id);
