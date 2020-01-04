CREATE TABLE IF NOT EXISTS academic_degrees
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS academic_ranks
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS positions
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS subjects
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS standards
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS student_must_types
(
    id   bigint(20)  NOT NULL,
    type varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS independent_work_forms
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS literature
(
    id   bigint(20)   NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS diagnostic_tools
(
    id   bigint(20)   NOT NULL,
    text varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS course_project_tasks
(
    id   bigint(20)   NOT NULL,
    text varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS competence_codes
(
    id   bigint(20)  NOT NULL,
    code varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS course_projects
(
    id             bigint(20)   NOT NULL,
    count_of_hours bigint(20)   NOT NULL,
    count_of_pages bigint(20)   NOT NULL,
    goal           varchar(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS course_project_topics
(
    id                bigint(20)   NOT NULL,
    course_project_id bigint(20)   NOT NULL,
    text              varchar(255) NOT NULL,
    topic_number      bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_project_id) REFERENCES course_projects (id)
);

CREATE TABLE IF NOT EXISTS student_musts
(
    id                   bigint(20)   NOT NULL,
    text                 varchar(255) NOT NULL,
    student_must_type_id bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (student_must_type_id) REFERENCES student_must_types (id)
);

CREATE TABLE IF NOT EXISTS universities
(
    id                                  bigint(20)   NOT NULL,
    abbreviation                        varchar(10) DEFAULT NULL,
    name                                varchar(255) NOT NULL,
    vice_rector_for_educational_work_id bigint(20)   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS faculties
(
    id                                bigint(20)   NOT NULL,
    abbreviation                      varchar(10) DEFAULT NULL,
    name                              varchar(255) NOT NULL,
    university_id                     bigint(20)   NOT NULL,
    methodical_commission_chairman_id bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (university_id) REFERENCES universities (id)
);

CREATE TABLE IF NOT EXISTS departments
(
    id         bigint(20)   NOT NULL,
    faculty_id bigint(20)   NOT NULL,
    name       varchar(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (faculty_id) REFERENCES faculties (id)
);

CREATE TABLE IF NOT EXISTS specialities
(
    id            bigint(20)   NOT NULL,
    code          varchar(255) NOT NULL,
    department_id bigint(20)   NOT NULL,
    direction     bit(1)       NOT NULL,
    full_time     bit(1)       NOT NULL,
    name          varchar(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES departments (id)
);

CREATE TABLE IF NOT EXISTS academics
(
    id                 bigint(20) NOT NULL,
    full_name          varchar(255) DEFAULT NULL,
    academic_degree_id bigint(20)   DEFAULT NULL,
    academic_rank_id   bigint(20)   DEFAULT NULL,
    department_id      bigint(20) NOT NULL,
    position_id        bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (academic_rank_id) REFERENCES academic_ranks (id),
    FOREIGN KEY (position_id) REFERENCES positions (id),
    FOREIGN KEY (academic_degree_id) REFERENCES academic_degrees (id),
    FOREIGN KEY (department_id) REFERENCES departments (id)
);

CREATE TABLE IF NOT EXISTS explanatory_notes
(
    id         bigint(20)   NOT NULL,
    date       date         NOT NULL,
    text       varchar(255) DEFAULT NULL,
    name       varchar(100) NOT NULL,
    subject_id bigint(20)   DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
);

CREATE TABLE IF NOT EXISTS active_specialities
(
    id                  bigint(20) NOT NULL,
    course              bigint(20) NOT NULL,
    exam                bit(1)     NOT NULL,
    explanatory_note_id bigint(20) NOT NULL,
    semester            bigint(20) NOT NULL,
    course_project_id   bigint(20) DEFAULT NULL,
    speciality_id       bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_project_id) REFERENCES course_projects (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (speciality_id) REFERENCES specialities (id)
);

CREATE TABLE IF NOT EXISTS sections
(
    id                  bigint(20)   NOT NULL,
    explanatory_note_id bigint(20)   NOT NULL,
    name                varchar(255) NOT NULL,
    section_number      bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id)
);

CREATE TABLE IF NOT EXISTS topics
(
    id           bigint(20)   NOT NULL,
    name         varchar(255) NOT NULL,
    section_id   bigint(20)   NOT NULL,
    text         varchar(255) NOT NULL,
    topic_number bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (section_id) REFERENCES sections (id)
);

CREATE TABLE IF NOT EXISTS laboratory_works
(
    id                  bigint(20)   NOT NULL,
    explanatory_note_id bigint(20)   NOT NULL,
    text                varchar(255) NOT NULL,
    work_number         bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id)
);

CREATE TABLE IF NOT EXISTS active_topics
(
    id                    bigint(20) NOT NULL,
    active_speciality_id  bigint(20) NOT NULL,
    defense               bit(1)     DEFAULT NULL,
    laboratory_work_hours bigint(20) DEFAULT NULL,
    lecture_hours         bigint(20) DEFAULT NULL,
    other_hours           bigint(20) DEFAULT NULL,
    usr_hours             bigint(20) DEFAULT NULL,
    topic_id              bigint(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (active_speciality_id) REFERENCES active_specialities (id),
    FOREIGN KEY (topic_id) REFERENCES topics (id)
);

CREATE TABLE IF NOT EXISTS control_questions
(
    id                  bigint(20)   NOT NULL,
    explanatory_note_id bigint(20)   NOT NULL,
    question_number     bigint(20)   NOT NULL,
    text                varchar(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id)
);

CREATE TABLE IF NOT EXISTS course_project_course_project_tasks
(
    course_project_id      bigint(20) NOT NULL,
    course_project_task_id bigint(20) NOT NULL,
    PRIMARY KEY (course_project_id, course_project_task_id),
    FOREIGN KEY (course_project_id) REFERENCES course_projects (id),
    FOREIGN KEY (course_project_task_id) REFERENCES course_project_tasks (id)
);

CREATE TABLE IF NOT EXISTS creators
(
    explanatory_note_id bigint(20) NOT NULL,
    academic_id         bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, academic_id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (academic_id) REFERENCES academics (id)
);

CREATE TABLE IF NOT EXISTS competences
(
    id                 bigint(20)   NOT NULL,
    speciality_id      bigint(20) DEFAULT NULL,
    text               varchar(255) NOT NULL,
    competence_code_id bigint(20)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (speciality_id) REFERENCES specialities (id),
    FOREIGN KEY (competence_code_id) REFERENCES competence_codes (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_additional_literature
(
    explanatory_note_id bigint(20) NOT NULL,
    literature_id       bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, literature_id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (literature_id) REFERENCES literature (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_basic_literature
(
    explanatory_note_id bigint(20) NOT NULL,
    literature_id       bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, literature_id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (literature_id) REFERENCES literature (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_competence
(
    explanatory_note_id bigint(20) NOT NULL,
    competence_id       bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, competence_id),
    FOREIGN KEY (competence_id) REFERENCES competences (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_diagnostic_tool
(
    explanatory_note_id bigint(20) NOT NULL,
    diagnostic_tool_id  bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, diagnostic_tool_id),
    FOREIGN KEY (diagnostic_tool_id) REFERENCES diagnostic_tools (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_independent_work_form
(
    explanatory_note_id      bigint(20) NOT NULL,
    independent_work_form_id bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, independent_work_form_id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (independent_work_form_id) REFERENCES independent_work_forms (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_standard
(
    explanatory_note_id bigint(20) NOT NULL,
    standard_id         bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, standard_id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (standard_id) REFERENCES standards (id)
);

CREATE TABLE IF NOT EXISTS explanatory_note_student_must
(
    explanatory_note_id bigint(20) NOT NULL,
    student_must_id     bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, student_must_id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id),
    FOREIGN KEY (student_must_id) REFERENCES student_musts (id)
);

CREATE TABLE IF NOT EXISTS reviewers
(
    explanatory_note_id bigint(20) NOT NULL,
    academic_id         bigint(20) NOT NULL,
    PRIMARY KEY (explanatory_note_id, academic_id),
    FOREIGN KEY (academic_id) REFERENCES academics (id),
    FOREIGN KEY (explanatory_note_id) REFERENCES explanatory_notes (id)
);


