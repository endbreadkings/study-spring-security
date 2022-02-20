insert into member(email, grade, nickname, created_at)
values ('test1@jordy.com', 'EXECUTIVE', '킹죠랭', now()),
       ('test2@jordy.com', 'WORKER', '사원죠랭', now()),
       ('test3@jordy.com', 'JOBLESS', '백수죠랭', now());

insert into authorization(type, password, refresh_token, owner_id, created_at)
values ('local', 'zldwyfod123', 'tokentokentoken', 1, now()),
       ('local', 'tkdnjswyfod123', 'tokentokentoken', 2, now()),
       ('local', 'qortnwyfod123', 'tokentokentoken', 3, now());