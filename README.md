create table Professor(
	id int auto_increment primary key,
    nome text,
    disciplina text
);

create table Aluno (
	id int auto_increment primary key,
    nome text,
    matricula VARCHAR(11),
    professor_id int,
    FOREIGN KEY (professor_id) REFERENCES Professor(id)
);