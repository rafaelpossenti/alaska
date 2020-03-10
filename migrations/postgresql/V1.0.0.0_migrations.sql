CREATE TABLE goal
  (
     id                              int,
     created_at                      date,
     updated_at                      date,
     name                            VARCHAR(80),
     description                     VARCHAR(255),
     frequency                       VARCHAR(255) CHECK (frequency IN ('DAILY', 'WEEKLY', 'MONTHLY', 'ANNUALLY')),
     difficulty                      VARCHAR(255) CHECK (difficulty IN ('TRAINING', 'EASY', 'MODERATE', 'HARD', 'INSANE')),
     status                          VARCHAR(255) CHECK (status IN ('PROGRESS', 'CLOSED', 'CANCELED')),
     type_id                         int,
     PRIMARY KEY (id)
  );

CREATE TABLE goal_type
  (
     id                              int,
     created_at                      date,
     updated_at                      date,
     type                            VARCHAR(80),
     description                     VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE "user"
  (
     id                              int,
     created_at                      date,
     updated_at                      date,
     name                            VARCHAR(255),
     image                           VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE goal_user
 (
     goal_id                              int,
     user_id                              int
 );

ALTER TABLE goal_user ADD CONSTRAINT fk_goal_user_goal_id FOREIGN KEY (goal_id) REFERENCES goal (id);
ALTER TABLE goal_user ADD CONSTRAINT fk_goal_user_user_id FOREIGN KEY (user_id) REFERENCES "user" (id);

--TODO
--Util SQLs above
SELECT g.name, g.difficulty, u.name
FROM goal g
JOIN goal_user gu ON g.id = gu.goal_id
JOIN "user" u ON gu.user_id = u.id
WHERE u.id = 1;