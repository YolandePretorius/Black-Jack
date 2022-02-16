README
The app is an implementation of Black Jack game.
User can hit(add a extra card) or stand and this wait for the dealer to show his hand.
Included in the file is a user guide with screen grabs indicating how
the app works as well as issues obtained from Heroku.

CONTACT
Student name: Yolande Pretorius
Student nr: 18068659
WEBSITE
website hosted on heroku (not working)
https://blackjack18038659.herokuapp.com 

RUN WEBPAGE

1.  For local server 8080 and docker (docker file included) to start game: 
2.  Type in URL: http://localhost:8080/assignment2_server_18038659/
3.  First page that will appear is requesting if you are 18 years or older to play black-jack
4.  When button is clicked the cards for the player and dealer will be visible  
5.  The player can choose to hit or stand.
6.  If the player choose hit, the player will receive an extra card. 
    If the player continue to press hit, the player will bust(total player score will be above 21) and the dealer will win.
7.  If the player choose to stand, the dealer will show his cards 
    and start dealing cards if his score is below 17
8.  When the dealer bust, the player will win and if the dealer have a higer score than the player the player will win
9.  As soon as the game is over and the winner determined, player can see his stats (total games played, percentage games won as well as total games won by player and dealer) 
10. Player can choose to replay again as well.


TESTING 
1. Session testing:
- For each servlette a test is implemented to check it a session is created. 
- If there is no session and the player enters a url for hit, stand, state, won, a 404 error will ne thrown. This is tested through the HitNoSession, PossibleMovesTestNoSession, StandTestNosession, StateTestNosession and WonTestNoSession.  
2. Stand and busting testing:
- Busting test uses the HitTillBustTest, this test allows user to hit till their cards is more than 21 and then busts. This result in a 400 Bad request.   
- The StandTest test if the user stand servlet is run, that the servlette is redirected to jack/state 
BUGS: (more of the heroku bugs with screen grabs are discussed in additional document)
    1.  Heroku is not hosting the web app. It causes a few types of errors trying to get the container on heroku. These errors were obtained from the heroku logs. 
    2.  Heroku Error R10 (Boot timeout) -> Web process failed to bind to $PORT within 60 seconds of launch. 

IMPROVEMENTS:
    1. Be able to restart a game after viewing stats.
    2. Percentage of games player won should be rounded to two decimals.
    3. Write test units for won, state and stats servlets.
