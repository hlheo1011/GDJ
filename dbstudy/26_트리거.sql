/*
    트리거
    
    1. Trigger
    2. DML(INSERT, UPDATE, DELETE)수행 후 트리거가 자동으로 수행됨
    3. DML 직전에 수행되는 BEFORE 트리거, 직후에 수행되는 AFTER 트리거가 있음
    4. 기본적으로 작업 수행 행(ROW) 단위로 트리거가 적용
    5. 형식
        CREATE [OR REPLACE] TRIGGER 트리거_이름
        [ALTER | BEFORE]
        [INSERT OR UPDATE OR DELETE]   -- 골라서 적용
        [ON 테이블_이름]
        [FOR EACH ROW]
        BEGIN
            트리거 작업
        END [트리거_이름];
        
*/

-- 트리거 TRIG1 정의
CREATE OR REPLACE TRIGGER TRIG1
    AFTER         -- AFTER, BEFORE
    UPDATE        -- INSERT OR UPDATE OR DELETE
    ON DEPARTMENT -- DEPARTMENT 테이블을 UPDATE할 때 동작함
    FOR EACH ROW  -- UPDATE되는 행마다 트리거가 동작함
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END TRIG1;

-- 트리거 TRIG1 동작 확인
UPDATE DEPARTMENT
   SET LOCATION = '인천'
 WHERE DEPT_NO = 1;

-- 트리거 TRIG2 정의
CREATE OR REPLACE TRIGGER TRIG2
    AFTER
    INSERT OR UPDATE OR DELETE  -- 작성 순서 없음
    ON DEPARTMENT
    FOR EACH ROW
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('INSERT 이후 동작');
    ELSIF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('UPDATE 이후 동작');
    ELSIF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('DELETE 이후 동작');
    END IF;
END TRIG2;

-- 트리거 TRIG2 동작 확인
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(5, '개발부', '제주');
UPDATE DEPARTMENT SET LOCATION = '경주' WHERE DEPT_NO = 2;
DELETE FROM DEPARTMENT WHERE DEPT_NO = 3;

-- 원상복구(원복) = ROLLBACK 하면 된다.N
-- DEPARTMENT 테이블의 DML 작업 취소
-- 이전 COMMIT까지의 작업
ROLLBACK;


-- 트리거 TRIG3 정의

-- OLD 테이블
-- 1. INSERT, UPDATE, DELETE 수행 이전 정보가 저장되는 테이블
-- 2. 오라클에서는 :OLD로 호출
-- 3. AFTER 트리거와 함께 사용
--    1) INSERT 동작 이전 : NULL
--    2) UPDATE 동작 이전 : 수정 전 데이터
--    3) DELETE 동작 이전 : 삭제 된 데이터

CREATE OR REPLACE TRIGGER TRIG3
    AFTER
    INSERT OR UPDATE OR DELETE
    ON EMPLOYEE
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.NAME);
END TRIG3;

-- 트리거 TRIG3 동작 확인
UPDATE EMPLOYEE
    SET NAME = '팔창민'
 WHERE EMP_NO = 1001;
    

    








