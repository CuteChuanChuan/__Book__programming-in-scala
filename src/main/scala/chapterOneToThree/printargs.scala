@main def m2(args: String*): Unit = {
  var i = 0
  while i < args.length do
    println(args(i))
    i += 1
}