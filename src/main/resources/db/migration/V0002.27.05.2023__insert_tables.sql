insert into users (name, email, username, password, role, enabled)
values ('John Doe', 'johndoe@example.com', 'johndoe', '$2a$10$oQxL9ZZwFuxDg3tu6eE/Y.SBwMKDWLC4r34l07I8U466axSbpoGk6',
        'MANAGER', true),
       ('Jane Smith', 'janesmith@example.com', 'janesmith',
        '$2a$10$oQxL9ZZwFuxDg3tu6eE/Y.SBwMKDWLC4r34l07I8U466axSbpoGk6', 'DEVELOPER', true),
       ('Bob Johnson', 'bobjohnson@example.com', 'bobjohnson',
        '$2a$10$oQxL9ZZwFuxDg3tu6eE/Y.SBwMKDWLC4r34l07I8U466axSbpoGk6', 'DEVELOPER', true);