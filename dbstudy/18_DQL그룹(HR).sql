      -- 그룹(GROUP BY)
-- 1. GROUP BY절에서 지정한 칼럼의 데이터는 하나로 모아서 한 번만 조회가 됨
-- 2. SELECT절에서 조회할 칼럼은 "반드시"

-- EMPLOYEES 테이블

-- 1. 동일한 부서번호(DEPARTMENT_ID)로 그룹화하여 조회
SELECT DEPARTMENT_ID
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;

-- 2. 그룹화 실패
-- EMPLOYEE_ID를 조회하려면 GROUP BY절에 EMPLOYEE_ID가 있어야 함
SELECT EMPLOYEE_ID
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;
 
-- 3. 그룹화 함수 사용
-- 집계함수(그룹함수)는 GROUP BY절에 해당 칼럼이 없어도 SELECT절에서 조회 가능함
SELECT
       DEPARTMENT_ID
     , SUM(SALARY) AS 부서별연봉합계
     , FLOOR(AVG(SALARY)) AS 부서별연봉평균
     , MAX(SALARY) AS 부서별최대연봉
     , MIN(SALARY) AS 부서별최소연봉
     , COUNT(*) AS 부서별사원수
  FROM
       EMPLOYEES
 GROUP BY
       DEPARTMENT_ID;
       
-- 4. 조건 지정
--    1) GROUP BY로 처리할 행(ROW)은 적을수록 성능에 유리함
--    2) WHERE절  : GROUP BY 이전에 처리되므로 가능한 모든 조건은 WHERE절에서 처리함
--    3) HAVING절 : WHERE절로 처리할 수 없는 조건만 HAVING절로 처리함

-- 1) 부서번호가 100 미만인 부서들의 연봉평균을 조회하기(WHERE절, HAVING절 모두 가능한 조건)
-- WHERE절 : 성능이 더 우수한 쿼리
SELECT
       DEPARTMENT_ID
     , FLOOR(AVG(SALARY)) AS 부서별연봉평균
  FROM
       EMPLOYEES
 WHERE
       DEPARTMENT_ID < 100
 GROUP BY
       DEPARTMENT_ID;
       
-- HAVING절 : 가능하지만 성능이 떨어지는 쿼리
SELECT
       DEPARTMENT_ID
     , FLOOR(AVG(SALARY)) AS 부서별연봉평균
  FROM
       EMPLOYEES
 GROUP BY
       DEPARTMENT_ID
HAVING
       DEPARTMENT_ID < 100;
-- WHERE 절과 HAVING절이 고민되면 고민하지말고 WHERE절에서 써라.
-- 불필요한걸 미리 뺴고(WHERE)

-- 2) 소속된 사원수가 10명 이상이 부서의 연봉평균 조회하기(HAVING절만 가능)
-- 소속된 사원수는 GROUP BY 이후에만 알 수 있기 때문에 WHERE절로 처리가 불가능
SELECT30
       DEPARTMENT_ID
     , FLOOR(AVG(SALARY)) AS 부서별연봉평균
  FROM
       EMPLOYEES
 GROUP BY
       DEPARTMENT_ID
HAVING
       COUNT(*) >= 10;

 