package fi.oamk.bodymassindex

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var heightInput by mutableStateOf("")
    private var height: Float = 0.0f
        get(){
            return heightInput.toFloatOrNull() ?: 0.0f
        }
    var weightInput by mutableStateOf("")
    private var weight: Float = 0.0f
        get(){
            return weightInput.toFloatOrNull() ?: 0.0f
        }
    var bmi: Float = 0.0f
        get(){
            return weight / (height*height)
        }
}