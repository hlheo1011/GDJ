-- SCOTT 계정 초기화
-- ** SYS계정으로 접속
-- ** SCOTT 계정 풀기

-- 1. SCOTT 계정과 SCOTT 계정이 가지고 있는 객체(테이블 등)를 함께 제거한다.
DROP USER SCOTT CASCADE;

-- 2. SCOTT 계정을 만든다.
CREATE USER SCOTT IDENTIFIED BY TIGER;

-- 3. SCOTT 계정에 접속 및 객체 사용 권한을 부여한다.
GRANT CONNECT, RESOURCE TO SCOTT;
GRANT DBA TO SCOTT; -- 뷰 생성 등 모든 권한을 가짐


-- 계정 접속 해제해도 안지워질때 --
-- select sid, serial#, username,status from v$session where username = 'SCOTT';
-- alter system kill SESSION '11,2501';
-- alter system kill SESSION '15,2061';
-- alter system kill SESSION '18,2067';
-- alter system kill SESSION '53,5175';
-- alter system kill SESSION '57,1887';
-- alter system kill SESSION '58,2053';

