USE tienda;
/*SQL #1*/
select nombre from producto;
/*SQL #2*/
Select nombre, precio from producto;
/*SQL #3*/
select * from producto;
/*SQL #4*/
select nombre, precio as PrecioEUR, (precio * 1.07) as PrecioUSD from producto;
/*SQL #5*/
select nombre as 'Nom de Producto', precio as euros, (precio * 1.07) as dolars from producto;
/*SQL #6*/
select upper(nombre), precio from producto; 
/*SQL #7*/
select lower(nombre), precio from producto; 
/*SQL #8*/
select nombre, upper(left(nombre,2)) as ABR_Fabricante from fabricante;
/*SQL #9*/
select nombre, round(precio) from producto; 
/*SQL #10*/
select nombre, truncate(precio,0) from producto; 
/*SQL #11*/
select f.codigo from fabricante f inner join producto p on p.codigo_fabricante = f.codigo;
/*SQL #12*/
select f.codigo from fabricante f inner join producto p on p.codigo_fabricante = f.codigo group by f.codigo;
/*SQL #13*/
select nombre from fabricante order by nombre ASC;
/*SQL #14*/
select nombre from fabricante order by nombre DESC;
/*SQL #15*/
select nombre from producto order by nombre ASC, precio DESC;
/*SQL #16*/
select * from fabricante limit 5;
/*SQL #17*/
select * from fabricante limit 3,2;
/*SQL #18*/
select nombre, precio from producto order by precio ASC limit 1;
/*SQL #19*/
select nombre, precio from producto order by precio DESC limit 1;
/*SQL #20*/
select nombre, codigo_fabricante from producto where codigo_fabricante = 2;
/*SQL #21*/
select p.nombre, p.precio, f.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo;
/*SQL #22*/
select p.nombre, p.precio, f.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo order by f.nombre ASC;
/*SQL #23*/
select p.nombre, p.precio, p.codigo_fabricante, f.nombre from producto p left join fabricante f on p.codigo_fabricante = f.codigo;
/*SQL #24*/
select p.nombre, p.precio, f.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo order by p.precio limit 1;
/*SQL #25*/
select p.nombre, p.precio, f.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo order by p.precio DESC limit 1;
/*SQL #26*/
select p.* from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre = "Lenovo";
/*SQL #27*/
select p.* from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre = "Crucial" and p.precio > 200;
/*SQL #28*/
select p.* from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre = "Asus" or f.nombre = "Hewlett-Packard" or f.nombre = "Seagate";
/*SQL #29*/
select p.* from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre in("Asus", "Hewlett-Packard", "Seagate");
/*SQL #30*/
select p.nombre, p.precio from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre like '%e';
/*SQL #31*/
select p.nombre, p.precio from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre like '%w%';
/*SQL #32*/
select p.nombre, p.precio, f.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where p.precio >= 180 order by p.precio DESC, p.nombre;
/*SQL #33*/
select f.codigo, f.nombre from fabricante f where f.codigo in (select codigo_fabricante from producto group by codigo_fabricante);
/*SQL #34*/
select f.*, p.* from fabricante f left join producto p on p.codigo_fabricante = f.codigo;
/*SQL #35*/
select f.*, p.* from fabricante f left join producto p on p.codigo_fabricante = f.codigo where p.codigo_fabricante is null;
/*SQL #36*/
select p.* from producto p where p.codigo_fabricante in(select codigo from fabricante where nombre = "Lenovo");
/*SQL #37*/
select p.nombre from producto p where p.precio = (select max(precio) from producto p where p.codigo_fabricante = (Select codigo from fabricante where nombre = "Lenovo"));
/*SQL #38*/
select p.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre = "Lenovo" and p.precio = (select max(precio) from producto p where p.codigo_fabricante = f.codigo);
/*SQL #39*/
select p.nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre = "Hewlett-Packard" and p.precio = (select min(precio) from producto p where p.codigo_fabricante = f.codigo);
/*SQL #40*/
select p.* from producto p where p.precio >= (select max(precio) from producto p where p.codigo_fabricante = (Select codigo from fabricante where nombre = "Lenovo"));
/*SQL #41*/
select p.* from producto p inner join fabricante f on p.codigo_fabricante = f.codigo where f.nombre = "Asus" and p.precio > (select avg(precio) from producto p where p.codigo_fabricante = f.codigo);
