package zadanie2.users

import zadanie2.authoritazionLevels.*

class HRLWUser(secretString: String) extends UserClass[High, Low](secretString)