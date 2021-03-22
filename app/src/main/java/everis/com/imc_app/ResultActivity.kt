package everis.com.imc_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent:Intent
        intent = getIntent()
        val Restultado:Float = intent.getFloatExtra("Restultado",0.0f)
        Mostra_Restultado(Restultado)

        Return_BTN.setOnClickListener{
            Retornando_Tela()
        }
    }
    private fun Mostra_Restultado(Result:Float){
        if (Result <= 16.0f){
            Resultado_TXV.setText("Seu IMC é: " + Result + " -- Voce esta com magreza grave")
            Resultado_TXV.setTextColor(Color.CYAN)
        }else if (Result > 16.0f && Result <= 17.0f){
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta com magreza moderada")
            Resultado_TXV.setTextColor(Color.BLUE)
        }else if (Result > 17.0f && Result <= 18.5f){
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta com magreza leve")
            Resultado_TXV.setTextColor(Color.GREEN)
        }else if (Result > 18.5f && Result <= 25.0f){
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta saudavel")
            Resultado_TXV.setTextColor(Color.WHITE)
        }else if (Result > 25.0f && Result <= 30.0f){
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta com sobrepeso")
            Resultado_TXV.setTextColor(Color.YELLOW)
        }else if (Result > 30.0f && Result <= 35.0f){
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta com obesidade grau 1")
            Resultado_TXV.setTextColor(Color.MAGENTA)
        }else if (Result > 35.0f && Result <= 40.0f){
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta com obesidade grau 2 (Severa)")
            Resultado_TXV.setTextColor(Color.RED)
        }else{
            Resultado_TXV.setText("Seu IMC é: " + Result.toString() + " -- Voce esta com obesidade grau 3 (Morbida)")
            Resultado_TXV.setTextColor(Color.BLACK)
        }


    }
    private fun Retornando_Tela(){
        val Main_Tela = Intent(this, MainActivity::class.java)
        startActivity(Main_Tela)
        finish()
    }
}