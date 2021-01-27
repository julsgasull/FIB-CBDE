// Regions.
CREATE ( America: Region	{ r_name: "America" } )
CREATE ( Asia: Region 		{ r_name: "Asia" } )

// Nations.
CREATE ( USA: Nation 	{ n_name: "USA" } ) 	<-[:CONTAINS]- ( America )
CREATE ( Canada: Nation { n_name: "Canada" } ) 	<-[:CONTAINS]- ( America )
CREATE ( Japan: Nation 	{ n_name: "Japan" } ) 	<-[:CONTAINS]- ( Asia )

// Suppliers.
CREATE ( MicroCenter: Supplier 	{ s_acctbal: 40, s_name: "Micro Center", 	s_address: "742 Evergreen Terrace", s_phone: "123 456 789", s_comment: "American supplier"} ) 		<-[:HAS_SUP]- ( USA )
CREATE ( Amazon: Supplier 		{ s_acctbal: 50, s_name: "Amazon", 			s_address: "963  Pine Garden Lane", s_phone: "987 654 321", s_comment: "Canadiense supplier" } ) 	<-[:HAS_SUP]- ( Canada )
CREATE ( Yamada: Supplier 		{ s_acctbal: 60, s_name: "Yamada", 			s_address: "3286  Coulter Lane", 	s_phone: "842 753 375", s_comment: "Japanses supplier" } ) 		<-[:HAS_SUP]- ( Japan )

// Parts.
CREATE ( ThinkpadT490: Part 	{ p_partKey: 1, p_mfgr: "A", p_size: 1, 	p_type: "Laptop" } )
CREATE ( ThinkpadL13Yoga: Part 	{ p_partKey: 2, p_mfgr: "B", p_size: 123, 	p_type: "Laptop for home" } )
CREATE ( Zenbook14: Part 		{ p_partKey: 3, p_mfgr: "C", p_size: 1, 	p_type: "Standard Laptop" } )
CREATE ( ZenbookFlipS: Part 	{ p_partKey: 4, p_mfgr: "D", p_size: 1, 	p_type: "Laptop" } )

// Line Items.
// Line Items Order 1.
CREATE ( MicroCenterThinkpadT490_Order_1: LineItem 		{ l_returnflag: "1", l_linestatus: "1", l_quantity: 5, l_extendedprice: 5, l_discount: 0.6, l_tax: 0.21, l_shipdate: 20190605 } )
CREATE ( MicroCenterThinkpadL13Yoga_Order_1: LineItem 	{ l_returnflag: "1", l_linestatus: "1", l_quantity: 7, l_extendedprice: 7, l_discount: 0.7, l_tax: 0.21, l_shipdate: 20190602 } )
CREATE ( AmazonZenbook14_Order_1: LineItem 				{ l_returnflag: "1", l_linestatus: "2", l_quantity: 2, l_extendedprice: 2, l_discount: 0.8, l_tax: 0.21, l_shipdate: 20190603 } )
// Line Items Order 2.
CREATE ( AmazonZenbookFlipS_Order_2: LineItem 			{ l_returnflag: "1", l_linestatus: "2", l_quantity: 5, l_extendedprice: 5, l_discount: 0.9, l_tax: 0.21, l_shipdate: 20190604 } )
// Line Items Order 3.
CREATE ( AmazonThinkpadT490_Order_3: LineItem 			{ l_returnflag: "2", l_linestatus: "2", l_quantity: 7, l_extendedprice: 7, l_discount: 0.1, l_tax: 0.21, l_shipdate: 20190605 } )
CREATE ( AmazonThinkpadL13Yoga_Order_3: LineItem 		{ l_returnflag: "2", l_linestatus: "2", l_quantity: 2, l_extendedprice: 2, l_discount: 0.5, l_tax: 0.21, l_shipdate: 20190606 } )
// Line Items Order 4.
CREATE ( YamadaZenbook14_Order_4: LineItem 				{ l_returnflag: "3", l_linestatus: "3", l_quantity: 4, l_extendedprice: 4, l_discount: 0.4, l_tax: 0.21, l_shipdate: 20190706 } )

// Orders.
CREATE ( Order_1: Order { o_orderkey: 1, o_orderdate: 20190501, o_shippriority: 1 } ) <-[:HAS_ORDER]- ( USA )
CREATE ( Order_2: Order { o_orderkey: 2, o_orderdate: 20190502, o_shippriority: 2 } ) <-[:HAS_ORDER]- ( Canada )
CREATE ( Order_3: Order { o_orderkey: 3, o_orderdate: 20191201, o_shippriority: 4 } ) <-[:HAS_ORDER]- ( Canada )
CREATE ( Order_4: Order { o_orderkey: 4, o_orderdate: 20190501, o_shippriority: 4 } ) <-[:HAS_ORDER]- ( Japan )

// Marketing Segments.
CREATE ( Enterprise: MktSegment	{ m_name: "Enterprise" } )
CREATE ( Personal: MktSegment 	{ m_name: "Personal" } )

// Suppliers -SUPPLY-> Parts relations.
CREATE ( MicroCenter ) 	-[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadT490 )
CREATE ( MicroCenter ) 	-[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadL13Yoga )
CREATE ( MicroCenter ) 	-[:SUPPLY { ps_supplycost: 1 }]-> ( Zenbook14 )
CREATE ( MicroCenter )	-[:SUPPLY { ps_supplycost: 1 }]-> ( ZenbookFlipS )
CREATE ( Amazon ) 		-[:SUPPLY { ps_supplycost: 1 }]-> ( Zenbook14 )
CREATE ( Amazon ) 		-[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadT490 )
CREATE ( Amazon ) 		-[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadL13Yoga )
CREATE ( Yamada ) 		-[:SUPPLY { ps_supplycost: 1 }]-> ( Zenbook14 )

// Suppliers -SUPPLIES-> LineItem relations.
CREATE ( MicroCenter ) 	-[:SUPPLIES]-> ( MicroCenterThinkpadT490_Order_1 )
CREATE ( MicroCenter ) 	-[:SUPPLIES]-> ( MicroCenterThinkpadL13Yoga_Order_1 )
CREATE ( Amazon ) 		-[:SUPPLIES]-> ( AmazonZenbook14_Order_1 )
CREATE ( Amazon ) 		-[:SUPPLIES]-> ( AmazonZenbookFlipS_Order_2 )
CREATE ( Amazon ) 		-[:SUPPLIES]-> ( AmazonThinkpadT490_Order_3 )
CREATE ( Amazon ) 		-[:SUPPLIES]-> ( AmazonThinkpadL13Yoga_Order_3 )
CREATE ( Yamada ) 		-[:SUPPLIES]-> ( YamadaZenbook14_Order_4 )

// Orders -HAS-> LineItem relations.
CREATE ( Order_1 ) -[:HAS]-> ( MicroCenterThinkpadT490_Order_1 )
CREATE ( Order_1 ) -[:HAS]-> ( MicroCenterThinkpadL13Yoga_Order_1 )
CREATE ( Order_1 ) -[:HAS]-> ( AmazonZenbook14_Order_1 )
CREATE ( Order_2 ) -[:HAS]-> ( AmazonZenbookFlipS_Order_2 )
CREATE ( Order_3 ) -[:HAS]-> ( AmazonThinkpadT490_Order_3 )
CREATE ( Order_3 ) -[:HAS]-> ( AmazonThinkpadL13Yoga_Order_3 )
CREATE ( Order_4 ) -[:HAS]-> ( YamadaZenbook14_Order_4 )

// Marketing Segments -DOES-> Orders relations.
CREATE ( Enterprise ) -[:DOES]-> ( Order_1 )
CREATE ( Personal )   -[:DOES]-> ( Order_2 )
CREATE ( Enterprise ) -[:DOES]-> ( Order_3 )
CREATE ( Enterprise ) -[:DOES]-> ( Order_4 )
