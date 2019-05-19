**GAMING BACKLOG**

Live version on Heroku using ClearDB:
https://gamingbacklog.herokuapp.com

What it does:

- Connects to GiantBomb API
- Gets and presents game details from GB wiki about a game - it can be random, chosen from a time period or searched by name
- Allows to add this game to personal backlog list
- Allows to comment on any game and see other users' backlogs
- Provides basic user and access management using hashed passwords, validators and a filter
- Keeps data in local database so it doesn't have to download it again from GB
- Validates and sanitizes the data from GB so that unpredictable results don't crash the app

What is uses:

- Java
- Spring
- Hibernate
- Jackson
- MySQL
- JSP
- JSTL
- jBCrypt
- Bootstrap

Game details screen:
![
](gb1.png)

Backlog list screen:
![
](gb2.png)


