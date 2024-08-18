package com.example.checkboxexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checkboxexample.ui.theme.CheckboxExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckboxExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // innerPadding should be used in the root composable of the screen
                    Column(modifier = Modifier.padding(innerPadding)) {
                        CheckboxSample()

                        var checked by remember { mutableStateOf(true) }
                        LabeledCheckbox(
                            label = "Another box",
                            checked = checked,
                            onCheckedChange = { checked = it })
                        Text(text = "Checkbox is $checked")
                    }
                }
            }
        }
    }
}

@Composable
fun CheckboxSample(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var checked by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Check it")
            Checkbox(checked = checked, onCheckedChange = { checked = it })
        }
        Text(text = "Checkbox is $checked")
    }
}

@Composable
fun LabeledCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
    // All composables should have a modifier parameter
    // The modifier parameter should have a default value of Modifier
    // The modifier parameter should be the first parameter with a default value
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = label)
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxSamplePreview() {
    CheckboxExampleTheme {
        CheckboxSample()
    }
}

@Preview(showBackground = true)
@Composable
fun LabeledCheckboxPreview() {
    CheckboxExampleTheme {
        LabeledCheckbox(
            label = "Check it",
            checked = false,
            onCheckedChange = {}
        )
    }
}