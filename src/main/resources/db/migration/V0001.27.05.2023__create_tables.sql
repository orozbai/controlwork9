create table statuses
(
    id     bigserial primary key,
    status text not null
);

create table users
(
    id       bigserial
        primary key,
    name     varchar(25) not null,
    email    varchar(25) not null,
    username varchar(25) not null,
    password text        not null,
    role     text        not null default 'DEVELOPER',
    enabled  bool        not null default true
);

create table tasks
(
    id          bigserial primary key,
    name        varchar(20) not null,
    created     timestamp   not null,
    attachments text,
    user_id     bigint      not null,
    foreign key (user_id) references users (id) on delete cascade,
    status_id   bigint      not null,
    foreign key (status_id) references statuses (id) on delete cascade
);

create table worklogs
(
    id          bigserial primary key,
    time        varchar(6)  not null,
    description varchar(50) not null,
    created     timestamp   not null,
    task_id     bigint,
    foreign key (task_id) references tasks (id) on delete cascade
);