#README

**Purpose of application:**
-To showcase searching through images by typing text and by applying additional filters 
through toggling buttons on the side. 
-All the images are cards from a board game called Pax Pamir 2nd edition. The nomenclature of the 
cards can be seen in the "Pax Pamir Symbol and Card Nomenclature" file.

**Description of the board game - Pax Pamir:**
-The board game is about the struggle in Afghanistan and Central Asia in the 19th century where 
the Europeans used Central Asia as a playground for their own rivalries. This period in history
is commonly reffered to as "The Great Game".


**How to use application:**
- Run the controller through IntelliJ IDE and the user can interact with radio button toggles
and a search field
- The user is able to use the text field to search for a specific card by:
	- Core actions (alo known as impact icons, and are activated when the card is played)
		- Road -Army -Leverage -Spy -Tribe -Change Favoured Suit
	- Card-based actions (These actions are used on the players turn to influence the map and achieve a dominant position in the game):
		- Tax - Gift - Build - March - Betray - Battle
	- Card name (The name of the card, for example: "Anglo-Persian Trade")
	- Russian/Afghanistan/British patriot/loyalist/prize (Cards can be loyal to a specific faction in the game, either Russian, Afghanistan, or British. Also, they have prizes on the cards indicated on the  bottom of the card by a small bar of color)
	- If card has a prize of any kind
	- If card is a patriot of any kind
- The toggle buttons act as additional filters. The user can filter via:
	- Region
	- Suit
	- Rank (the number of stars on the card, directly below the suit, located in the top left of the card)
The filters are subtractive, meaning that the more toggles you press the less cards will show up. For example: if the user toggles Persia and toggles Economic, then only the cards with both Persia as a region and Economic as a suit will show up.


EXAMPLE TESTS:
#1
	Region Toggle = "Kandahar"
Cards that will be displayed (by card name): *"Baluchi Chiefs", "Bank", "British Regulars", *and* "Charles Masson"*
#2
	Region Toggle = "Kandahar"
	Rank Toggle = 2
Cards that will be displayed (by card name): *"Bank", "British Regulars", *and* "Charles Masson"*
#3 
	Region Toggle = "Kabul"
	Suit Toggle = "Economic"
Cards that will be displayed (by card name): *"Balkh Arsenic Mine"* and *"City of Ghazni"*
#4
	Region Toggle = "Kabul"
	Suit Toggle = "Economic"
	Rank Toggle = 3
Cards that will be displayed (by card name): *"City of Ghazni"*
#5
	Search Field = "tax"
Cards that will be displayed (by card name): *"Baluchi Chiefs"* and *"Anglo-Persian Trade"*
#6
	Search Field = "leverage"
Cards that will be displayed (by card name): *"Anglo-Persian Trade", "Bank", *and* "Bukharan Jews"*
#7
	Search Field = "russian"
Cards that will be displayed (by card name):* "Baluchi Chiefs", "Anglo-Persian Trade", "Allah Quli Bahadur", *and *"British Regulars"*
#8
	Search Field = "patriot" or "loyalist"
Cards that will be displayed (by card name): *"Anglo-Persian Trade", "Army of Indus", *and* "British Regulars"*
#9
	Search Field = "citadel of ghazni"
Cards that will be displayed (by card name): *"Citadel of Ghazni"*
#10
	Search Field = "prize"
Cards that will be displayed (by card name): *"Allah Quli Bahadur", "Anglo-Persian Trade", "Army of the Indus", "Balkh Arsenic Mine", "Baluchi Chiefs", "British Regulars", "Bukharan Jews", *and *"Charles Stoddart"*
#11
	Search Field = "british prize"
Cards that will be displayed (by card name): *"Bukharan Jews"*
#12
	Region Toggle = "Punjab"
	Suit Toggle = "Military"
	Rank Toggle = 3
	Search Field = "march"
Cards that will be displayed (by card name): *"Army of the Indus"*
