package zadanie2.users

import zadanie2.authoritazionLevels.*

trait User[+ReadAuthorizationLevel <: Low, +WriteAuthorizationLevel <: Low]:
  def secret: String

  def secret(s: String): Unit