## Programmers_오랜기간보호한동물

```mysql
SELECT A.NAME , A.DATETIME
FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME LIMIT 3
	
```

