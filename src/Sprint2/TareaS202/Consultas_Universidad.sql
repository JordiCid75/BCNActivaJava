use `Universidad`;

/*SQL #1*/
Select apellido1, apellido2, nombre from persona where tipo = "alumno" order by apellido1, apellido2, nombre;
/*SQL #2*/
Select apellido1, apellido2, nombre from persona where tipo = "alumno" and telefono is null;
/*SQL #3*/
Select apellido1, apellido2, nombre from persona where tipo = "alumno" and year(fecha_nacimiento) = 1999;
/*SQL #4*/
Select apellido1, apellido2, nombre from persona where tipo = "profesor" and telefono is null and nif like '%K';
/*SQL #5*/
Select * from asignatura where cuatrimestre = 1 and curso = 3 and id_grado = 7;
/*SQL #6*/
Select pe.apellido1, pe.apellido2, pe.nombre, d.nombre from profesor p  inner join persona pe on pe.id = p.id_profesor inner join departamento d on p.id_departamento = d.id order by pe.apellido1, pe.apellido2, pe.nombre;
/*SQL #7*/
select a.nombre, c.anyo_inicio, c.anyo_fin from alumno_se_matricula_asignatura asma inner join persona p on p.id = asma.id_alumno inner join asignatura a on a.id = asma.id_asignatura inner join curso_escolar c on c.id = asma.id_curso_escolar where nif = '26902806M';
/*SQL #8*/
select d.nombre from departamento d inner join profesor p on p.id_departamento = d.id inner join asignatura a on a.id_profesor = p.id_profesor where a.id_grado = 4 group by d.nombre;
/*SQL #9*/
select p.apellido1, p.apellido2, p.nombre, p.nif from alumno_se_matricula_asignatura asma inner join persona p on p.id = asma.id_alumno where asma.id_curso_escolar = 5 group by p.apellido1, p.apellido2, p.nombre, p.nif;

/*SQL LEFT o RIGHT JOIN*/
/*SQL #1*/
select  d.nombre, pe.apellido1, pe.apellido2, pe.nombre from persona pe left join profesor p on p.id_profesor = pe.id right join departamento d on d.id = p.id_departamento where pe.tipo = "Profesor" order by d.nombre, pe.apellido1, pe.apellido2, pe.nombre;

/*SQL #2*/
select * from persona left join profesor on profesor.id_profesor = persona.id where  tipo = "Profesor" and profesor.id_profesor is null;

/*SQL #3*/
select d.* from departamento d left join profesor p on d.id = p.id_departamento where p.id_departamento is null;

/*SQL #4*/
select p.* from persona p left join asignatura a on a.id_profesor = p.id where a.id_profesor is null and p.tipo = "Profesor";

/*SQL #5*/
select a.* from asignatura a left join persona p on a.id_profesor = p.id where a.id_profesor is null;

/*SQL #6*/
select d.id, d.nombre from profesor p inner join departamento d on d.id = p.id_departamento left join asignatura a on a.id_profesor = p.id_profesor where a.id is null group by d.id, d.nombre;

/*Consultas resumen*/
/*SQL #1*/
select count(*) from persona where tipo = "Alumno";
/*SQL #2*/
select count(*) from persona where tipo = "Alumno" and year(fecha_nacimiento) = 1999;
/*SQL #3*/
select d.nombre, count(p.id_profesor) as numProfesores from profesor p inner join departamento d on d.id = p.id_departamento group by d.nombre order by numProfesores DESC;
/*SQL #4*/
select d.nombre, count(p.id_profesor) as numProfesores from profesor p right join departamento d on d.id = p.id_departamento group by d.nombre order by numProfesores;
/*SQL #5*/
select g.nombre, count(a.id) as numAsignaturas from grado g left join asignatura a on a.id_grado = g.id group by g.nombre order by numAsignaturas DESC;
/*SQL #6*/
select g.nombre, count(a.id) as numAsignaturas from grado g left join asignatura a on a.id_grado = g.id group by g.nombre having count(a.id) > 40 order by numAsignaturas;
/*SQL #7*/
select g.nombre, a.tipo, sum(a.creditos) as SumaCreditos from grado g inner join asignatura a on a.id_grado = g.id group by g.nombre, a.tipo;
/*SQL #8*/
select c.anyo_inicio, count(asma.id_alumno) as NumeroAlumnos from curso_escolar c left join alumno_se_matricula_asignatura asma on asma.id_curso_escolar = c.id group by c.anyo_inicio;
/*SQL #9*/
select pe.id, pe.nombre, pe.apellido1, pe.apellido2, count(a.id) as NumAsignaturas from persona pe left join asignatura a on a.id_profesor = pe.id where pe.tipo = "Profesor" group by pe.id, pe.nombre, pe.apellido1, pe.apellido2 order by NumAsignaturas DESC;
/*SQL #10*/
select pe.* from persona pe where pe.fecha_nacimiento = (select max(fecha_nacimiento) from persona where tipo = "Alumno") and pe.tipo = "Alumno";
/*SQL #11*/
select pe.id, pe.nombre, pe.apellido1, pe.apellido2, d.nombre as NombreDepartamento from persona pe left join profesor pr on pr.id_profesor = pe.id left join asignatura a on a.id_profesor = pe.id left join departamento d on d.id = pr.id_departamento where pe.tipo = "Profesor" group by pe.id, pe.nombre, pe.apellido1, pe.apellido2 having count(a.id) = 0 order by NombreDepartamento;
