MATCH
	( r:Region { r_name:"America" } ) -[:CONTAINS]-> ( n:Nation ) -[:HAS_ORDER]-> ( o:Order )
WHERE
	o.o_orderdate >= 20190500
	AND o.o_orderdate <  20190566
MATCH
	(o) -[:HAS]-> ( l:LineItem ) <-[:SUPPLIES]- ( s:Supplier ) <-[:HAS_SUP]- ( n )
WITH
	n,
	SUM( l.l_extendedprice * ( 1 - l.l_discount ) ) AS revenue
RETURN
	n.n_name,
	revenue
ORDER BY
	revenue DESC;
