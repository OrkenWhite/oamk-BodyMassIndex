package fi.oamk.bodymassindex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.oamk.bodymassindex.ui.theme.BodyMassIndexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BodyMassIndexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BodyMassIndex()
                }
            }
        }
    }
}

@Composable
fun BodyMassIndex(bmiViewModel: BmiViewModel = viewModel()) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Text(stringResource(R.string.bmiTitle), style = MaterialTheme.typography.h5, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value =bmiViewModel.heightInput ,label = {Text(stringResource(R.string.height))}, modifier = Modifier.fillMaxWidth(), onValueChange ={bmiViewModel.heightInput = it})
        OutlinedTextField(value =bmiViewModel.weightInput ,label = {Text(stringResource(R.string.weight))}, modifier = Modifier.fillMaxWidth(), onValueChange ={bmiViewModel.weightInput = it})
        Text(stringResource(R.string.bmiIs) + String.format("%.2f",bmiViewModel.bmi))
    }
}