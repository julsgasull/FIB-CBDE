MATCH
	( p:Part { p_size : 1 } ) <-[ps:SUPPLY]- ( :Supplier ) <-[:HAS_SUP]- (n) <-[:CONTAINS]- ( r:Region { r_name: "America" } )
WHERE
	p.p_type =~ ".*Laptop$"
WITH
	p,
	MIN( ps.ps_supplycost ) AS minps
MATCH
	(p) <-[ps:SUPPLY { ps_supplycost : minps }]- ( s:Supplier ) <-[:HAS_SUP]- (n) <-[:CONTAINS]- ( r:Region { r_name:"America" } )
RETURN s.s_acctbal, s.s_name, n.n_name, p.p_partKey, p.p_mfgr, s.s_address, s.s_phone, s.s_comment
ORDER BY s.s_acctbal DESC, n.n_name, s.s_name, p.p_partkey;
