--sql�� ����
select * from ���̺��;
select �÷��� from ���̺��;
-- ���ǽ� : �÷��� = �� / �÷��� > ��
select �÷��� from ���̺�� where ���ǽ�;
select �÷��� from ���̺�� where ���ǽ� order by �����÷��� ���Ĺ��;
-- ���̺� �ִ� ��� �÷��� ���� �������̴�.
insert into ���̺�� values(��1, ��2, ��3);
--Ư���÷��� ���� �ִ� ��� --> �ε�����ȣ, �۹�ȣ : �ڵ����� �ִ� ���
insert into ���̺��(�÷���1, �÷���2, �÷���3) values(��1, ��2, ��3);
--�� ����
update ���̺�� set �÷���=��;
update ���̺�� set �÷���=�� where ���ǽ�;
update ���̺�� set �÷���1=��1, �÷���2=��2, where ���ǽ�;

--delete drop
delete from ���̺��;
--���� ����, ���ϴ°Ÿ� ����
delete from ���̺�� where ���ǽ�;

-- ���̺� �����
create table ���̺��(
�÷��� ������Ÿ��(����) not null,
constraint ooooooo_pk primary key(�÷���)
);

create table member_web(
id varchar2(100) not null,
pw varchar2(100) not null,
nick varchar2(100) not null,
constraint web_id_pk primary key(id)
);






