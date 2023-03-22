package zadanie2.users

import zadanie2.authoritazionLevels.*

class HRSWUser(secretString: String) extends UserClass[High, Super](secretString)