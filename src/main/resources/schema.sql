create table if not exists students  (
    student_id  serial primary key,
student_name varchar(50) not null ,
    email varchar(50) not null,
    phone_number varchar(50)
);
create table if not exists instructors (
    instructor_id serial primary key ,
    instructor_name varchar(50) not null,
    email varchar(50) not null
);
CREATE TABLE courses (
                         course_id SERIAL PRIMARY KEY,
                         course_name VARCHAR(50) NOT NULL,
                         description varchar(100),
                         instructor_id INT NOT NULL,
                         CONSTRAINT fk_instructor
                             FOREIGN KEY (instructor_id)
                                 REFERENCES instructors(instructor_id)
);

CREATE TABLE IF NOT EXISTS student_course (
                                              student_id INT REFERENCES students(student_id) ON DELETE CASCADE ON UPDATE CASCADE,
                                              course_id  INT REFERENCES courses(course_id) ON DELETE CASCADE ON UPDATE CASCADE,
                                              PRIMARY KEY (student_id, course_id)
);

