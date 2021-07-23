# 创建员工表
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`
(
    `EMPNO`    int(4) NOT NULL COMMENT '工号',
    `ENAME`    varchar(10) DEFAULT NULL COMMENT '姓名',
    `JOB`      varchar(9)  DEFAULT NULL COMMENT '工作岗位',
    `MGR`      varchar(10) DEFAULT NULL COMMENT '部门经理',
    `HIREDATE` date        DEFAULT NULL COMMENT '受雇日期',
    `SAL`      int(7)      DEFAULT NULL COMMENT '薪金',
    `COMM`     int(7)      DEFAULT NULL COMMENT '奖金',
    `DEPTNO`   int(2)      DEFAULT NULL COMMENT '部门编号',
    PRIMARY KEY (`EMPNO`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 添加数据
insert into `emp`(`EMPNO`, `ENAME`, `JOB`, `MGR`, `HIREDATE`, `SAL`, `COMM`, `DEPTNO`)
values ('7369', 'SMITH', 'CLERK', '7902', '1980-12-17', '800', null, '20'),
       ('7499', 'ALLEN', 'SALESMAN', '7698', '1981-02-20', '1600', '300', '30'),
       ('7521', 'WARD', 'SALESMAN', '7698', '1981-02-22', '1250', '500', '30'),
       ('7566', 'JONES', 'MANAGER', '7839', '1981-04-02', '2975', null, '20'),
       ('7654', 'MARTIN', 'SALESMAN', '7698', '1981-09-28', '1250', '1400', '30'),
       ('7698', 'BLAKE', 'MANAGER', '7839', '1981-05-01', '2850', null, '30'),
       ('7782', 'CLARK', 'MANAGER', '7839', '1981-06-09', '2450', null, '10'),
       ('7788', 'SCOTT', 'ANALYST', '7566', '1987-04-19', '3000', null, '20'),
       ('7839', 'KING', 'PRESIDENT', null, '1981-11-17', '5000', null, '10'),
       ('7844', 'TURNER', 'SALESMAN', '7698', '1981-09-08', '1500', '0', '30'),
       ('7876', 'ADAMS', 'CLERK', '7788', '1987-05-23', '1100', null, '20'),
       ('7900', 'JAMES', 'CLERK', '7698', '1981-12-03', '950', null, '30'),
       ('7902', 'FORD', 'ANALYST', '7566', '1981-12-03', '3000', null, '20'),
       ('7934', 'MILLER', 'CLERK', '7782', '1982-01-23', '1300', null, '10');

# 部门表 增加数据
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`
(
    `DEPTNO` int(2) NOT NULL COMMENT '部门编号',
    `DNAME`  varchar(14) DEFAULT NULL COMMENT '部门名称',
    `LOC`    varchar(13) DEFAULT NULL COMMENT '部门所在地址',
    PRIMARY KEY (`DEPTNO`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

insert into `dept`(`DEPTNO`, `DNAME`, `LOC`)
values ('10', 'ACCOUNTING', 'NEW YORK'),
       ('20', 'RESEARCH', 'DALLAS'),
       ('30', 'SALES', 'CHICAGO'),
       ('40', 'OPERATIONS', 'BOSTON');

# 问题

# 1． 列出至少有4个员工的所有部门编号和名称。
#
# 2． 列出薪金比“SMITH”多的所有员工。
#
# 3． 列出所有员工的姓名及其直接上级的姓名。
#
# 4． 列出受雇日期早于其直接上级的所有员工。
#
# 5． 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
#
# 6． 列出所有“CLERK”（办事员）的姓名及其部门名称。
#
# 7． 列出最低薪金大于1500的各种工作。
#
# 8． 列出在部门“SALES”（销售部）工作的员工的姓名，假定不知道销售部的部门编号
#
# 9． 列出薪金高于公司平均薪金的所有员工。
#
# 10．列出与“SCOTT”从事相同工作的所有员工。
#
# 11．列出薪金等于部门30中员工的薪金的所有员工的姓名和薪金。
#
# 12．列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金。
#
# 13．列出在每个部门工作的员工数量、平均工资和平均服务期限。
#
# 14．列出所有员工的姓名、部门名称和工资。
#
# 15．列出所有部门的详细信息和部门人数。
#
# 16．列出各种工作的最低工资。
#
# 17．列出各个部门的MANAGER（经理）的最低薪金。
#
# 18．列出所有员工的年工资,按年薪从低到高排序。
#
# 思考： 列出每个部门薪水前两名最高的人员名称以及薪水



### 答案：###

# 1． 列出至少有4个员工的所有部门编号和名称。
select ss.DEPTNO,d.DNAME from (select DEPTNO from (select DEPTNO,count(*) as cn from emp group  by DEPTNO)s  where s.cn>=4)ss left join dept d on ss.DEPTNO=d.DEPTNO;

select ss.DEPTNO,d.DNAME from (select DEPTNO,count(*) as cn from emp group by DEPTNO having count(*) > 4)ss left join dept d on ss.DEPTNO=d.DEPTNO;
# 2． 列出薪金比“SCOTT”多的所有员工。
select ENAME,SAL from emp where sal>(select sal from emp where ENAME='SCOTT');

 select e.ENAME, e.SAL from (select ENAME,SAL,1 as cid  from emp)e
                                    left join (select SAL,1 as cid  from emp where ENAME='SCOTT' )s
                                              on e.cid=s.cid where e.SAL>s.SAL;

# 3． 列出所有员工的姓名及其直接上级的姓名。
select e.ENAME,ee.ENAME from emp e left join (select EMPNO,ENAME,MGR from emp ) ee on e.MGR=ee.EMPNO;

# 4． 列出受雇日期早于其直接上级的所有员工。
select e.ENAME from emp e left join (select * from emp ) ee on e.MGR=ee.EMPNO where e.hiredate<ee.hiredate;

# 5． 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
select  * from dept d left join emp  e on d.DEPTNO=e.DEPTNO;

# 6． 列出所有“CLERK”（办事员）的姓名及其部门名称。
select j.ENAME,d.DNAME from (select * from emp where JOB= "CLERK" ) j left join dept d on j.DEPTNO=d.DEPTNO

#     7． 列出最低薪金大于1500的各种工作。
select  distinct JOB from emp where SAL > 1500;

# 8． 列出在部门“SALES”（销售部）工作的员工的姓名，假定不知道销售部的部门编号
select e.ENAME from emp e join  dept d on d.DEPTNO=e.DEPTNO where d.DNAME="SALES";

# 9． 列出薪金高于公司平均薪金的所有员工。
select  ENAME from emp where SAL>(select avg(SAL) from emp);

select e.ENAME from (select  *,1 as cid from emp) e left join (select avg(SAL) cn,1 as cid from emp) s  on e.cid=s.cid  where e.sal>s.cn;

# 10．列出与“SCOTT”从事相同工作的所有员工。
select p.ENAME from (select * from emp where  ENAME='SCOTT' ) e left join (select * from emp where  ENAME!='SCOTT' ) p on e.JOB=p.JOB;

select ENAME from emp where JOB=(select JOB from emp where  ENAME='SCOTT') and  ENAME != 'SCOTT';

# 11．列出薪金等于部门30中员工的薪金的所有员工的姓名和薪金。
select ep.ENAME,ep.SAL from (select distinct sal from emp where DEPTNO='30') e left join  emp ep on e.SAL=ep.SAL;

select ENAME,SAL from emp where sal in (select sal from emp where  DEPTNO='30' );

# 12．列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金。
select e.ENAME,e.SAL from (select  *,1 as cid from emp) e left join (select max(SAL) cn,1 as cid from emp where  DEPTNO='30') s on e.cid=s.cid where e.sal>s.cn;
select ENAME,SAL from emp where sal > (select max(sal) from emp where  DEPTNO='30' );

# 13．列出在每个部门工作的员工数量、平均工资和平均服务期限。

select  DEPTNO,count(ENAME) as name ,avg(sal) as avg_sal,round(avg(datediff(current_timestamp,hiredate)),1) as avg_day from emp group by DEPTNO;

# 14．列出所有员工的姓名、部门名称和工资。
select e.ENAME,d.DNAME,e.sal from emp e left join dept d on e.DEPTNO=d.DEPTNO;

# 15．列出所有部门的详细信息和部门人数。
select * from dept d left join (select DEPTNO,count(ENAME) as cn from emp group by DEPTNO )  e on e.DEPTNO=d.DEPTNO;

# 16．列出各种工作的最低工资。
select job,min(sal)  from emp group by job;

#17．列出各个部门的MANAGER（经理）的最低薪金。
select DEPTNO,min(SAL)  FROM emp where job ='MANAGER' group by DEPTNO;

#18．列出所有员工的年工资,列出年薪最高的前3个员工。
select ENAME,sal*12+COMM as all_m from emp order by all_m desc limit 3;

select * from (select ENAME,sal*12+COMM as all_m from emp) e order by e.all_m desc limit 3;

# 思考：  列出每个部门薪水前两名最高的人员名称以及薪水
select deptno,ename,sal from emp as a where 2> (select count(*) from emp where deptno = a.deptno and sal < a.sal  )  order by a.deptno ,a.sal desc;

