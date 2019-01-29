API key for **Giant Bomb**:  a27aa22010c29559d6fec67de238b8d50337ff34
?api_key=a27aa22010c29559d6fec67de238b8d50337ff34&format=json

API documentation: https://www.giantbomb.com/api/documentation

Apache tutorial: http://hc.apache.org/httpclient-3.x/tutorial.html

JSON to Java: https://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/

**LINK FORMAT:**
http://www.giantbomb.com/api/[RESOURCE-TYPE]/[RESOURCE-ID]/?api_key=[YOUR-KEY]&format=[RESPONSE-DATA-FORMAT]&field_list=[COMMA-SEPARATED-LIST-OF-RESOURCE-FIELDS]

**SEARCH:**
http://www.giantbomb.com/api/search?api_key=[YOUR-KEY]&format=[RESPONSE-DATA-FORMAT]&query=[YOUR-SEARCH]&resources=[SOME-TYPES]
...&field_list=name&format=json&query="metal"&limit=100&resources=game

**FILTERS:**
&field_list=name&filter=platforms:146,original_release_date:2015-10-10|2018-10-10

-------------------------------------------------------------
Home Page:
 - Search games by name -> Results Page
 - Choose games by month in year and platform -> Results Page

Results Page:
 - List of games - click on one to go to -> Details Page

Details Page:
 - Game details
 - Add game to favorites -> Favorites Page

Favorites Page:
 - List of favorite games -> Edit Game Page, -> Delete, -> Details
 - Stats - genres, themes, platforms etc -> Sublists