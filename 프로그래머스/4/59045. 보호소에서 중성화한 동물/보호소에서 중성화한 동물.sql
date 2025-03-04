-- 코드를 입력하세요
SELECT A.ANIMAL_ID AS ANIMAL_ID, A.ANIMAL_TYPE AS ANIMAL_TYPE, A.NAME AS NAME
FROM ANIMAL_INS AS A
INNER JOIN ANIMAL_OUTS AS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE ('Intact%')
AND (B.SEX_UPON_OUTCOME LIKE ('Spayed%') 
OR B.SEX_UPON_OUTCOME LIKE ('Neutered%'))