
SELECT Marca FROM culampolla.ulleres u
WHERE  u.`IdUlleres` IN 
(SELECT vd.IdUlleres FROM culampolla.VendaDetall vd 
INNER JOIN culampolla.Venda v ON v.IdVenda = vd.IdVenda 
WHERE v.IdVenedor = 1 AND DataVenda >= DATE_ADD(CURDATE(),INTERVAL -1 YEAR));

