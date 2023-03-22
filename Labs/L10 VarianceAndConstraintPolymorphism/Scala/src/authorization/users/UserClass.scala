package zadanie2.users

import zadanie2.authoritazionLevels.*

class UserClass[+ReadLevel <: Low, +WriteLevel <: Low](private var secretString: String) extends User[ReadLevel, WriteLevel] :
  def secret: String = secretString

  def secret(s: String): Unit =
    secretString = s