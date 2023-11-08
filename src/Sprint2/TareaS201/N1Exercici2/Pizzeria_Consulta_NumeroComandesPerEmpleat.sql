Select e.nom, count(c.IdComanda) as numComandes from Pizzeria.Comanda c
inner join Pizzeria.Empleats e on c.IdEmpleat = e.IdEmpleat
Group by e.nom;