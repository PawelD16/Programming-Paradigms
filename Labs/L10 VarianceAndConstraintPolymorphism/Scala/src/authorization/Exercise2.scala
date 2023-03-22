package zadanie2

import zadanie2.authoritazionLevels.*
import zadanie2.users.*

@main
def main(): Unit = {
  //TERMINALTEST!
  val llterminal = Terminal[Low, Low]("LLterminal")
  val lhterminal = Terminal[Low, High]("LHterminal")
  val lsterminal = Terminal[Low, Super]("LSterminal")

  //val hlterminal = Terminal[High, Low]("HLTerminal")
  val hhterminal = Terminal[High, High]("HHTerminal")
  val hsterminal = Terminal[High, Super]("HSterminal")

  //val slterminal = Terminal[Super, Low]("SLTerminal")
  //val shterminal = Terminal[Super, High]("SHTerminal")
  val ssterminal = Terminal[Super, Super]("SSterminal")

  //READTEST!
  val hhuser = HRHWUser("HHUSER")
  llterminal.read(hhuser)
  lhterminal.read(hhuser)
  lsterminal.read(hhuser)
  hhterminal.read(hhuser)
  hsterminal.read(hhuser)
  //ssterminal.read(hhuser)

  val hluser = HRLWUser("HLUSER")
  llterminal.read(hluser)
  lhterminal.read(hluser)
  lsterminal.read(hluser)
  hhterminal.read(hluser)
  hsterminal.read(hluser)
  //ssterminal.read(hluser)

  val hsuser = HRSWUser("HSUSER")
  llterminal.read(hluser)
  lhterminal.read(hluser)
  lsterminal.read(hluser)
  hhterminal.read(hluser)
  hsterminal.read(hluser)
  //ssterminal.read(hluser)

  val lhuser = LRHWUser("LHUSER")
  llterminal.read(lhuser)
  lhterminal.read(lhuser)
  lsterminal.read(lhuser)
  //hhterminal.read(lhuser)
  //hsterminal.read(lhuser)
  //ssterminal.read(lhuser)

  val lluser = LRLWUser("LLUSER")
  llterminal.read(lluser)
  lhterminal.read(lluser)
  lsterminal.read(lluser)
  //hhterminal.read(lluser)
  //hsterminal.read(lluser)
  //ssterminal.read(lluser)

  val lsuser = LRSWUser("LSUSER")
  llterminal.read(lsuser)
  lhterminal.read(lsuser)
  lsterminal.read(lsuser)
  //hhterminal.read(lsuser)
  //hsterminal.read(lsuser)
  //ssterminal.read(lsuser)

  val shuser = SRHWUser("SHUSER")
  llterminal.read(shuser)
  lhterminal.read(shuser)
  lsterminal.read(shuser)
  hhterminal.read(shuser)
  hsterminal.read(shuser)
  ssterminal.read(shuser)

  val sluser = SRLWUser("SLUSER")
  llterminal.read(sluser)
  lhterminal.read(sluser)
  lsterminal.read(sluser)
  hhterminal.read(sluser)
  hsterminal.read(sluser)
  ssterminal.read(sluser)

  val ssuser = SRSWUser("SSUSER")
  llterminal.read(ssuser)
  lhterminal.read(ssuser)
  lsterminal.read(ssuser)
  hhterminal.read(ssuser)
  hsterminal.read(ssuser)
  ssterminal.read(ssuser)

  //WRITETEST!

  //val hhuser = HRHWUser()
  llterminal.write(hhuser)
  lhterminal.write(hhuser)
  //lsterminal.write(hhuser)
  hhterminal.write(hhuser)
  //hsterminal.write(hhuser)
  //ssterminal.write(hhuser)

  //val hluser = HRLWUser()
  llterminal.write(hluser)
  //lhterminal.write(hluser)
  //lsterminal.write(hluser)
  //hhterminal.write(hluser)
  //hsterminal.write(hluser)
  //ssterminal.write(hluser)

  //val hsuser = HRSWUser()
  llterminal.write(hsuser)
  lhterminal.write(hsuser)
  lsterminal.write(hsuser)
  hhterminal.write(hsuser)
  hsterminal.write(hsuser)
  ssterminal.write(hsuser)

  //val lhuser = LRHWUser()
  llterminal.write(lhuser)
  lhterminal.write(lhuser)
  //lsterminal.write(lhuser)
  hhterminal.write(lhuser)
  //hsterminal.write(lhuser)
  //ssterminal.write(lhuser)

  //val lluser = LRLWUser()
  llterminal.write(lluser)
  //lhterminal.write(lluser)
  //lsterminal.write(lluser)
  //hhterminal.write(lluser)
  //hsterminal.write(lluser)
  //ssterminal.write(lluser)

  //val lsuser = LRSWUser()
  llterminal.write(lsuser)
  lhterminal.write(lsuser)
  lsterminal.write(lsuser)
  hhterminal.write(lsuser)
  hsterminal.write(lsuser)
  ssterminal.write(lsuser)

  //val shuser = SRHWUser()
  llterminal.write(shuser)
  lhterminal.write(shuser)
  //lsterminal.write(shuser)
  hhterminal.write(shuser)
  //hsterminal.write(shuser)
  //ssterminal.write(shuser)

  //val sluser = SRLWUser()
  llterminal.write(sluser)
  //lhterminal.write(sluser)
  //lsterminal.write(sluser)
  //hhterminal.write(sluser)
  //hsterminal.write(sluser)
  //ssterminal.write(sluser)

  //val ssuser = SRSWUser()
  llterminal.write(ssuser)
  lhterminal.write(ssuser)
  lsterminal.write(ssuser)
  hhterminal.write(ssuser)
  hsterminal.write(ssuser)
  ssterminal.write(ssuser)

}