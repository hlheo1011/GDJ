/*
    DQL
    
    1. Data Query Language
    2. 데이터의 질의어
    3. 테이블의 데이터를 조회/검색
    4. 데이터베이스에 변화가 없으므로 COMMIT 없음
        (트랜잭션의 대상이 아님)
    5. 형식
        SELECT 칼럼1, 칼럼2, ...
          FROM 테이블
        [WHERE 조건식]
        [GROUP BY 그룹화]
        [HAVING 그룹화_조건식]
        [ORDER BY 정렬]
    6. 실행 순서
     ⑤ SELECT 칼럼
     ①   FROM 테이블
     ②  WHERE 조건식
     ③  GROUP BY 그룹화
     ④ HAVING 그룹화_조건식
     ⑥  ORDER BY 정렬기준
    
*/

-- 1. 사원 테이블에서 사원명 조회하기
SELECT NAME
    FROM EMPLOYEE;
    
-- 1) 테이블에 오너(OWNER) 명시
SELECT NAME
    FROM SCOTT.EMPLOYEE;
    
-- 2) 칼럼에 테이블 명시
SELECT EMPLOYEE.NAME
    FROM EMPLOYEE;

-- 3) 테이블에 별명 지정
SELECT EMP.NAME
    FROM EMPLOYEE EMP; -- 별명 EMP 지정
    
-- 4) 칼럼에 별명(ALIAS) 지정
SELECT NAME AS 사원명  -- 별명 사원명 지정 
    FROM EMPLOYEE;
    
-- 2. 사원 테이블의 모든 칼럼 조회하기
--    모든 칼럼 : *
--         중요 : 실무에서 * 사용 금지(성능문제있음)
SELECT *
  FROM EMPLOYEE;
    
-- 모든 칼럼이 필요하면 모두 명시
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE;
    
-- 3. 사원 테이블에서 지역명 조회하기
--    단, 동일한 지역은 한 번만 조회하기
--    중복 제거 : DISTINCT
SELECT DISTINCT LOCATION
  FROM DEPARTMENT;
    

SELECT DISTINCT DEPT_NAME, LOCATION
  FROM DEPARTMENT;
    
-- 4. 사원 테이블에서 직급이 '과장'인 사원 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE POSITION = '과장';
   
-- 5. 사원 테이블에서 급여가 2000000~5000000인 사원 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 2000000
   AND SALARY <= 5000000;
     
-- 5번과 같은 코드. 이 코드를 더 권장 한다.
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
  WHERE SALARY BETWEEN 2000000 AND 5000000;
    
-- 6. 사원 테이블에서 소속부서가 1,2인 사원 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPT_NO = 1
    OR DEPT_NO = 2;
    
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPT_NO IN (1, 2);
   
-- 7. 사원 테이블에서 성별이 없는 사원 조회
--    NULL 유무
--    1) NULL이다   : IS NULL
---   2) NULL아니다 : IS NOT NULL

SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE GENDER IS NULL;
   
-- 8. 사원 테이블에서 김씨 조회
--    1) 만능문자(WILD CARD)
--       (1) % : 모든 문자, 글자수 제한 없음
--       (2) _ : 모든 문자, 한 글자로 제한
--    2) 예시
--       (1) 김으로 시작하는 이름 찾기 : 김%
--       (2) 김으로 끝나는 이름 찾기 : %김
--       (3) 김을 포함하는 이름 찾기 : %김%
--    3) 만능문자 연산자
--       LIKE, NOT LIKE
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE NAME LIKE '김%';
 
-- 9. 사원 테이블에서 사원번호가 1로 시작하는 사원 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE EMP_NO LIKE '1%';
-- 오라클은 TEXT나 NUMBER 타입이나 스스로 캐스팅 해서 사용된다.

/* ORDER BY절*/
-- ASC  : 오름차순 정렬, 생략 가능
-- DESC : 내림차순 정렬

-- 10. 사원 테이블에서 사원명의 가나다순으로 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY NAME ASC;
 
-- 11. 사원 테이블에서 급여가 높은순으로 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY SALARY DESC;
 
-- 12. 사원 테이블에서 성별의 가나다순으로 조회하기
--     오름차순 정렬할 때 NULL값은 마지막에 배치
--     내림차순 정렬할 때 NULL값은 맨처음에 배치
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY GENDER DESC;
 
-- 13. 사원 테이블에서 먼저 고용된순으로 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY HIRE_DATE;
 
-- 14. 사원 테이블에서 소속부서의 오름차순 정렬로 조회하되,
--     같은 소속부서 내에서는 먼저 고용된순으로 조회하기
--     1차 정렬기준 : 소속부서
--     2차 정렬기준 : 고용일자
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 ORDER BY DEPT_NO ASC, HIRE_DATE ASC;
 
/* WHERE절과 ORDER BY절 함께 사용 */
 
-- 15. 사원 테이블에서 급여가 5000000 이상인 사원들을 고용된순으로 조회하기
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 5000000
 ORDER BY HIRE_DATE;
 
/* SELECT문 처리순서 */
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE AS HD, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 5000000
 ORDER BY HD;

-- 아래코드는 오류가 난다. (SELECT문 처리 순서 때문에)
SELECT EMP_NO, NAME, DEPT_NO, POSITION, GENDER, HIRE_DATE, SALARY AS S
  FROM EMPLOYEE
 WHERE S >= 5000000
 ORDER BY HIRE_DATE;
  