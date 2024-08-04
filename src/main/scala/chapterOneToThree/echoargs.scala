
@main def m3(args: String*): Unit = {
  var i = 0
  while i < args.length do
    if i != 0 then print(" ")
    print(args(i))
    i += 1
  println()
}


//@main def m3(args: String*) = {
//  var i = 0;
//  while (i < args.length) {
//    if (i != 0) {
//      print(" ");
//    }
//    print(args(i));
//    i += 1;
//  }
//  println();
//}