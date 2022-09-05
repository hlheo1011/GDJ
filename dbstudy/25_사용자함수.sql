/*
    사용자 함수
    
    1. Function
    2. 어떤 값을 반환할 때 사용
    3. 사용자가 만든 함수의 개념
    4. 값을 반활할 때 RETURN을 사용
    5. 입력 파라미터 사용 가능(출력 파라미터 사용 안함)
    6. 값을 확인할 수 있도록 SELECT문과 같은 쿼리문에서 호출
    7. 형식
        CREATE [OR REPLACE] FUNCTION 함수_이름[(매개변수)]
        RETURN 반환타입
        IS
            변수선언
        BEGIN
            함수본문
        [EXCEPTION
            예외처리]
        END [함수];
    
*/

-- 함수 FUNC1 정의
CREATE OR REPLACE FUNCTION FUNC1
RETURN VARCHAR2 -- 반환타입에서는 크기 명시하지 않음
IS
BEGIN
    RETURN 'HELLO WORLD'; -- 반환값
END FUNC;


-- 함수 FUNC1 호출