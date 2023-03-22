package zadanie2.users

import zadanie2.authoritazionLevels.*

class SRHWUser(secretString: String) extends UserClass[Super, High](secretString)