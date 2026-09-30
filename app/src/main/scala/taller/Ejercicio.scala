package taller

class Ejercicio() {

  // Punto 1. Recorre n términos: el primero es 1 y cada uno sale del
  // anterior aplicando g. Cada término se eleva a la p y se combina con f.
  // Tal como está devuelve siempre 0 y las pruebas quedan en rojo.
  def opCurrified(n: Int)(p: Int)(f: (Int, Int) => Int)(g: Int => Int): Int = {
    def potencia(b: Int, e: Int): Int = {
      if (e <= 0) 1
      else b * potencia(b, e - 1)
    }
    def loop(actual: Int, faltan: Int): Int = {
      if (faltan <= 1) potencia(actual, p)
      else f(potencia(actual, p), loop(g(actual), faltan - 1))
    }
    loop(1, n)
  }

  // Punto 2. La suma de la sesión con tres grupos de parámetros.
  def suma4(f: Int => Int)(prox: Int => Int)(a: Int, b: Int): Int = {
   if (a > b ) 0
   else f(a) + suma4(f)(prox)(prox(a), b)
  }

  // suma4 con f y prox ya fijados: cuadrados de uno en uno.
  def sumaCuadradosSuc: (Int, Int) => Int = {
    suma4(x => x * x)(x => x + 1)
  }

  // Punto 3. La operación y su valor inicial en los dos primeros grupos.
  def reducirC(op: (Int, Int) => Int)(inicio: Int)
              (f: Int => Int, prox: Int => Int)
              (a: Int, b: Int): Int = {
    if (a > b ) inicio
    else op(f(a) ,reducirC(op)(inicio)(f, prox)(prox(a), b))
  }

  // producto y factorialHOF se escriben con reducirC y nada más.
  def producto(f: Int => Int, prox: Int => Int, a: Int, b: Int): Int = {
    reducirC((x, y) => x * y)(1)(f, prox)(a, b)
  }

  def factorialHOF(n: Int): Int = {
    producto(x => x, x => x + 1, 1, n)
  }

  // Punto 4. Funciones que devuelven funciones.
  def componer(f: Int => Int)(g: Int => Int): Int => Int = {
    (x: Int) => 0 // Completar
  }

  def aplicarN(f: Int => Int)(n: Int): Int => Int = {
    (x: Int) => 0 // Completar
  }

  def sumador(n: Int): Int => Int = {
    (x: Int) => 0 // Completar
  }
}
