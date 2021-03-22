package everis.com.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dalvik.system.InMemoryDexClassLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Resultado()
    }

    private fun Resultado(){
        Calcular_BTN.setOnClickListener{
            val Result = Calcular(Peso_EDV.text.toString(),ALtura_EDV.text.toString())
            Abrindo_Tela(Result)
        }
    }
    private fun Calcular(peso:String,altura:String):Float{
        val Peso = peso.toFloatOrNull()
        val Altura = altura.toFloatOrNull()
        var IMC:Float = 0.0f

        if (Peso != null && Altura != null){
            IMC = Peso / (Altura * Altura)
        }
        return IMC
    }
    private fun Abrindo_Tela(Result:Float){
        val Nova_Tela = Intent(this, ResultActivity::class.java)
        Nova_Tela.putExtra("Restultado", Result)
        startActivity(Nova_Tela)
    }
}