
CREATE TABLE `Electricty_Board` (
  id int NOT NULL AUTO_INCREMENT ,
  Name varchar(50) NOT NULL,
  unitsConsumed int NOT NULL,
  billAmount float NOT NULL,
  PRIMARY KEY (`id`)
) ;
 
ALTER TABLE Electricty_Board AUTO_INCREMENT=10001;
 
INSERT INTO Electricty_Board (name, unitsConsumed, billAmount) 
VALUES ('Prasanna', 10, 300.00);
 
INSERT INTO Electricty_Board (name, unitsConsumed, billAmount) 
VALUES ('Anjali', 12, 330.00);
 
INSERT INTO Electricty_Board (name, unitsConsumed, billAmount) 
VALUES ('Aruna', 11, 320.00);
select * from Electricty_Board