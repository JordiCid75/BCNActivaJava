
SELECT u.IdUlleres, m.NomMarca FROM culampolla.Marca m inner join culampolla.ulleres u on m.idMarca = u.idMarca
WHERE  u.`IdUlleres` IN 
(SELECT vd.IdUlleres FROM culampolla.VendaDetall vd 
INNER JOIN culampolla.Venda v ON v.IdVenda = vd.IdVenda 
WHERE v.IdVenedor = 1 AND DataVenda >= DATE_ADD(CURDATE(),INTERVAL -1 YEAR));

