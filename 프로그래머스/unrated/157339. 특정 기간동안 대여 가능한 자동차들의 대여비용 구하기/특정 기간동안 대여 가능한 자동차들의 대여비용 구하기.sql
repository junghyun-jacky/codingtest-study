-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력

-- 대여 금액을 기준으로 내림차순 정렬하고,
-- 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬,
-- 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬
SELECT A.CAR_ID,
        A.CAR_TYPE, 
        FLOOR(A.DAILY_FEE * (1 - B.DISCOUNT_RATE*0.01) * 30) AS FEE 
FROM CAR_RENTAL_COMPANY_CAR AS A 
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS B 
        ON A.CAR_TYPE = B.CAR_TYPE AND B.DURATION_TYPE = '30일 이상'
WHERE A.CAR_TYPE IN ('세단', 'SUV') 
    AND A.CAR_ID NOT IN(
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30'
    )
AND FLOOR(A.DAILY_FEE * (1 - B.DISCOUNT_RATE*0.01) * 30) >= 500000 
AND FLOOR(A.DAILY_FEE * (1 - B.DISCOUNT_RATE*0.01) * 30) < 2000000
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC;