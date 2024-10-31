-- 코드를 작성해주세요
SELECT B.ID AS ID,
    B.EMAIL AS EMAIL,
    B.FIRST_NAME AS FIRST_NAME,
    B.LAST_NAME AS LAST_NAME
FROM (SELECT SUM(CODE) AS CODE
    FROM SKILLCODES
    WHERE CATEGORY = 'FRONT END') AS A, DEVELOPERS AS B
WHERE A.CODE & B.SKILL_CODE
ORDER BY ID