
DROP DATABASE IF EXISTS books;
CREATE DATABASE books;

USE books;

--
-- Table structure for table `books`
--


CREATE TABLE books (
  isbn char(20) PRIMARY KEY,
  author char(50) DEFAULT NULL,
  title char(100) DEFAULT NULL,
  price float(4,2) DEFAULT NULL
) ;

--
-- Dumping data for table `books`
--


INSERT INTO `books`
VALUES ('1491918667','Robin Nixon','Learning PHP, MySQL & JavaScript: With jQuery, CSS & HTML5',35.25),
('0672329166','Luke Welling','PHP and MySQL Web Development',32.67),
('0857522329','Paula Hawkins','The Girl on the Train',6.49),
('159413815X','Anthony Doerr','All the Light We Cannot See',13.60),
('0596517742','Douglas Crockford','JavaScript: The Good Parts',21.35),
('0321804333','Bill Phillips','Android Programming: The Big Nerd Ranch Guide',27.43),
('0062349546','Ann Patchett','State of Wonder',6.25),('0061340642','Ann Patchett','Run',11.82),
('0156006219','Ann Patchett','The Magician\'s Assistant',11.81);


--
-- Table structure for table `customers`
--


CREATE TABLE customers (
  customerid int(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name char(50) NOT NULL,
  address char(100) NOT NULL,
  city char(30) NOT NULL
);

--
-- Dumping data for table `customers`
--

INSERT INTO customers VALUES
(1,'Cindy Howard','123 Main Street','Toronto'),
(2,'Ray Klump','One University Parkway','Romeoville'),
(3,'Steve Berger','1038 Canada Place','Vancouver'),
(44,'Barak Obama','1600 Pennsylvania Avenue','Washington DC');

--
-- Table structure for table `orders`
--


CREATE TABLE orders (
  orderid int(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
  customerid int(10) unsigned NOT NULL,
  amount float(6,2) DEFAULT NULL,
  date date NOT NULL,
  CONSTRAINT orders_fk_customers FOREIGN KEY (customerid) 
  REFERENCES customers(customerid)
);

--
-- Dumping data for table `orders`
--

INSERT INTO orders VALUES
(1,3,23.64,'2015-03-02'),
(2,1,27.43,'2015-02-15'),
(3,2,20.09,'2015-02-19'),
(4,3,82.29,'2015-03-01');


--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;

CREATE TABLE order_items (
  orderid int(10) unsigned NOT NULL,
  isbn char(13) NOT NULL,
  quantity tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (orderid,isbn),
  CONSTRAINT orderitems_fk_order FOREIGN KEY (orderid) REFERENCES orders(orderid),
  CONSTRAINT orderitems_fk_book FOREIGN KEY (isbn) references books(isbn)
);

--
-- Dumping data for table `order_items`
--

INSERT INTO order_items VALUES
(1,'0061340642',2),
(2,'0321804333',1),
(3,'159413815X',1),
(3,'0857522329',1),
(4,'0321804333',3);



--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  `name` varchar(20) PRIMARY KEY NOT NULL,
  `password` varchar(123) DEFAULT NULL
);

--
-- Dumping data for table `users`
--

INSERT INTO users VALUES ('testuser','$5$rounds=10000$g46.eY0wJuobIXx2$Y9nPYjU3YnwHDPTVuj42XdopVZOyOFqc7fogWjxl6f8');
