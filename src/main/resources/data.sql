INSERT INTO students (student_name , email , phone_number) VALUES
                                                       ('John','john@gmail.com','098123456'),
                                                       ('Johndy','johndy@gmail.com','098543216'),
                                                        ('Nary','nary@gmail.com','098567896'),
                                                        ('Jojo','jojo@gmail.com','098123908'),
                                                        ('elena','elena@gmail.com','098123567');
INSERT INTO instructors (instructor_name, email) values
                                                     ('Reaksmey','reaksmey@gmail.com'),
                                                     ('kimhout','kimhout@gmail.com'),
                                                     ('sothearit','sothearit@gmail.com'),
                                                     ('hongmeng','hongmeng@gmail.com'),
                                                     ('lundy','dydyboyloy@gmail.com')

INSERT INTO courses (course_name, description, instructor_id)
VALUES
    ('Spring Boot Basics', 'Introductory course on Spring Boot', 1),
    ('Advanced Java', 'Deep dive into Java features', 1),
    ('React Fundamentals', 'Learn the basics of React', 2),
    ('Database Design', 'Normalization and ER modeling concepts', 2);

INSERT INTO student_course (student_id, course_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 1),
    (3, 2),
    (4, 4),
    (5, 6);
SELECT *
FROM student_course sc
         INNER JOIN courses c ON sc.course_id = c.course_id
WHERE sc.student_id = 1;
INSERT INTO courses (course_name, description, instructor_id)
VALUES ('Networking', 'Cisco basics', 1);


