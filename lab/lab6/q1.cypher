MATCH
	( li:LineItem )
WHERE
	li.l_shipdate <= 20190606
WITH
	li.l_returnflag AS l_returnflag,
	li.l_linestatus AS l_linestatus,
	SUM( li.l_quantity ) AS sum_qty,
	SUM( li.l_extendedprice ) AS sum_base_price,
	SUM( li.l_extendedprice * ( 1 - li.l_discount ) ) AS sum_disc_price,
	SUM( li.l_extendedprice * ( 1 - li.l_discount ) * ( 1 + li.l_tax ) ) AS sum_charge,
	AVG( li.l_quantity ) AS avg_qty,
	AVG( li.l_extendedprice ) AS avg_price,
	AVG( li.l_discount ) AS avg_disc,
	COUNT( * ) AS count_order
RETURN l_returnflag, l_linestatus, sum_qty, sum_base_price, sum_disc_price, sum_charge, avg_qty, avg_price, avg_disc, count_order
ORDER BY l_returnflag, l_linestatus;
