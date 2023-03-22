package zadanie2.users

import zadanie2.authoritazionLevels.*

class LRHWUser(secretString: String) extends UserClass[Low, High](secretString)