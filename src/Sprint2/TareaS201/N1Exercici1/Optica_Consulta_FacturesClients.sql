
SELECT * FROM `culampolla`.`Venda` 
WHERE `IdClient`= 1 AND `DataVenda`BETWEEN DATE_ADD(NOW(),INTERVAL -6 MONTH) 
and DATE_ADD(NOW(),INTERVAL -2 MONTH);

