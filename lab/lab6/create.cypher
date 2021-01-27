[source,cypher]
----
// Regions.
CREATE ( Europe: Region { r_name: "America" } )

// Nations.
CREATE ( USA: Nation { n_name: "USA" } ) <-[:CONTAINS]- ( America )
CREATE ( Canada: Nation { n_name: "Canada" } ) <-[:CONTAINS]- ( America )

// Suppliers.
CREATE ( MicroCenter: Supplier { s_acctbal: 50.4, s_name: "Lenovo", s_address: "742 Evergreen Terrace", s_phone: "123 456 789", s_comment: "American supplier"} ) <-[:HAS_SUP]- ( USA )
CREATE ( Amazon: Supplier { s_acctbal: 76.6, s_name: "Dell", s_address: "742 Evergreen Terrace", s_phone: "987 654 321", s_comment: "Canadiense supplier" } ) <-[:HAS_SUP]- ( Canada )

// Parts.
CREATE ( ThinkpadT490: Part { p_partKey: 1, p_mfgr: "AAA", p_size: 40, p_type: "Laptop" } )
CREATE ( ThinkpadL13Yoga: Part { p_partKey: 2, p_mfgr: "AAA", p_size: 2, p_type: "Laptop for home" } )
CREATE ( Zenbook14: Part { p_partKey: 3, p_mfgr: "AAA", p_size: 40, p_type: "Standard Laptop" } )
CREATE ( ZenbookFlipS: Part { p_partKey: 4, p_mfgr: "AAA", p_size: 40, p_type: "Laptop" } )

// Line Items.
// Line Items Order 1.
CREATE ( MicroCenterThinkpadT490_Order_1: LineItem { l_returnflag: "A", l_linestatus: "A", l_quantity: 1, l_extendedprice: 1.1, l_discount: 0.1, l_tax: 0.21, l_shipdate: 1234567 } )
CREATE ( MicroCenterThinkpadL13Yoga_Order_1: LineItem { l_returnflag: "A", l_linestatus: "A", l_quantity: 10, l_extendedprice: 10.1, l_discount: 0.1, l_tax: 0.21, l_shipdate: 1234568 } )
CREATE ( AmazonZenbook14_Order_1: LineItem { l_returnflag: "A", l_linestatus: "B", l_quantity: 100, l_extendedprice: 100.1, l_discount: 0.1, l_tax: 0.21, l_shipdate: 1234569 } )
// Line Items Order 2.
CREATE ( AmazonZenbookFlipS_Order_2: LineItem { l_returnflag: "B", l_linestatus: "A", l_quantity: 2, l_extendedprice: 2.2, l_discount: 0.2, l_tax: 0.21, l_shipdate: 12345610 } )
// Line Items Order 3.
CREATE ( MicroCenterThinkpadT490_Order_3: LineItem { l_returnflag: "B", l_linestatus: "B", l_quantity: 30, l_extendedprice: 30.3, l_discount: 0.3, l_tax: 0.21, l_shipdate: 12345611 } )
CREATE ( MicroCenterThinkpadL13Yoga_Order_3: LineItem { l_returnflag: "B", l_linestatus: "B", l_quantity: 300, l_extendedprice: 300.3, l_discount: 0.3, l_tax: 0.21, l_shipdate: 12345612 } )
// Line Items Order 4.
CREATE ( AmazonZenbookFlipS_Order_4: LineItem { l_returnflag: "C", l_linestatus: "C", l_quantity: 4, l_extendedprice: 400.4, l_discount: 0.4, l_tax: 0.21, l_shipdate: 12345613 } )

// Orders.
CREATE ( Order_1: Order { o_orderkey: 1, o_orderdate: 1234569876, o_shippriority: 1 } ) <-[:HAS_ORDER]- ( USA )
CREATE ( Order_2: Order { o_orderkey: 2, o_orderdate: 1234569875, o_shippriority: 2 } ) <-[:HAS_ORDER]- ( Canada )
CREATE ( Order_3: Order { o_orderkey: 3, o_orderdate: 1234569874, o_shippriority: 4 } ) <-[:HAS_ORDER]- ( Canada )

// Marketing Segments.
CREATE ( Enterprise: MktSegment { m_name: "enterprise" } )
CREATE ( Personal: MktSegment { m_name: "personal" } )

// Suppliers -SUPPLY-> Parts relations.
CREATE ( MicroCenter )  -[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadT490 )
CREATE ( MicroCenter )  -[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadL13Yoga )
CREATE ( MicroCenter )  -[:SUPPLY { ps_supplycost: 1 }]-> ( Zenbook14 )
CREATE ( MicroCenter )  -[:SUPPLY { ps_supplycost: 1 }]-> ( ZenbookFlipS )
CREATE ( Amazon )       -[:SUPPLY { ps_supplycost: 1 }]-> ( Zenbook14 )
CREATE ( Amazon )       -[:SUPPLY { ps_supplycost: 1 }]-> ( ZenbookFlipS )
CREATE ( Amazon )       -[:SUPPLY { ps_supplycost: 1 }]-> ( ThinkpadL13Yoga )

// Suppliers -SUPPLIES-> LineItem relations.
CREATE ( MicroCenter )  -[:SUPPLIES]-> ( MicroCenterThinkpadT490_Order_1 )
CREATE ( MicroCenter )  -[:SUPPLIES]-> ( MicroCenterThinkpadL13Yoga_Order_1 )
CREATE ( Amazon )       -[:SUPPLIES]-> ( AmazonZenbook14_Order_1 )
CREATE ( Amazon )       -[:SUPPLIES]-> ( AmazonZenbookFlipS_Order_2 )
CREATE ( MicroCenter )  -[:SUPPLIES]-> ( MicroCenterThinkpadT490_Order_3 )
CREATE ( MicroCenter )  -[:SUPPLIES]-> ( MicroCenterThinkpadL13Yoga_Order_3 )
CREATE ( Amazon )       -[:SUPPLIES]-> ( AmazonZenbookFlipS_Order_4 )

// Orders -HAS-> LineItem relations.
CREATE ( Order_1 ) -[:HAS]-> ( MicroCenterThinkpadT490_Order_1 )
CREATE ( Order_1 ) -[:HAS]-> ( MicroCenterThinkpadL13Yoga_Order_1 )
CREATE ( Order_1 ) -[:HAS]-> ( AmazonZenbook14_Order_1 )
CREATE ( Order_2 ) -[:HAS]-> ( AmazonZenbookFlipS_Order_2 )
CREATE ( Order_3 ) -[:HAS]-> ( MicroCenterThinkpadT490_Order_3 )
CREATE ( Order_3 ) -[:HAS]-> ( MicroCenterThinkpadL13Yoga_Order_3 )
CREATE ( Order_4 ) -[:HAS]-> ( AmazonZenbookFlipS_Order_4 )

// Marketing Segments -DOES-> Orders relations.
CREATE ( Enterprise ) -[:DOES]-> ( Order_1 )
CREATE ( Enterprise ) -[:DOES]-> ( Order_2 )
CREATE ( Enterprise ) -[:DOES]-> ( Order_3 )
CREATE ( Personal )   -[:DOES]-> ( Order_4 )
----
