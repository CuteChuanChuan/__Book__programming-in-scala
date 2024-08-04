@main def m4(args: String*) = args.foreach(arg => println(arg))

// explicit type annotation
// @main def m4(args: String*) = args.foreach((arg: String) => println(arg))