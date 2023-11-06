

SELECT p.* FROM culampolla.Proveidor p
INNER JOIN culampolla.ulleres u on p.IdProveidor = u.IdProveidor
WHERE u.IdUlleres IN 
(SELECT vd.IdUlleres FROM culampolla.VendaDetall GROUP BY vd.IdUlleres);
