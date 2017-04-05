create table Products(





)




create table XMAP_Product_Supplier
(
	psid char(10) primary key,
	productid char(10) references Products(productid),
	supplierid char(10) references Suppliers(supplierid),
	productsupplierprice int,
	productsupplierstock int,
	isproductsupplieravailable boolean
)

