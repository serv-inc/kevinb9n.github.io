package site.kevinb9n.javafx

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.stage.Stage

fun main() = Application.launch(HelloFX::class.java)

class HelloFX : Application() {
  override fun start(stage: Stage) {
    val javaVersion = System.getProperty("java.version")
    val javafxVersion = System.getProperty("javafx.version")

    val pane = StackPane()
    pane.children += Label("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")

    stage.scene = Scene(pane, 640.0, 480.0)
    stage.show()
  }
}
