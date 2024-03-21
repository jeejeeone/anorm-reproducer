import anorm.Column.nonNull
import anorm.{Column, MetaDataItem, TypeDoesNotMatch}
import zio.*
import zio.Console.printLine

object Main extends ZIOAppDefault:
  enum SomeEnum(val name: String) {
    case EnumItem extends SomeEnum("enum item")
  }

  case class AnormRow(enumItem: SomeEnum)

  given Column[SomeEnum] =
    nonNull[SomeEnum] { (value, meta) =>
      val MetaDataItem(qualified, _, _) = meta

      value match {
        case string: String if string == "enum item"      => Right(SomeEnum.EnumItem)
        case _ => Left(TypeDoesNotMatch(s"Cannot convert $value"))
      }
    }

  val rowParser = anorm.Macro.namedParser[AnormRow]

  override def run: ZIO[Environment & ZIOAppArgs & Scope, Any, Any] =
    printLine("Welcome to your first ZIO app!")