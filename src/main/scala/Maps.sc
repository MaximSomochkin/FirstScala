

val price = Map("Shirt"-> 200, "Pants"->300, "hat"->100)
val salePrice  = price.transform((k,v) =>k->(v -v/10))
//for((k ,v ) <- price) salePrice ++= (k -> v = v - (v / 10))