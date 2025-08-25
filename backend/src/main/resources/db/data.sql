INSERT INTO account_role (name)
VALUES ('ROLE_TEACHER'),('ROLE_STUDENT');

INSERT INTO answer_status (name)
VALUES ('NOT_VIEWED'), ('UPDATED'), ('ACCEPTED'), ('REJECTED');

-- Пароли идентичны именам: teacher -> teacher
INSERT INTO account (name, password_hash, account_role_id)
VALUES ('teacher', '$2a$10$GliCMk98aLreMnXx1h3Ow.g7Giwa97Ra0UiCTvMJ2UxJQXGNjnnpC', 1),
       ('student', '$2a$10$/YLZ1wKuM90BeWGS5uLs2uli6OUFON/WyEtLFnLAHb/6Bb8ksouPi', 2);