Select cd.IdProducte, p.nom, l.nom, count(cd.IdProducte) from Pizzeria.ComandaDetall cd 
inner join Pizzeria.Producte p on p.IdProducte = cd.IdProducte 
inner join Pizzeria.Comanda c on cd.IdComanda = c.IdComanda 
inner join Pizzeria.Client cl on c.IdClient = cl.IdClient 
inner join Pizzeria.Localitat l on cl.IdLocalitat = l.IdLocalitat
where  p.IdCategoria = 1  and l.IdLocalitat = 2
Group by cd.IdProducte, p.nom, l.nom
Order by cd.IdProducte;