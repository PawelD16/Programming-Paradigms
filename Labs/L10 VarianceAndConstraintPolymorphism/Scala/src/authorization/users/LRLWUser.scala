package zadanie2.users

import zadanie2.authoritazionLevels.*

class LRLWUser(secretString: String) extends UserClass[Low, Low](secretString)