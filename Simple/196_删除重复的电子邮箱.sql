/*
编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id 是这个表的主键。
例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+

*/
drop table if exists Person;
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values (1, 'john@example.com');
insert into Person (Id, Email) values (2, 'bob@example.com');
insert into Person (Id, Email) values (3, 'john@example.com');

select * from Person;

delete p1  from Person as p1
inner join Person as p2 on p1.email = p2.email
where p1.Id > p2.Id;

select * from Person;