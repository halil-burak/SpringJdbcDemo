create table author(
    id integer identity primary key,
    name varchar(100),
    birth_date date
);

create table book(
    id integer identity primary key,
    title varchar(255),
    isbn varchar(255)
);

create table book_author(
    author integer,
    book integer,
    name varchar(255),
    primary key (author, book)
);