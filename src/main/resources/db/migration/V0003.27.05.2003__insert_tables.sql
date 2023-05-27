insert into statuses (status)
values ('created'),
       ('progress'),
       ('done'),
       ('failed');

insert into worklogs (time, description, created)
values ('1h', 'git init', '2023-05-27 10:30:00'),
       ('3h', 'added method', '2020-02-24 10:30:00'),
       ('2h', 'done', '2022-01-27 10:20:00');

insert into tasks (name, created, attachments, user_id, status_id, worklog_id)
values ('fix bugs', '2023-05-19 10:30:00', 'link1', 2, 1, 1),
       ('clear code', '2023-05-23 10:30:00', 'link2', 3, 3, 3),
       ('fix errors', '2023-05-24 10:30:00', 'link3', 3, 4, 3);