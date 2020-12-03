INSERT INTO 
	ADDRESS (street, city, state, post_code) 
VALUES
  	('Liam st', 'Sydney', 'NSW', '2762'),
  	('Fitzroy st', 'Melbourne', 'Victoria', '3000'),
  	('George st', 'Sydney', 'NSW', '2000'),
  	('Bond st', 'Sydney', 'NSW', '2000'),
  	('Clarence st', 'Sydney', 'NSW', '2000');
  	
INSERT INTO 
	USER (first_name, last_name, title, gender, address_id) 
VALUES
  	('Paul', 'Petterson', 'Mr', 'male', (SELECT id from ADDRESS WHERE street='Liam st')),
  	('Faz', 'Assir', 'Mr', 'male',(SELECT id from ADDRESS WHERE street='Fitzroy st')),
  	('Suzi', 'Taylor', 'Ms', 'female',(SELECT id from ADDRESS WHERE street='George st')),
  	('Aisha', 'Kent', 'Miss', 'female',(SELECT id from ADDRESS WHERE street='Bond st')),
  	('Miranda', 'Huang', 'Ms', 'female',(SELECT id from ADDRESS WHERE street='Clarence st'));