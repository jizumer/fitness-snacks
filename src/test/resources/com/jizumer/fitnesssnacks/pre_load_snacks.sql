INSERT INTO SNACKS (ID, TYPE, DONE)
SELECT '123456' as ID, 'squats' as TYPE, '2022-12-29 20.15.00' as DONE
WHERE NOT EXISTS(
        SELECT *
        FROM SNACKS
        WHERE ID = '123456'
    );