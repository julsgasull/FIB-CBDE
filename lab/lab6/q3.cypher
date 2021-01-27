MATCH
	( m:MktSegment { m_name:"Enterprise" } ) - [:DOES] -> ( o:Order )
WHERE
	o.o_orderdate < 20190509
MATCH
	(o) - [:HAS] -> ( li:LineItem )
WHERE
	li.l_shipdate > 20190600
WITH
	o,
	SUM( li.l_extendedprice * ( 1 - li.l_discount ) ) AS revenue
RETURN
	o.o_orderkey,
	revenue,
	o.o_orderdate,
	o.o_shippriority
ORDER BY
	revenue DESC,
	o.o_orderdate;
