# Telegram-Bot

In order to start the project you need to create a database (an example is on the backend branch of the Telegram-Bot/backend/telegram_bot/database.txt file).

bot.token=1134845828:AAH8VJfghnhRGA-JMd1eN1j758Mrrtali6E
bot.username=KliosovTaskTouristBot


Bot can be found like this @KliosovTaskTouristBot.



In order to add a new city you will need to send a post request and be sure to specify the name and description fields.

http://localhost:8080/api/city POST request
the body should look like this:
{
	"name": "Test",
	"description": "Test"
}


In order to change the city you need to send a post request to the same address only specify cityId.
the body should look like this:
{
	"ciyuId": 13,
	"name": "City",
	"description": "TestCity"
}


In order to delete the city you need to send DELETE request.
http://localhost:8080/api/city/delete/13 DELETE request. http://localhost:8080/api/city/delete/{cityID}
