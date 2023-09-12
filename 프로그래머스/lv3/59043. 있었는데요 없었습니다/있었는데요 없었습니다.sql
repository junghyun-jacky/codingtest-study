-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
-- 이때 결과는 보호 시작일이 빠른 순으로 조회

SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_OUTS O
    JOIN ANIMAL_INS I
        ON O.ANIMAL_ID = I.ANIMAL_ID
WHERE O.DATETIME < I.DATETIME
ORDER BY I.DATETIME;