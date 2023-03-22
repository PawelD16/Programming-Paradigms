package zadanie2.users

import zadanie2.authoritazionLevels.*

class SRSWUser(secretString: String) extends UserClass[Super, Super](secretString)