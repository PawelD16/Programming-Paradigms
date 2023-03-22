package zadanie2

import zadanie2.authoritazionLevels.*
import zadanie2.users.User

class Terminal[ReadAuthorizationLevel <: Low, WriteAuthorizationLevel <: ReadAuthorizationLevel](private var secretString: String):
  def read(user: User[ReadAuthorizationLevel, _]): Unit =
    user.secret(secretString)

  def write(user: User[_, WriteAuthorizationLevel]): Unit =
    secretString = user.secret