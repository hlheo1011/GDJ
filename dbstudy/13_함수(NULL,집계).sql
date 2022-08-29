-- 함수 확인용 기초데이터
DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NAME VARCHAR2(20 BYTE),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MATH NUMBER(3)
);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES(NULL, 100, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('영숙', NULL, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('정수', 100, NULL, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('지영', 100, 100, NULL);
COMMIT;

-- NULL값의 연산에서 사용되면 결과가 NULL이다.
SELECT 1 + NULL FROM DUAL;

-- NULL 처리 함수

-- 1. NVL 함수
--    NVL(칼럼, 칼럼값이 NULL일 때 대신 사용할 값)

-- NAME이 없으면 '아무개', KOR, ENG, MATH가 없으면 0으로 조회
SELECT
       NVL(NAME, '아무개') AS STU_NAME
     , NVL(KOR, 0)
     , NVL(ENG, 0)
     , NVL(MATH, 0)
  FROM
       SAMPLE
 ORDER BY
       STU_NAME ASC;
       
-- 이름과 총점을 조회하기
-- 이름이 없으면 '아무개', 점수가 없으면 0점 처리
-- 결과
-- 아무개 300
-- 영숙   200
-- 정수   200
-- 지영   200
SELECT
       NVL(NAME, '아무개') AS 이름
     , NVL(KOR, 0) + NVL(ENG, 0) + NVL(MATH, 0) AS 총점
     , KOR + ENG + MATH -- 이렇게 하면 안됨
  FROM SAMPLE;
  
-- 2. NVL2 함수 (IF ELSE 느낌)
--    NVL2(칼럼, NULL이 아닐 떄 사용할 값, NULL일 때 사용할 값)
SELECT
       NVL2(NAME, NAME || '님', '아무개') 
       -- (NAME, NAME) NAME이 NULL이 아니면 NAME 그대로 쓰고, ('아무개') NAME이 NULL이면 '아무개'로 써라. || = 연결 연산자(JAVA에서 +)
     , NVL2(KOR, '응시', '결시')
     , NVL2(ENG, '응시', '결시')
     , NVL2(MATH, '응시', '결시')
  FROM
       SAMPLE;
       
-- 집계함수 (그룹함수)
-- 1. 통계(합계, 평균, 최대, 최소, 개수 등)를 낼 때 사용
-- 2. NULL값을 연산에서 제외
-- 3. 종류
--    1) SUM(칼럼)   : 칼럼 합계
--    2) AVG(칼럼)   : 칼럼 평균(Average)
--    3) MAX(칼럼)   : 칼럼 최대값
--    4) MIN(칼럼)   : 칼럼 최소값
--    5) COUNT(칼럼) : 칼럼에 입력된 데이터의 개수

-- 각 칼럼(KOR, ENG, MATH)의 합계
SELECT
       SUM(KOR)  -- 국어합
     , SUM(ENG)  -- 영어합
     , SUM(MATH) -- 수학 합
--   , SUM(KOR, ENG, MATH)  인수(aruments)가 3개이므로 불가능함(인수 1개여야 함)
     , SUM(KOR + ENG + MATH) -- KOR + ENG + MATH와 같은 연산(SUM 함수를 잘못 사용한 예시)
     , SUM(KOR) + SUM(ENG) + SUM(MATH) -- 국어합 + 영어합 + 수학합
  FROM
       SAMPLE;
-- SUM은 칼럼에서만 사용 가능(세로)
-- 로우단위는 이미 + 를 사용하면 된다.

-- 각 칼럼(KOR, ENG, MATH)의 평균
SELECT
       AVG(KOR)  -- NULL 제외한 KOR의 평균
     , AVG(ENG)  -- NULL 제외한 ENG의 평균
     , AVG(MATH) -- NULL 제외한 MATH의 평균
  FROM
       SAMPLE;

-- NULL값은 결시를 의미하므로 0점 처리함
SELECT
      AVG(NVL(KOR, 0))
    , AVG(NVL(ENG, 0))
    , AVG(NVL(MATH, 0))
  FROM
       SAMPLE;

-- 각 칼럼(KOR, ENG, MATH)의 최대값
SELECT
       MAX(KOR)
     , MAX(ENG)
     , MAX(MATH)
  FROM 
       SAMPLE;

-- 각 칼럼(KOR, ENG, MATH)의 최소값
-- NULL값은 결시를 의미하므로 0점 처리함
SELECT
       MIN(NVL(KOR, 0))
     , MIN(NVL(ENG, 0))
     , MIN(NVL(MATH, 0))
  FROM
       SAMPLE;

-- 국어 시험을 응시한 학생이 몇 명인가?
SELECT
       COUNT(KOR)
  FROM
       SAMPLE;


-- 전체 학생은 몇 명인가? (전체 Row의 개수)
SELECT 
       COUNT(*)
  FROM
       SAMPLE;





























