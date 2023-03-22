import scala.annotation.tailrec

sealed trait HtmlTag

case class AString(text: String) extends HtmlTag

case class Paragraph(list: List[HtmlTag]) extends HtmlTag

case class H1(list: List[HtmlTag]) extends HtmlTag

case class H2(list: List[HtmlTag]) extends HtmlTag

case class H3(list: List[HtmlTag]) extends HtmlTag

case class H4(list: List[HtmlTag]) extends HtmlTag

case class H5(list: List[HtmlTag]) extends HtmlTag

case class H6(list: List[HtmlTag]) extends HtmlTag

case class OrderedList(list: List[HtmlTag]) extends HtmlTag

case class UnorderedList(list: List[HtmlTag]) extends HtmlTag

case class NewLine() extends HtmlTag


def indent_to_string(indent: Int): String = if indent > 0 then "\t" + indent_to_string(indent - 1) else ""

{
  def html_tags_to_string(indent: Int)(tag: HtmlTag): String = {
    def next(l: List[HtmlTag]) = print_list(indent + 1)(l)(false) + "\n" + indent_to_string(indent)

    def nextList(l: List[HtmlTag]) = print_list(indent + 1)(l)(true) + "\n" + indent_to_string(indent)

    ("\n" + indent_to_string(indent)) +
      (tag match {
        case AString(text) => text
        case Paragraph(l) => "<p>" + next(l) + "</p>"
        case OrderedList(l) => "<ol>" + nextList(l) + "</ol>"
        case UnorderedList(l) => "<ul>" + nextList(l) + "</ul>"
        case H1(l) => "<h1>" + next(l) + "</h1>"
        case H2(l) => "<h2>" + next(l) + "</h2>"
        case H3(l) => "<h3>" + next(l) + "</h3>"
        case H4(l) => "<h4>" + next(l) + "</h4>"
        case H5(l) => "<h5>" + next(l) + "</h5>"
        case H6(l) => "<h6>" + next(l) + "</h6>"
        case NewLine() => "<br>"
      })
  }

  def print_list(indent: Int)(l: List[HtmlTag])(is_in_list: Boolean): String = l match {
    case Nil => ""
    case h :: t => (if is_in_list then "\n" + indent_to_string(indent) + "<li>" + html_tags_to_string(indent + 1)(h) + "\n" + indent_to_string(indent) + "</li>"
    else indent_to_string(indent) + html_tags_to_string(indent)(h) + indent_to_string(indent))
      + print_list(indent)(t)(is_in_list)
  }


  def build(title: String)(tag_list: List[HtmlTag]): Unit = {
    def inner_build(tag_list: List[HtmlTag]): String = tag_list match {
      case List() => ""
      case h :: t => html_tags_to_string(2)(h) + inner_build(t)
    }

    print("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<title>" + title + "</title>\n\t</head>\n\t<body>" + inner_build(tag_list) + "\n\t</body>\n</html>\n")
  }
}
build ("tytul")(List(
  H1(List(AString("naglowek1"))),
  Paragraph(List(H2(List(AString("naglowek2"))), NewLine(), H3(List(AString("naglowek3"))), AString("paragraf"))),
  OrderedList(List(
    UnorderedList(List(
      OrderedList(List(
        Paragraph(List(AString("test"), AString("test2"))))),
  AString("element1"), AString("element2"), AString("element3"))),
  Paragraph(List(AString("paragraf2"))), AString("text")))))

