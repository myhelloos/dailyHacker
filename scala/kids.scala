import actors._
import actors.Actor._

case object Poke
case object Feed

class Kid() extends Actor {
    def act() {
        loop {
            react {
                case Poke => {
                    println("Ow...")
                    println("Quit it...")
                }
                case Feed => {
                    println("Gurgle...")
                    println("Burp...")
                }
            }
        }
    }
}

var bart = new Kid().start
var lisa = new Kid().start

println("Ready to poke and feed...")
bart ! Poke
lisa ! Poke
bart ! Feed
lisa ! Feed
