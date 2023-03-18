# SOLUTION: Back End Developer Test - Apply Digital

## Description
The server, once an hour, connect to the API Hacker News URL: https://hn.algolia.com/api/v1/search_by_date?query=java and inserts all the data from the API into a database.

The service created to retrive the post from the database is available at http://localhost:8080/article/{pageNumber} (POST request)
you should pass the page number wich you wanna to see.

The service created to remove post from the database are available at http://localhost:8080/article/{objectID} (DELETE request)
you sholud pass the objectID (string) wich you can find in each article returned at the first service for example ("objectID": "35212812")

## Deployment Process
1. Download the ApplyDigital folder. This folder contains the docker-compose file and the sql folder.
2. In the sql folder you will find the tables.sql file. Do not delete this file
3. To run the application just execute the command 
		
	docker-compose up

4. The database scripts are automatically executed when you run the docker-compose up command.

Thank you.
