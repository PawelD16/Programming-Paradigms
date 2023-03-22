package zadanie2.users

import zadanie2.authoritazionLevels.*

class HRHWUser(secretString: String) extends UserClass[High, High](secretString)