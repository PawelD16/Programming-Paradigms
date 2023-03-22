package zadanie2.users

import zadanie2.authoritazionLevels.*

class LRSWUser(secretString: String) extends UserClass[Low, Super](secretString)