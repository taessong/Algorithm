-- 코드를 입력하세요
SELECT INS.NAME AS NAME, INS.DATETIME AS DATETIME
FROM ANIMAL_INS AS INS
LEFT OUTER JOIN ANIMAL_OUTS AS OUTS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE OUTS.DATETIME IS NULL
ORDER BY INS.DATETIME
LIMIT 3