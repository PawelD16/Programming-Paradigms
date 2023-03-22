package zadanie2.users

import zadanie2.authoritazionLevels.*

class SRLWUser(secretString: String) extends UserClass[Super, Low](secretString)